import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.*;

public class LoyaltyCalculator {
    public static void main(String[] args) {
        Patronize sale = new Patronize();
        Redeem convertPoint = new Redeem(); // create object for class redeem

        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------------Bolaji Gas Land -----------------------------------------");
        System.out.println(
                "--------------------------Welcome to Bolaji Gas Land---------------------------------------\n");

        System.out.println("------------------------SALES-------------------------------------\n");
        sale.day1();

        System.out.println("------------------------Day2-----------------------------------\n");
        sale.day2();

        System.out.println("--------------------------------Redeem Point-------------------------------");
        int currentPoint = sale.getNewEarnPoint();
        convertPoint.redeem(currentPoint);

    }
}

class Patronize {
    private static final int VALID_MONTH = 3;
    Multiplier calculate = new Multiplier();

    int day1EarnPoint;
    int day2EarnPoint;
    int newEarnPoint;

    public void day1() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your name:");
        String name = input.nextLine();

        System.out.println("---------------------Welcome to Bolaji Gas Land " + name.toUpperCase()
                + "-------------------------------\n");
        System.out.println("Enter the amount of Gas you want to buy: ");

        // handle inputMismatchException
        if (input.hasNextInt()) {
            int gasAmount = input.nextInt();

            if (gasAmount <= 3000) {
                day1EarnPoint = calculate.tier1(gasAmount);
                System.out.println("\n");
                System.out.println("Thanks for Patronizing us! " + name.toUpperCase());
                System.out.println("\n");
                System.out.println("You bought " + gasAmount + "# Gas");
                System.out.println("\n");
                System.out.println("Your gas amount is categorize to tier 1:--- you earn: " + day1EarnPoint
                        + "Point ------------------Patronize us more to get more point-------------------------");

                // EXPIRE DATE
                PointTrackingInfo track = new PointTrackingInfo(day1EarnPoint, VALID_MONTH);
                System.out.println("---------------------------------------------------------\n");
                System.out.println("Note: These points will expire on: " + track.getFormattedExpired());

            } else if (gasAmount > 3000 && gasAmount <= 10000) {
                day1EarnPoint = calculate.tier2(gasAmount);
                System.out.println("\n");
                System.out.println("Thanks for your Patroning us! " + name.toUpperCase());
                System.out.println("\n");
                System.out.println("You bought " + gasAmount + "# Gas");
                System.out.println("\n");
                System.out.println("Your gas amount is categorize to tier 2:---  You earn: " + day1EarnPoint
                        + "Point ------------------Patronize us more to get more point-------------------------");
                // EXPIRE DATE
                PointTrackingInfo track = new PointTrackingInfo(day1EarnPoint, VALID_MONTH);
                System.out.println("---------------------------------------------------------\n");
                System.out.println("Note: These points will expire on: " + track.getFormattedExpired());

            } else {
                day1EarnPoint = calculate.tier3(gasAmount);
                System.out.println("\n");
                System.out.println("Thanks for Patronizing us! " + name.toUpperCase());
                System.out.println("\n");
                System.out.println("You bought " + gasAmount + "# Gas");
                System.out.println("\n");
                System.out.println("Your gas amount is categorize to tier 3: ---you earn: " + day1EarnPoint
                        + "Point ------------------Patronize us more to get more point-------------------------");

                // EXPIRE DATE
                PointTrackingInfo track = new PointTrackingInfo(day1EarnPoint, VALID_MONTH);
                System.out.println("---------------------------------------------------------\n");
                System.out.println("Note: These points will expire on: " + track.getFormattedExpired());

            }

        } else {
            System.out.println("\n[ERROR] Invalid input type! Please enter only numbers .");
        }
    }

    public void day2() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your name:");

        String name = input.nextLine();

        System.out.println("---------------------Welcome to Bolaji Gas Land " + name.toUpperCase()
                + "-------------------------------\n");
        System.out.println("Enter the amount of Gas you want to buy: ");

        // Handle InputMismatchException
        if (input.hasNextInt()) {

            int gasAmount = input.nextInt();

            if (gasAmount <= 3000) {
                day2EarnPoint = calculate.tier1(gasAmount);
                newEarnPoint = day1EarnPoint + day2EarnPoint;
                System.out.println("\n");
                System.out.println("Thanks for Patronizing us! " + name.toUpperCase());

                System.out.println("\n");

                System.out.println("You bought " + gasAmount + "# Gas");
                System.out.println("\n");
                System.out.println("Your gas amount is categorize to tier 1:--- you earn: " + day2EarnPoint
                        + "Point ------------------Patronize us more to get more point-------------------------\n");

                System.out.println("Your TotalPoint is: " + newEarnPoint + "point");

                // EXPIRE DATE
                PointTrackingInfo track = new PointTrackingInfo(day2EarnPoint, VALID_MONTH);
                System.out.println("---------------------------------------------------------\n");
                System.out.println("Note: These points will expire on: " + track.getFormattedExpired());

            } else if (gasAmount > 3000 && gasAmount <= 10000) {
                day2EarnPoint = calculate.tier2(gasAmount);
                newEarnPoint = day1EarnPoint + day2EarnPoint;
                System.out.println("\n");
                System.out.println("Thanks for Patronizing us! " + name.toUpperCase());
                System.out.println("\n");
                System.out.println("You bought " + gasAmount + "# Gas");
                System.out.println("\n");
                System.out.println("Your gas amount is categorize to tier 2:---  You earn: " + day2EarnPoint
                        + "Point ------------------Patronize us more to get more point-------------------------\n");
                System.out.println("Your TotalPoint is: " + newEarnPoint + "point");

                // EXPIRE DATE
                PointTrackingInfo track = new PointTrackingInfo(day2EarnPoint, VALID_MONTH);
                System.out.println("---------------------------------------------------------\n");
                System.out.println("Note: These points will expire on: " + track.getFormattedExpired());

            } else {
                day2EarnPoint = calculate.tier3(gasAmount);
                newEarnPoint = day1EarnPoint + day2EarnPoint;
                System.out.println("\n");
                System.out.println("Thanks for Patronizing us! " + name.toUpperCase());
                System.out.println("\n");
                System.out.println("You bought " + gasAmount + "# Gas");
                System.out.println("\n");
                System.out.println("Your gas amount is categorize to tier 3: ---you earn: " + day2EarnPoint
                        + "Point ------------------Patronize us more to get more point-------------------------\n");
                System.out.println("Your TotalPoint is: " + newEarnPoint + "point");

                // EXPIRE DATE
                PointTrackingInfo track = new PointTrackingInfo(day2EarnPoint, VALID_MONTH);
                System.out.println("---------------------------------------------------------\n");
                System.out.println("Note: These points will expire on: " + track.getFormattedExpired());

            }

        } else {
            System.out.println("\n[ERROR] Invalid input type! Please enter only numbers .");
        }

    }

    public int getNewEarnPoint() {
        return this.newEarnPoint;
    }

}

class Multiplier {
    public int tier1(int gasAmount) {
        System.out.println(" We use 2% to calculate tier 1, that's 2/100 = 0.02");
        double earnRatio = 0.02;
        int accruePoint = (int) (gasAmount * earnRatio);
        return accruePoint;
    }

    public int tier2(int gasAmount) {
        System.out.println("We use 4% to calculate tier 2, that's 4/100 = 0.04");
        double earnRatio = 0.04;
        int accruePoint = (int) (gasAmount * earnRatio);
        return accruePoint;
    }

    public int tier3(int gasAmount) {
        System.out.println("We use 6% to calculate tier 3 that's 6/100 = 0.06");
        double earnRatio = 0.06;
        int accruePoint = (int) (gasAmount * earnRatio);
        return accruePoint;
    }

}

class PointTrackingInfo {
    private final int points;
    private final LocalDate dateEarned;
    private final LocalDate expiryDate;

    // create constructor
    public PointTrackingInfo(int points, int validMonths) {
        this.points = points;
        this.dateEarned = LocalDate.now();
        this.expiryDate = this.dateEarned.plusMonths(validMonths);
    }

    public int getPoints() {
        return points;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    // check if the point is still valid

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    public String getFormattedExpired() {
        return expiryDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }
}

class Redeem {
    private static final int MAX_REDEEM_POINT_THRESHOLD = 300;

    public void redeem(int newEarnPoint) {
        Scanner input = new Scanner(System.in);
        System.out.println("Did you want to redeem your point: (yes/no)");
        String userInput = input.nextLine();
        if (userInput.equalsIgnoreCase("yes")) {

            System.out.println("Currently your TotalPoint: " + newEarnPoint + "point");
            System.out.println("\n");

            // Redeem Point
            if (newEarnPoint < MAX_REDEEM_POINT_THRESHOLD) {
                System.out.println("---------------------------------------------------------\n");
                System.out.println("You are not eligible to convert your points. Wait until it reaches 300 points.");

            } else {
                // i use 2point = 1#
                int redeemAmount = newEarnPoint / 2;
                System.out.println("---------------------------------------------------------\n");
                System.out.println("You have successfully converted your points!");
                System.out.println("You have #" + redeemAmount);

            }

        } else {
            System.out.println("Thank for your Patronize! see you next time. ");
        }

    }

}