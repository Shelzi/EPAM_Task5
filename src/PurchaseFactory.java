import java.util.Scanner;

public class PurchaseFactory {
    private enum PurchaseKind {
        GENERAL_PURCHASE {
            Purchase getPurchase(Scanner sc) {
                return new Purchase(sc);
            }
        },
        PRICE_DIS_PURCHASE {
            PriceDiscountPurchase getPurchase(Scanner sc) {
                return new PriceDiscountPurchase(sc);
            }
        },
        PERCENT_DIS_PURCHASE {
            PercentDiscountPurchase getPurchase(Scanner sc) {
                return new PercentDiscountPurchase(sc);
            }
        };
        abstract Purchase getPurchase(Scanner sc);
    }
    public static Purchase getPurchaseFromFactory(Scanner sc) {
        PurchaseKind sign = PurchaseKind.valueOf(sc.next());
        switch(sign) {
            case GENERAL_PURCHASE: return PurchaseKind.GENERAL_PURCHASE.getPurchase(sc);
            case PRICE_DIS_PURCHASE: return PurchaseKind.PRICE_DIS_PURCHASE.getPurchase(sc);
            case PERCENT_DIS_PURCHASE: return PurchaseKind.PERCENT_DIS_PURCHASE.getPurchase(sc);
            default : throw new EnumConstantNotPresentException(PurchaseKind.class, sign.name());
        }
    }
}
