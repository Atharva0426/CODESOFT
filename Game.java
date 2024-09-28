import java.util.Scanner;
import java.util.Random;

public class Game {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 5;  
        int score = 0; 
        
        System.out.println("-----WELCOME TO THE GAME-----");

        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1; 
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have generated a number between 1 to 100. Try to guess it!\n You get only 5 attempt to guess it ");

            while (attempts < maxAttempts && !guessedCorrectly) {
              System.out.print("\nEnter your guess (Attempt " + (attempts + 1) + "): ");

                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed it.");
                    score++;
                    guessedCorrectly = true;
                } else if (userGuess < randomNumber) {
                    System.out.println("Opps!  Your guess is too low.");
                } else {
                    System.out.println("Opps!  Your guess is too high.");
                }

                if (attempts == maxAttempts && !guessedCorrectly) {
                    System.out.println("You've run out of attempts. The correct number was: " + randomNumber);
                }
            }

           
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        //  user's final score
        System.out.println("\n----GAME OVER----- \nYour final score is: " + score + " round(s) won.");
        scanner.close();
    }
}
