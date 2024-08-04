import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int start = 1;
        int end = 100;
        int maxAttempts = 10;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        while (true) {
            roundsPlayed++;
            System.out.println("\nRound " + roundsPlayed + ": Guess the number between " + start + " and " + end);
            int randomNumber = random.nextInt(end - start + 1) + start;
            int attempts = playRound(scanner, randomNumber, maxAttempts);
            totalAttempts += attempts;

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total rounds played: " + roundsPlayed);
        System.out.println("Total attempts: " + totalAttempts);
        if (roundsPlayed > 0) {
            System.out.printf("Average attempts per round: %.2f%n", (double) totalAttempts / roundsPlayed);
        }
        
        scanner.close();
    }

    private static int playRound(Scanner scanner, int randomNumber, int maxAttempts) {
        int attempts = 0;

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too low!");
            } else if (guess > randomNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                return attempts;
            }
        }

        System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + randomNumber + ".");
        return maxAttempts;
    }
}
