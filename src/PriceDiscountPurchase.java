import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {
    private double discount;

    public PriceDiscountPurchase() {
    }

    public PriceDiscountPurchase(double discount, String name, Byn price, int number) {
        super(name, price, number);
        this.discount = discount;
    }

    public PriceDiscountPurchase(Scanner scanner) {
        super(scanner);
        this.discount = scanner.nextDouble();
    }

    public PriceDiscountPurchase(double discount, Purchase purchase) {
        super(purchase);
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        return super.getCost().mul(100 - discount / 100);
    }

    @Override
    public String toString() {
        return String.format("%s;%.2f",(super.toString()), discount);
    }
}










