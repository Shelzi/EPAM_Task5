import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final int PURCHASES_NUMBER = 6;
        Purchase maxCostPurchase = new Purchase();
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
            boolean isAllPurchaseEquals = false;
            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchaseFactory.getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);
                if (purchases[i].getCost().compareTo(maxCostPurchase.getCost()) > 0) {
                    maxCostPurchase = purchases[i];
                }
                if (i > 0) { // What I need to do? In one single cycle? I don't understand...
                    isAllPurchaseEquals = purchases[i].equals(purchases[i - 1]);
                }
            }
            System.out.println(maxCostPurchase);
            System.out.printf("Are all purchases are equal - %b", isAllPurchaseEquals);
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }

    }
}