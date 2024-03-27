import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int mini = 1;
        int maxi = 100;
        int attemptsLimit = 5;
        int score = 0;

        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(maxi - mini + 1) + mini;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI've picked a number between " + mini + " and " + maxi + ". You have " + attemptsLimit + " attempts to guess it.");

            while (attempts < attemptsLimit) {
                try {
                    System.out.print("Enter your guess: ");
                    int userGuess = sc.nextInt();
                    attempts++;

                    if (userGuess == randomNumber) {
                        System.out.println("Congratulations! You've guessed the number correctly in " + attempts + " attempts!");
                        score++;
                        guessedCorrectly = true;
                        break;
                    } else if (userGuess < randomNumber) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a valid integer.");
                    sc.nextLine();
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
            }

            System.out.print("Would you like to play again? (yes/no): ");
            String playAgainInput = sc.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Your final score is: " + score);
        sc.close();
    }
}
