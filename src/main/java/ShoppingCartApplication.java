import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCartApplication {

    public static double calculateTotalPrice(double price, int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {

        System.out.println("Select a language: ");
        System.out.println("1. Farsi");
        System.out.println("2. Finnish");
        System.out.println("3. Japanese");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        Locale locale;

        switch (choice) {
            case 1:
                System.out.println("You selected Farsi");
                locale = new Locale("fa", "IR");
                break;
            case 2:
                System.out.println("You selected Finnish");
                locale = new Locale("fi", "FI");
                break;
            case 3:
                System.out.println("You selected Japanese");
                locale = new Locale("ja", "JP");
                break;
            default:
                System.out.println("Selected language is not supported. Defaulting to English.");
                locale = new Locale("en", "US");
                break;
        }

        ResourceBundle rb;
        try {
            rb = ResourceBundle.getBundle("messages", locale);
        } catch (Exception e) {
            System.out.println("Selected language is not supported. Defaulting to English.");
            rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        }

        System.out.println(rb.getString("itemcount"));
        int itemCount = scanner.nextInt();

        double[] cart = new double[itemCount];

        for (int i = 0; i < itemCount; i++) {
            System.out.print(rb.getString("itemprice"));
            double itemPrice = scanner.nextDouble();
            System.out.print(rb.getString("itemquantity"));
            int itemQuantity = scanner.nextInt();
            double totalCost = calculateTotalPrice(itemPrice, itemQuantity);
            String totalMessage = MessageFormat.format(rb.getString("itemtotal"), String.format("%.2f", totalCost));
            System.out.println(totalMessage);
            cart[i] = totalCost;
        }

        double cartTotal = Arrays.stream(cart).sum();

        String totalMessage = MessageFormat.format(rb.getString("carttotal"), String.format("%.2f", cartTotal));
        System.out.println(totalMessage);
    }
}
