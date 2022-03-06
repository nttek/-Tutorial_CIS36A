/******************************************************************************

Guessing game: 
1. Create a java class called GuessingGame. 
2. Your program should pick a random integer between 1 and 100.  
3. Then, it should ask the user to guess the number and 
4. should give feedback whether the number is greater than or less than the original number. 
5. You should create a loop, either ask the user for a number of times or until the user guessed 
   the number correctly. The loop should end when the user guesses the number. 

Challenge 1: Give points to the users based on how fast they guess the number and negative points if it takes more than a certain amount of guesses
Challenge 2: Ask the users whether they want to play the game again or you can allow them to play repeatedly. Users should be able to exit the game whenever they want. 

*******************************************************************************/

import java.util.Random;
import java.util.Scanner;

public class GuessingGame
{
  public static void main (String[]args) throws java.io.IOException
  {
    Random rand = new Random ();
    int upperbound = 101;
    //int upperbound = 11; // For testing purposes.
    int int_random = rand.nextInt (upperbound);

    System.out.println ("Welcome to the number guessing game (use -1 to exit)");
    System.out.println ("New Game");
    System.out.print ("Guess the number (0-100): ");
    
    int tries = 0; 
    //int difficulty;   
    long start;
    long finish;
    long timeElapsed;
    double score;

    start = System.currentTimeMillis();
    Scanner in = new Scanner (System.in);
    
    while(true)
    {
        while (!in.hasNextInt ())
        {
            System.out.print ("Invalid input. Please try again: ");
            in.next ();		// What happens if you use nextLine() instead?
        }
        
        int guessed = in.nextInt ();
        if (guessed == -1)
        {
            System.out.println("Thank you for playing.");
            System.out.println("exiting game...");
            break;
        }
        
        else if (guessed < 0 || guessed > 100)
        {
            System.out.print ("Invalid input. Please try again: ");
            continue;
        }
        
        else if (guessed < int_random) 
        {
            System.out.print ("Input is low. Try guessing higher: ");
            tries++;
            continue;
        }
        
        else if (guessed > int_random) 
        {
            System.out.print ("Input is high. Try guessing lower: ");
            tries++;
            continue;
        }
        
        else if (guessed == int_random)
        {   
            finish = System.currentTimeMillis();
            timeElapsed = finish - start;
            tries++;
            System.out.format ("Eureka! %d is the correct guess.", int_random);
            System.out.println ();
            System.out.format ("It took you %d attempts to guess correctly.", tries);
            System.out.println ();
            
                  
            score = (1.0 / (1 + (tries * timeElapsed))) * 100000.0 * 3.0;  
            // Perhaps do some more research on the best way to keep scores
            System.out.println (score);
            
            
            System.out.print ("Do you want to keep playing [Y/N]?");
            char charIn = (char) System.in.read ();
            
            if (charIn == 'Y' || charIn == 'y')
            {
                int_random = rand.nextInt (upperbound);
                System.out.println ("New Game");
                System.out.print ("Guess the number (100): ");
                start = System.currentTimeMillis();
            }
            
            else
            {
                System.out.println("Thank you for playing.");
                System.out.println("exiting game...");
                break;
            }
        }
        in.nextLine ();		// What happens if you remove this statement?
        
    }
    
    in.close ();
  }
}


/*
https://stackoverflow.com/questions/31778900/whats-a-better-way-to-calculate-score-based-on-attempts-and-time-taken

def scorer(tries, total_time, difficulty):
    # Tells the user how much time and how many attempts were made
    print "\nCorrect! It took you " + str(round(total_time, 2)) + \
          " seconds and " + str(tries) + " tries to guess.\n"

    # Calculates score, making lower times and fewer
    # tries yield a higher score
    # Difmod takes into account the difficulty
    # Multiply by 1000 to make number more readable
    score = 1 / (1 + (tries * round(total_time, 2))) * 1000 * dif_mod(difficulty)[1]

    # Prints the score, rounded to 1 decimal place
    print "Score: " + str(round(score, 2))

*/
