import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;



public class LoyaltyCalculator{
    public static void main(String[] args){
        Customer test = new Customer();
        test.customer1();
    }
}

class Multiplier {
    public double tier1() {
        //we are using 1% for tier 1
        BigDecimal percentage = new BigDecimal("1");
        BigDecimal earningRatio = percentage.divide( new BigDecimal("100"));
        return earningRatio.doubleValue();
    }
    public double tier2() {
        //we are using 1.5% for tier 2
        BigDecimal percentage = new BigDecimal("1.5");
        BigDecimal earningRatio = percentage.divide( new BigDecimal("100"));
        return earningRatio.doubleValue();
    }
    public double tier3() {
        //we are using 5% for tier 3
        BigDecimal percentage = new BigDecimal("5");
        BigDecimal earningRatio = percentage.divide( new BigDecimal("100"));
        return earningRatio.doubleValue();
    }

}




class Customer extends Multiplier{

    public int customer1(){
    Scanner input = new Scanner(System.in);
    String name = "Sam";
    double accountBalance = 200000.00;
    String tier = "Tier 1";
    int accruePoint = 0;
    int maximiumRedeemPoint = 300;

    Multiplier multiplier = new Multiplier();
    double tier1EarningRatio = multiplier.tier1();
    
    try{
    System.out.println("Enter your Transaction Amount: ");
    double transaction = input.nextDouble();
    if (transaction > accountBalance){
        System.out.println("Insufficient Balance");
        return 0;
    } 

    else  if(transaction < 1000){
        double newBalance = accountBalance - transaction;
        System.out.println("Thanks for making a transaction with us. Your new balance is: " + newBalance);
        System.out.println("Transaction successful but you did not earn any point. Make sure you make transaction of 1000 or above to be eligible for point.");
        
        accruePoint = 0; 
        return accruePoint;

    }
    
    else{
        double newBalance = accountBalance - transaction;
        accruePoint = (int) (transaction * tier1EarningRatio);
        System.out.println("Thanks for making a transaction with us. Your new balance is: " + newBalance);
        System.out.println("You earned " + accruePoint + " points!");

        if(accruePoint < maximiumRedeemPoint){
            System.out.println("You are not eligible to convert your point wait still it reach 300point");
        }
        else{
            int redeem = accruePoint / 2 * 1;
            System.out.println("You have successfuly convert your point!");
            System.out.println("You have " + redeem + "#");
        }
        return accruePoint;
    }

}catch(InputMismatchException e) {
    System.out.println("Invalid Input!");
    return  1;
} finally{
    input.close();
}

    }

    public  int customer2(){
    Scanner input = new Scanner(System.in);
    String name = "Adigun taiwo";
    double accountBalance = 400000.00;
    String tier = "Tier 2";
    int accruePoint = 0;

    Multiplier multiplier = new Multiplier();
    double tier2EarningRatio = multiplier.tier2();
    
    try{
    System.out.println("Enter your Transaction Amount: ");
    double transaction = input.nextDouble();

  
    if (transaction > accountBalance){
        System.out.println("Insufficient Balance");
        return 0;
    } else 
    if(transaction < 1000){
        double newBalance = accountBalance - transaction;
        System.out.println("Thanks for making a transaction with us. Your new balance is: " + newBalance);
        System.out.println("Transaction successful but you did not earn any point. Make sure you make transaction of 1000 or above to be eligible for point.");
        
        accruePoint = 0; 
        return accruePoint;
    }else{
        double newBalance = accountBalance - transaction;
        accruePoint = (int) (transaction * tier2EarningRatio);
        System.out.println("Thanks for making a transaction with us. Your new balance is: " + newBalance);
        System.out.println("You earned " + accruePoint + " points!");
        return accruePoint;
    }

      }catch(InputMismatchException e){
        System.out.println("Invalid input!");
        return 1;
        
    }

    finally{
        input.close();
    }

    // redeem point 


    }





   
}






