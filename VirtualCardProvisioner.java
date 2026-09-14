import java.util.Scanner;
import java.util.Random;
public class VirtualCardProvisioner {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       Random random = new Random();
       System.out.println("--- 💳 Welcome to Fintech Card Provisioning --- \n");
       // CARD TYPE A: A standard user who just clicks "Generate Card" 
        // We only provide Number and Name. Java will use the OVERLOADED constructor with default limits!
        System.out.print("Enter your full name: ");
        String nameInput = input.nextLine();
        
        String generatedCardNumber = "5399";
        
        for(int i =0; i < 12; i++){
            int digit = random.nextInt(10);
            generatedCardNumber += digit;
        }
        
       virtualCard standardCard = new virtualCard(generatedCardNumber, generatedCardNumber);

        System.out.println(">>> Standard Card Created:");
         System.out.println("Card Number      : " + standardCard.getCardNumber());
        System.out.println("Holder: " + standardCard.getcardHolder());
        System.out.println("Limit Applied: #" + standardCard.getspendingLimit());
        System.out.println("Is Card Active? " + standardCard.getisActive());
        
        System.out.println("\n-----------------------------------------------\n");
        
        // CARD TYPE B: A premium high-net-worth user who gets a custom high limit
        // We provide ALL four inputs. Java will automatically use the PRIMARY constructor!
        virtualCard premiumCard = new virtualCard(generatedCardNumber, nameInput, 5000000.00, true);
        System.out.println(">>> Premium Card Created:");
         System.out.println("Card Number      : " + premiumCard.getCardNumber());
        System.out.println("Holder: " + premiumCard.getcardHolder());
        System.out.println("Limit Applied: #" + premiumCard.getspendingLimit());
        System.out.println("Is Card Active? " + premiumCard.getisActive());
        
        
         System.out.println("\n--- 🔒 Simulating Fraud Event ---");
        // Imagine a user drops their phone or suspects a hack. They tap "Freeze Card" in the app.
        
        standardCard.blockCard();
        System.out.println("Standard Card Active Status Now: " + standardCard.getisActive());
        
      input.close(); 
    }

}

class virtualCard
{
    private String cardNumber;
    private String cardHolder;
    private double spendingLimit;
    private boolean isActive;
    
    // constructor 
    public virtualCard(String cardNumber, String cardHolder, double spendingLimit, boolean isActive){
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.spendingLimit = spendingLimit;
        this.isActive = isActive;
    }
    
     // 🏗️ 2. OVERLOADED CONSTRUCTOR: Takes only two parameters.
    // Real-world use case: When a user requests a basic card, we apply default banking rules.
    public virtualCard(String cardNumber, String cardHolder){
        this(cardNumber, cardHolder, 50000.00, true);
    }
    
    
    // 🔍 Public Getters to display card details safely on a mobile UI
    public String getCardNumber(){
        return this.cardNumber;
    }
    
    public String getcardHolder(){
        return this.cardHolder;
    }
    
    public double getspendingLimit(){
        return this.spendingLimit;
    }
    
    public boolean getisActive(){
        return this.isActive;
    }
    
    // 🛡️ FINTECH BUSINESS RULE: Block a compromised card instantly
    public void blockCard(){
        this.isActive = false;
        System.out.println("⚠️ CARD SECURITY ALERT: Virtual card ending in " + this.cardNumber.substring(this.cardNumber.length()- 4 ) + "has been BLOCKED!");
    }
    
    
    
}



