import java.util.*;

public class TransactionCategoryEngine {

        public static void main(String[] args) {

                ArrayList<Transaction> transactions = new ArrayList<>();

                // Groceries
                transactions.add(new Transaction(
                                "TXN001", "Shoprite", "POS SHOPRITE IBADAN",
                                25000, "Groceries"));

                transactions.add(new Transaction(
                                "TXN004", "FoodCo", "POS FOODCO IBADAN",
                                18200, "Groceries"));

                transactions.add(new Transaction(
                                "TXN007", "SPAR", "SPAR SUPERMARKET",
                                32000, "Groceries"));

                transactions.add(new Transaction(
                                "TXN010", "Justrite", "JUSTRITE SUPERMARKET",
                                14800, "Groceries"));

                transactions.add(new Transaction(
                                "TXN013", "Market Square", "MARKET SQUARE IBADAN",
                                21500, "Groceries"));

                transactions.add(new Transaction(
                                "TXN016", "Hubmart", "HUBMART SUPERMARKET",
                                28700, "Groceries"));

                transactions.add(new Transaction(
                                "TXN019", "Next Cash & Carry", "NEXT CASH AND CARRY",
                                35000, "Groceries"));

                transactions.add(new Transaction(
                                "TXN022", "Prince Ebeano", "PRINCE EBEANO SUPERMARKET",
                                24600, "Groceries"));

                transactions.add(new Transaction(
                                "TXN025", "Mini Mart", "MINI MART IBADAN",
                                7500, "Groceries"));

                transactions.add(new Transaction(
                                "TXN028", "FreshMart", "FRESHMART FOOD ITEMS",
                                13200, "Groceries"));

                // Transport
                transactions.add(new Transaction(
                                "TXN002", "Bolt", "BOLT TRIP IBADAN",
                                4500, "Transport"));

                transactions.add(new Transaction(
                                "TXN005", "Uber", "UBER TRIP",
                                6000, "Transport"));

                transactions.add(new Transaction(
                                "TXN008", "ABC Transport", "ABC TRANSPORT TICKET",
                                15000, "Transport"));

                transactions.add(new Transaction(
                                "TXN011", "Bolt", "BOLT RIDE",
                                3800, "Transport"));

                transactions.add(new Transaction(
                                "TXN014", "GUO Transport", "GUO TRANSPORT TICKET",
                                17500, "Transport"));

                transactions.add(new Transaction(
                                "TXN017", "Peace Mass Transit", "PEACE MASS TRANSIT",
                                13000, "Transport"));

                transactions.add(new Transaction(
                                "TXN020", "Oando", "OANDO FUEL STATION",
                                20000, "Transport"));

                transactions.add(new Transaction(
                                "TXN023", "MRS", "MRS FILLING STATION",
                                18500, "Transport"));

                transactions.add(new Transaction(
                                "TXN026", "NNPC", "NNPC FUEL PURCHASE",
                                30000, "Transport"));

                transactions.add(new Transaction(
                                "TXN029", "Local Taxi", "TAXI FARE IBADAN",
                                3500, "Transport"));

                // Dining
                transactions.add(new Transaction(
                                "TXN003", "Chicken Republic", "POS CHICKEN REPUBLIC",
                                8500, "Dining"));

                transactions.add(new Transaction(
                                "TXN006", "KFC", "KFC IBADAN",
                                11500, "Dining"));

                transactions.add(new Transaction(
                                "TXN009", "Mr Bigg's", "MR BIGGS FOOD",
                                6500, "Dining"));

                transactions.add(new Transaction(
                                "TXN012", "The Place", "THE PLACE RESTAURANT",
                                12000, "Dining"));

                transactions.add(new Transaction(
                                "TXN015", "Domino's Pizza", "DOMINOS PIZZA IBADAN",
                                14500, "Dining"));

                transactions.add(new Transaction(
                                "TXN018", "Tantalizers", "TANTALIZERS IBADAN",
                                7800, "Dining"));

                transactions.add(new Transaction(
                                "TXN021", "Foodies", "FOODIES RESTAURANT",
                                9500, "Dining"));

                transactions.add(new Transaction(
                                "TXN024", "Rhapsody's", "RHAPSODYS RESTAURANT",
                                22000, "Dining"));

                transactions.add(new Transaction(
                                "TXN027", "Bungalow Restaurant", "BUNGALOW RESTAURANT",
                                16500, "Dining"));

                transactions.add(new Transaction(
                                "TXN030", "Mama's Kitchen", "MAMAS KITCHEN MEAL",
                                5500, "Dining"));

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

                // --- FIXED: Create 'enter' variable outside try block ---
                int enter = 0; 
                try{
                Scanner input = new Scanner(System.in);
                System.out.println("Enter 1: for Groceries 2: for Transport  3: for Dining ");

                enter = input.nextInt();
                } catch (InputMismatchException e) {
                        System.out.println("\n[ERROR] Invalid input type! Please enter numbers only (1, 2, or 3).");
                              // Exits the main method gracefully instead of crashing
                }
                // Display total transaction base on category
                for (Transaction transact : transactions) {

                        switch (enter) {
                                case 1:
                                        if (transact.category.equalsIgnoreCase("Groceries")) {
                                                groceriesTotalAmount += transact.amount;
                                        }
                                        break;

                                case 2:
                                        if (transact.category.equalsIgnoreCase("Transport")) {
                                                transportTotalAmount += transact.amount;
                                        }
                                        break;

                                case 3:
                                        if (transact.category.equalsIgnoreCase("Dining")) {
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

class Transaction {
        String transactionId;
        String merchant;
        String description;
        double amount;
        String category;

        // Constructor
        public Transaction(String transactionId, String merchant, String description, double amount, String category) {
                this.transactionId = transactionId;
                this.merchant = merchant;
                this.description = description;
                this.amount = amount;
                this.category = category;
        }

}