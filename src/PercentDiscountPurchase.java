import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase {
    private static final int NUMBER_PURCHASE_FORE_DISCOUNT = 20;
    private double discount;

    public PercentDiscountPurchase() {
    }

    public PercentDiscountPurchase(String name, Byn price, int number, double discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public PercentDiscountPurchase(Scanner scanner) {
        super(scanner);
        this.discount = scanner.nextDouble();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        Byn tempCost = super.getCost();
        if (getNumber() >= NUMBER_PURCHASE_FORE_DISCOUNT) {
            tempCost.mul(100 - discount / 100.0, RoundMethod.FLOOR, 2);
        }
        return tempCost;
    }

    @Override
    public String toString() {
        return String.format("%s;%.2f", (super.toString()), discount);
    }
}