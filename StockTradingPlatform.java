import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    String symbol;
    String name;
    double price;

    Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    void displayStock() {
        System.out.println(symbol + " - " + name + " - $" + price);
    }
}

class Transaction {
    String type;
    String symbol;
    int quantity;
    double price;

    Transaction(String type, String symbol, int quantity, double price) {
        this.type = type;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
    }

    void displayTransaction() {
        System.out.println(type + " | " + symbol + " | Quantity: "
                + quantity + " | Price: $" + price);
    }
}

class User {
    String name;
    double balance;
    ArrayList<String> portfolio = new ArrayList<>();
    ArrayList<Transaction> transactions = new ArrayList<>();

    User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void buyStock(Stock stock, int quantity) {
        double total = stock.price * quantity;

        if (total <= balance) {
            balance = balance - total;

            portfolio.add(stock.symbol + " x " + quantity);

            transactions.add(
                new Transaction("BUY", stock.symbol, quantity, stock.price)
            );

            System.out.println("Stock bought successfully!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void sellStock(Stock stock, int quantity) {
        double total = stock.price * quantity;

        balance = balance + total;

        transactions.add(
            new Transaction("SELL", stock.symbol, quantity, stock.price)
        );

        System.out.println("Stock sold successfully!");
    }

    void displayPortfolio() {
        System.out.println("\nPortfolio:");
        if (portfolio.isEmpty()) {
            System.out.println("No stocks in portfolio.");
        } else {
            for (String stock : portfolio) {
                System.out.println(stock);
            }
        }
    }

    void displayTransactions() {
        System.out.println("\nTransactions:");
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (Transaction transaction : transactions) {
                transaction.displayTransaction();
            }
        }
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stock apple = new Stock("AAPL", "Apple", 180);
        Stock tesla = new Stock("TSLA", "Tesla", 250);
        Stock microsoft = new Stock("MSFT", "Microsoft", 420);

        User user = new User("Kavya", 10000);

        System.out.println("===== STOCK TRADING PLATFORM =====");

        System.out.println("\nMarket Data:");
        apple.displayStock();
        tesla.displayStock();
        microsoft.displayStock();

        System.out.println("\nUser: " + user.name);
        System.out.println("Balance: $" + user.balance);

        System.out.print("\nEnter quantity of Apple shares to buy: ");
        int buyQuantity = sc.nextInt();

        user.buyStock(apple, buyQuantity);

        user.displayPortfolio();

        System.out.println("\nCurrent Balance: $" + user.balance);

        System.out.print("\nEnter quantity of Apple shares to sell: ");
        int sellQuantity = sc.nextInt();

        user.sellStock(apple, sellQuantity);

        System.out.println("\nFinal Balance: $" + user.balance);

        user.displayPortfolio();

        user.displayTransactions();

        sc.close();
    }
}