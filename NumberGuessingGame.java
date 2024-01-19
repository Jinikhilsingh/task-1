import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Random randomGenerator = new Random();

        int overallScore = 0;
        boolean playAnotherGame = true;

        while (playAnotherGame) {
            int secretNumber = randomGenerator.nextInt(100) + 1;
            int maxAttempts = 10;
            int currentAttempts = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Try to guess the number between 1 and 100.");
            System.out.println("You have a maximum of 10 attempts.");

            while (currentAttempts < maxAttempts) {
                System.out.print("Attempt " + (currentAttempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
                int userGuess = inputScanner.nextInt();
                currentAttempts++;

                if (userGuess == secretNumber) {
                    System.out.println("Wooohoo ! Your guess is correct.");
                    overallScore += maxAttempts - currentAttempts + 1;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = inputScanner.next().toLowerCase();
            playAnotherGame = playAgainInput.equals("yes");
        }

        System.out.println("Thanks for playing! Your total score: " + overallScore);
        inputScanner.close();
    }
}