public class Byn implements Comparable<Byn> {
    private int value;

    public Byn() {
    }

    public Byn(int kopecks) {
        this.value = kopecks;
    }

    public Byn(int rubles, int kopecks) {
        this(rubles * 100 + kopecks);
    }

    public Byn(Byn byn) {
        this(byn.value);
    }

    public Byn add(int add) {
        value += add;
        return this;
    }

    public Byn sub(int add) {
        value -= add;
        return this;
    }

    public Byn mul(double k, RoundMethod roundMethod, int d) {
        value = roundMethod.round(value * k, roundMethod, d);
        return this;
    }

    public Byn round(RoundMethod roundMethod, int d) {
        value = roundMethod.round(value, roundMethod, d);
        return this;
    }

    public int getRubles() {
        return (value / 100);
    }

    public int getCoins() {
        return (value % 100);
    }

    @Override
    public String toString() {
        return String.format("%s", Converter.pennyToRuble(value));
    }

    @Override
    public int compareTo(Byn o) {
        return (value - o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        Byn byn = (Byn) o;
        return value == byn.value;
    }
}