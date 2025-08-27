import java.util.ArrayList;
import java.util.Scanner;

public class StochMgt {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Stock> stocks = new ArrayList<>();

        int choice;
        do {
            System.out.println("1. Add stock");
            System.out.println("2. Remove stock");
            System.out.println("3. View stock");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the stock name: ");
                    String name = input.next();
                    System.out.print("Enter the stock quantity: ");
                    int quantity = input.nextInt();
                    System.out.print("Enter the stock price: ");
                    double price = input.nextDouble();

                    Stock newStock = new Stock(name, quantity, price);
                    stocks.add(newStock);

                    System.out.println("Stock added successfully");
                    break;

                case 2:
                    System.out.print("Enter the stock name: ");
                    String stockName = input.next();
                    System.out.print("Enter the quantity to remove: ");
                    int removeQuantity = input.nextInt();

                    boolean stockFound = false;
                    for (Stock stock : stocks) {
                        if (stock.getName().equals(stockName)) {
                            stockFound = true;
                            stock.removeQuantity(removeQuantity);
                            System.out.println("Stock removed successfully");
                            break;
                        }
                    }
                    if (!stockFound) {
                        System.out.println("Stock not found");
                    }
                    break;

                case 3:
                    System.out.println("Current stocks:");
                    for (Stock stock : stocks) {
                        System.out.println(stock.toString());
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
                    break;
            }

        } while (choice != 4);

        input.close();
    }
}

class Stock {
    private String name;
    private int quantity;
    private double price;

    public Stock(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void removeQuantity(int quantityToRemove) {
        if (quantityToRemove <= quantity) {
            quantity -= quantityToRemove;
        } else {
            System.out.println("Not enough quantity to remove");
        }
    }

    public String toString() {
        return name + ", quantity: " + quantity + ", price: $" + price;
    }
}