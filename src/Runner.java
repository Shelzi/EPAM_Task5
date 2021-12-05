import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final int PURCHASES_NUMBER = 6;
        Purchase maxCostPurchase = new Purchase();
        try(Scanner sc = new Scanner(new FileReader("src/in.txt"))){
            sc.useLocale(Locale.ENGLISH);
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
            for(int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchaseFactory.getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);
                if (purchases[i].getCost().compareTo(maxCostPurchase.getCost()) > 0) {
                    maxCostPurchase = purchases[i];
                }
                if (purchases[i].equals(purchases[0])) { // What I need to do? In one single cycle? I don't understand...
                }
            }
            System.out.println(maxCostPurchase);
            //объявление массива и другие инициализации

            //цикл для пунктов 2-5

            //вывод результатов выполнения пунктов 4 и 5

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }

    }
}
