import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TripCostCalculator {
    // Method to calculate trip cost
    public static double calculateTripCost(double kilometers, double fuelPrice, double fuelConsumptionPer100Km) {
        double fuelNeeded = (kilometers / 100) * fuelConsumptionPer100Km;
        return fuelNeeded * fuelPrice;
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

        // Ask user for the distance to travel
        System.out.print(rb.getString("kilometers"));
        double kilometers = scanner.nextDouble();

        // Ask user for the fuel price per liter
        System.out.print(rb.getString("fuelprice"));
        double fuelPrice = scanner.nextDouble();

        // Define fuel consumption rate (liters per 100 km)
        double fuelConsumptionPer100Km = 5.0; // Example: 5 liters per 100 km

        // Calculate total cost of the trip
        double totalCost = calculateTripCost(kilometers, fuelPrice, fuelConsumptionPer100Km);

        // Display the total cost
        String totalMessage = MessageFormat.format(rb.getString("fueltotal"), String.format("%.2f", totalCost));
        System.out.println(totalMessage);

        scanner.close();
    }
}