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
        Byn tempCost = super.getCost();
        if (getNumber() >= NUMBER_PURCHASE_FORE_DISCOUNT) {
            tempCost.mul(100 - DISCOUNT / 100.0);
        }
        return tempCost;
    }
}
