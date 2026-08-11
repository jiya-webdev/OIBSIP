import java.util.Random;
import java.util.Scanner;

public class JiyaChaudhary_Task2 {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String playAgain;

        do {
            int number = random.nextInt(100) + 1;
            int maxAttempts = 5;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("================================");
            System.out.println("     NUMBER GUESSING GAME");
            System.out.println("================================");
            System.out.println("I have chosen a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    System.out.println("Attempts used: " + attempts);
                    guessed = true;
                    break;

                } else if (guess < number) {
                    System.out.println("Too Low!");

                } else {
                    System.out.println("Too High!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + number);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\nThank you for playing!");
        sc.close();
    }
}