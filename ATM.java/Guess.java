import java.util.Scanner;
import java.util.Random;

public class Guess {
    public void NumRandom() {
        // Creating an object of the Random class
        Random ran = new Random();
        // Generating a number between 0-100
        int Num = ran.nextInt(101);
        // Calling the guessNum method
        guessNum(Num);
    }

    public void guessNum(int Num) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("!-- Welcome to the Number Guessing Game --!");
            System.out.println("<-- Guess the number between 0-100 -->");
            
            int Num2 = sc.nextInt();

            // Check if the number is between 0-100 or not
            while (Num2 < 0 || Num2 > 100) {
                System.out.println("<-- Guess the number between 0-100 -->");
                Num2 = sc.nextInt();
            }

            int tries = 0;
            while (Num2 != Num) {
                tries++;
                System.out.println("Oops! Wrong guess");
                if (Num > Num2) {
                    System.out.println("Hint --> The answer is greater than "+Num2);
                } else {
                    System.out.println("Hint --> The answer is smaller than "+Num2);
                }
                System.out.println("Guess again --> ");
                Num2 = sc.nextInt();

                // Check if the number is between 0-100 or not
                while (Num2 < 0 || Num2 > 100) {
                    System.out.println("<-- Guess the number between 0-100 -->");
                    Num2 = sc.nextInt();
                }
            }

            System.out.println("Hurray! Guess is correct! You won the game");
            System.out.println("Your Score is --> " + tries);

            System.out.println("Do you want to play again (Press 1 to play or 0 to exit)");
            int ch = sc.nextInt();

            if (ch == 1) {
                NumRandom();
            } else {
                System.out.println("Thank you! Well Played");
                return;
            }
        }
    }

    public static void main(String[] args) {
        Guess g = new Guess();
        g.NumRandom();
    }
}