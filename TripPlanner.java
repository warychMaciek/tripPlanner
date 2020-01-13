import java.util.Scanner;
import java.lang.Math;

public class TripPlanner {
    public static void main(String[] args) {
        greeting();
        travelTimeAndBudget();
        timeDifference();
        countryArea();
        haversineFormula();


    }

    // that method is used to greet user
    public static void greeting() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String destination = input.nextLine();
        System.out.println("Great! " + destination + " sounds like a great trip.");
        System.out.println("***********\n");
    }

    //part 2 - questions about travel time and budget
    public static void travelTimeAndBudget() {
        Scanner input = new Scanner(System.in);
        System.out.print("How many days are you going to spend travelling? ");
        int days = input.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        int money = input.nextInt();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String symbol = input.next();
        System.out.print("How many " + symbol + " are there in 1 USD? ");
        double exchange = input.nextDouble();

        System.out.println("\nIf you are travelling for " + days + " days that is the same as " + 24 * days + " hours or " + (24 * days) * 60 + " minutes");
        System.out.println("If you are going to spend " + money + " USD tha means per day you can spend up to " + ((double) ((int) (((double) money / (double) days) * 100))) / 100 + " USD");
        System.out.println("Your total budget in " + symbol + " is " + money * exchange + " " + symbol + ", which per day is " + ((double)((int) (((money * exchange) / days) * 100))) / 100 + " " + symbol);
        System.out.println("***********\n");

    }

    //part 3 - counting time difference between home and destination
    public static void timeDifference() {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        int time = input.nextInt();
        int midnight = 0 + (time % 24);
        int noon = 12 + (time % 24);
        System.out.println("That means that when it is midnight at home it will be " + midnight + ":00 in your travel destination and when it is noon at home it will be " + noon + ":00\n***********\n");

    }

    //part 4 - country area
    public static void countryArea() {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the square area of your destination country in km2? ");
        double area = input.nextDouble();
        double miles = ((double) ((int) ((area / 2.59000259000259) * 100))) / 100;
        System.out.println("In miles2 that is " + miles + "\n***********\n");
    }

    //part 5 - Haversine formula
    public static void haversineFormula() {
        Scanner input = new Scanner(System.in);
        System.out.println("What is latitude of your home?");
        System.out.print("Degrees? ");
        double phiA1 = input.nextDouble();
        System.out.print("Minutes? ");
        double phiA2 = input.nextDouble();
        System.out.print("Seconds? ");
        double phiA3 = input.nextDouble();
        System.out.print("N or S? ");
        String northSouth = input.next();
        double phiA;

        if (northSouth.equals("S")) {
            phiA = (phiA1 + (phiA2 / 60) + (phiA3 / 3600)) * (-1);
        }
        else {
            phiA = phiA1 + (phiA2 / 60) + (phiA3 / 3600);
        }

        double phiARad = Math.toRadians(phiA);

        System.out.println("What is longitude of your home?");
        System.out.print("Degrees? ");
        double lambdaA1 = input.nextDouble();
        System.out.print("Minutes? ");
        double lambdaA2 = input.nextDouble();
        System.out.print("Seconds? ");
        double lambdaA3 = input.nextDouble();
        System.out.print("E or W? ");
        String eastWest = input.next();
        double lambdaA;

        if (eastWest.equals("W")) {
            lambdaA = (lambdaA1 + (lambdaA2 / 60) + (lambdaA3 / 3600)) * (-1);
        }
        else {
            lambdaA = lambdaA1 + (lambdaA2 / 60) + (lambdaA3 / 3600);
        }

        double lambdaARad = Math.toRadians(lambdaA);

        System.out.println("What is latitude of your destination?");
        System.out.print("Degrees? ");
        double phiB1 = input.nextDouble();
        System.out.print("Minutes? ");
        double phiB2 = input.nextDouble();
        System.out.print("Seconds? ");
        double phiB3 = input.nextDouble();
        System.out.print("N or S? ");
        northSouth = input.next();
        double phiB;

        if (northSouth.equals("S")) {
            phiB = (phiB1 + (phiB2 / 60) + (phiB3 / 3600)) * (-1);
        }
        else {
            phiB = phiB1 + (phiB2 / 60) + (phiB3 / 3600);
        }

        double phiBRad = Math.toRadians(phiB);

        System.out.println("What is longtitude of your destination?");
        System.out.print("Degrees? ");
        double lambdaB1 = input.nextDouble();
        System.out.print("Minutes? ");
        double lambdaB2 = input.nextDouble();
        System.out.print("Seconds? ");
        double lambdaB3 = input.nextDouble();
        System.out.print("E or W? ");
        eastWest = input.next();
        double lambdaB;

        if (eastWest.equals("W")) {
            lambdaB = (lambdaB1 + (lambdaB2 / 60) + (lambdaB3 / 3600)) * (-1);
        }
        else {
            lambdaB = lambdaB1 + (lambdaB2 / 60) + (lambdaB3 / 3600);
        }

        double lambdaBRad = Math.toRadians(lambdaB);

        double cosPhiA = Math.cos(phiARad);
        double cosPhiB = Math.cos(phiBRad);
        double havPhi = Math.sin((phiBRad - phiARad) / 2) * Math.sin((phiBRad - phiARad) / 2);
        double havLambda = Math.sin((lambdaBRad - lambdaARad) / 2) * Math.sin((lambdaBRad - lambdaARad) / 2);

        double hav = havPhi + cosPhiA * cosPhiB * havLambda;
        double distance = 2 * 6371 * Math.asin(Math.sqrt(hav));
        System.out.println("The distance between your home and destination is " + distance + " km.");
    }
}
