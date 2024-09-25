package hms;

/*import java.util.Random; 
import java.util.Scanner; 
  
public class CodsoftTask1 { 
    public static void main(String[] args) 
    { 
  
        // stores actual and guess number 
        int answer, guess; 
  
          // maximum value is 100 
        final int MAX = 100; 
  
        // takes input using scanner 
        Scanner in = new Scanner(System.in); 
  
        // Random instance 
        Random rand = new Random(); 
  
        boolean correct = false; 
  
        // correct answer 
        answer = rand.nextInt(MAX) + 1; 
  
        // loop until the guess is correct 
        while (!correct) { 
  
            System.out.println( 
                "Guess a number between 1 and 100: "); 
  
            // guess value 
            guess = in.nextInt(); 
  
            // if guess is greater than actual 
            if (guess > answer) { 
                System.out.println("Too high, try again"); 
            } 
  
            // if guess is less than actual 
            else if (guess < answer) { 
                System.out.println("Too low, try again"); 
            } 
  
            // guess is equal to actual value 
            else { 
  
                System.out.println( 
                    "Yes, you guessed the number."); 
  
                correct = true; 
            } 
        } 
        System.exit(0); 
    } 
}*/

import java.util.Random;
import java.util.Scanner;

public class CodsoftTask1 {
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int MAX_ATTEMPTS = 10;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        int roundsWon = 0;
        int totalAttempts = 0;

        do {
            playAgain = false;
            int randomNumber = generateRandomNumber(MIN, MAX);
            boolean isGuessed = false;
            int attempts = 0;

            System.out.println("I have generated a number between " + MIN + " and " + MAX + ". Can you guess it?");
            
            while (attempts < MAX_ATTEMPTS && !isGuessed) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number.");
                    isGuessed = true;
                    roundsWon++;
                } else if (guess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!isGuessed) {
                System.out.println("Sorry, you have used all " + MAX_ATTEMPTS + " attempts. The correct number was " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine(); // consume the newline
            String response = scanner.nextLine();
            playAgain = response.equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Game over! You won " + roundsWon + " rounds.");
        System.out.println("Total attempts: " + totalAttempts);
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
