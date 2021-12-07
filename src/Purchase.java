import java.util.Objects;
import java.util.Scanner;

public class Purchase {
    private final String name;
    private Byn price;
    private int number;

    public Purchase() {
        name = "";
        price = new Byn();
    }

    public Purchase(String name, Byn price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Purchase(Scanner sc) {
        name = sc.next();
        price = new Byn(sc.nextInt());
        number = sc.nextInt();
    }

    public Purchase(Purchase purchase) {
        this(purchase.name, purchase.price, purchase.number);
    }

    public String getName() {
        return name;
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
        return new Byn(price).mul(number, RoundMethod.FLOOR, 2);
    }

    public String toString() {
        return String.format("%s;%d;%s", price.toString(), number, getCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) o;
        return number == purchase.number &&
                Objects.equals(name, purchase.name) &&
                Objects.equals(price, purchase.price);
    }
}