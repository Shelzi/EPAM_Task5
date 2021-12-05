import java.util.Objects;
import java.util.Scanner;

public class Purchase {
    private final String NAME;
    private Byn price;
    private int number;

    public Purchase() {
        NAME = "";
        price = new Byn();
    }

    public Purchase(String name, Byn price, int number) {
        this.NAME = name;
        this.price = price;
        this.number = number;
    }

    public Purchase(Scanner sc) {
        NAME = sc.next();
        price = new Byn(sc.nextInt());
        number = sc.nextInt();
    }

    public Purchase(Purchase purchase) {
        this(purchase.NAME, purchase.price, purchase.number);
    }

    public String getNAME() {
        return NAME;
    }

    public Byn getPrice() {
        return price;
    }

    public void setPrice(Byn price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Byn getCost() {
        return new Byn(price).mul(number);
    }

    public String toString() {
        return String.format("%s;%d;%s", price.toString(), number, getCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Purchase purchase = (Purchase) o;
        return number == purchase.number &&
                Objects.equals(NAME, purchase.NAME) &&
                Objects.equals(price, purchase.price);
    }
}

