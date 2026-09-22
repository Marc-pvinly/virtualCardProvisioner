import java.util.*;

public class TransactionCategoryEngine {

        public static void main(String[] args) {

                
                ArrayList<Transaction> transactions = new ArrayList<>();

                // Groceries
                transactions.add(new Transaction(
                                "TXN001", "Shoprite", "POS SHOPRITE IBADAN",
                                25000, Category.GROCERIES));

                transactions.add(new Transaction(
                                "TXN004", "FoodCo", "POS FOODCO IBADAN",
                                18200, Category.GROCERIES ));

              

                // Transport
                transactions.add(new Transaction(
                                "TXN002", "Bolt", "BOLT TRIP IBADAN",
                                4500, Category.TRANSPORT));

                transactions.add(new Transaction(
                                "TXN005", "Uber", "UBER TRIP",
                                6000, Category.TRANSPORT));

                

                // Dining
                transactions.add(new Transaction(
                                "TXN003", "Chicken Republic", "POS CHICKEN REPUBLIC",
                                8500, Category.DINING));

                transactions.add(new Transaction(
                                "TXN006", "KFC", "KFC IBADAN",
                                11500, Category.DINING));
                

                for (Transaction transaction : transactions) {
                        System.out.println(
                                        "----------------------- Merchant Data ---------------------------------------------\n");
                        System.out.println(
                                        transaction.transactionId + " | " +
                                        transaction.merchant + " | " +
                                        transaction.description + " | #" +
                                        transaction.amount + " | " +
                                        transaction.category);
                }

                double groceriesTotalAmount = 0;
                double transportTotalAmount = 0;
                double diningTotalAmount = 0;

                int enter = 0; 
                
                Scanner input = new Scanner(System.in);
                System.out.println("Enter 1: for Groceries 2: for Transport  3: for Dining ");
                if(input.hasNextInt()){

                enter = input.nextInt();
                }else {
                        System.out.println("\n[ERROR] Invalid input type! Please enter numbers only (1, 2, or 3).");
                              // Exits the main method gracefully instead of crashing
                }
                // Display total transaction base on category
                for (Transaction transact : transactions) {

                        switch (enter) {
                                case 1:
                                        if (transact.category.equals(Category.GROCERIES)) {
                                                groceriesTotalAmount += transact.amount;
                                        }
                                        break;

                                case 2:
                                        if (transact.category.equals(Category.TRANSPORT)) {
                                                transportTotalAmount += transact.amount;
                                        }
                                        break;

                                case 3:
                                        if (transact.category.equals(Category.DINING)) {
                                                diningTotalAmount += transact.amount;
                                        }
                                        break;

                                default:
                                        System.out.println("Invalid Input!");
                                        break;
                        }

                }

                System.out.println("-------------------------------------------------------------------\n");
                System.out.println("Total Expenses spend on Groceries: #" + groceriesTotalAmount);

                System.out.println("---------------------------------------------------------------------\n");
                System.out.println("Total Extenses spend on Transport: #" + transportTotalAmount);

                System.out.println("------------------------------------------------------------------------\n");
                System.out.println("Total Extenses spend on Dinig: #" + diningTotalAmount);
                
        }
}


enum Category{
   GROCERIES,
   TRANSPORT,
   DINING
        
} 

class Transaction {
        String transactionId;
        String merchant;
        String description;
        double amount;
        Category category;
        // Constructor
        public Transaction(String transactionId, String merchant, String description, double amount, Category category) {
                this.transactionId = transactionId;
                this.merchant = merchant;
                this.description = description;
                this.amount = amount;
                this.category = category;
                
        }

}