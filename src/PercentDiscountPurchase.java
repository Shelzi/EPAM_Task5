import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase {
    public static final int NUMBER_PURCHASE_FORE_DISCOUNT = 20;
    public static final double DISCOUNT = 25;

    public PercentDiscountPurchase() {
    }

    public PercentDiscountPurchase(String name, Byn price, int number) {
        super(name, price, number);
    }

    public PercentDiscountPurchase(Scanner scanner) {
        super(scanner);
    }

    @Override
    public Byn getCost() {
        return super.getCost().mul(100 - DISCOUNT / 100);
    }

    @Override
    public String toString() {
        return String.format("%s;%.2f", (super.toString()), DISCOUNT);
    }
}
