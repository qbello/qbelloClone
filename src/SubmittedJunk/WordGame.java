package SubmittedJunk;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A Word Game where you try to guess a 5-letter word
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 07 -- Challenge
 *
 * @author Quintin Bello
 * @version February 23, 2022
 */

public class WordGame
{

    public static String welcome = "Ready to play?";
    public static String yesNo = "1.Yes\n2.No";
    public static String noPlay = "Maybe next time!";
    public static String currentRoundLabel = "Current Round: ";
    public static String enterGuess = "Please enter a guess!";
    public static String winner = "You got the answer!";
    public static String outOfGuesses = "You ran out of guesses!";
    public static String solutionLabel = "Solution: ";
    public static String incorrect = "That's not it!";
    public static String keepPlaying = "Would you like to make another guess?";
    public static String enterWords = "Please enter a comma-separated list of words";
    public static String enterSeed = "Please enter a seed for the random number generator";

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Starting input to create wordLibrary
        System.out.println("Please enter a filename");
        String filename = scanner.nextLine();
        WordLibrary wordLibrary = null;

        try
        {
            wordLibrary = new WordLibrary(filename);
        } catch (InvalidWordException e)
        {
            e.printStackTrace();
        }

        boolean isPlaying;

        // Initial menu inquiry
        System.out.println(welcome);
        System.out.println(yesNo);
        isPlaying = scanner.nextInt() == 1;

        // main game loop
        while (isPlaying)
        {
            // make a new wordGuesser guy
            String word = wordLibrary.chooseWord();
            WordGuesser wordGuesser = new WordGuesser(word);
            boolean isGuessing = true;
            boolean guessed = false;
            ArrayList<String> guesses = new ArrayList<>();

            // while they're guessing
            while (isGuessing)
            {
                // print round and field and get a new guess
                System.out.println(currentRoundLabel + wordGuesser.getRound());
                wordGuesser.printField();
                System.out.println(enterGuess);
                scanner.nextLine();
                String guess = scanner.nextLine();
                guesses.add(guess);

                try
                {
                    if (!wordGuesser.checkGuess(guess) && wordGuesser.getRound() < 5) // if it is wrong
                    {
                        // tell them they're wrong and ask to keep guessing
                        System.out.println(incorrect);
                        System.out.println(keepPlaying);
                        System.out.println(yesNo);
                        isGuessing = scanner.nextInt() == 1;
                        wordGuesser.setRound(wordGuesser.getRound() + 1);

                        // if they end it print the field one more time
                        if (!isGuessing)
                            wordGuesser.printField();
                    } else if (!wordGuesser.checkGuess(guess) && wordGuesser.getRound() == 5)
                    {
                        // if they get it wrong on the last guess
                        System.out.println(outOfGuesses);
                        System.out.println(solutionLabel + wordGuesser.getSolution());
                        wordGuesser.printField();
                        isGuessing = false;
                    } else // if it is right
                    {
                        // winner message and print field, no longer guessing
                        System.out.println(winner);
                        wordGuesser.printField();
                        isGuessing = false;
                        guessed = true;
                    }
                } catch (InvalidGuessException e)
                {
                    e.printStackTrace();
                }

            }

            String[] arr = new String[guesses.size()];

            for (int i = 0; i < guesses.size(); i++)
                arr[i] = guesses.get(i);

            updateGameLog(word, arr, guessed);

            // refresh menu inquiry
            System.out.println(welcome);
            System.out.println(yesNo);
            isPlaying = scanner.nextInt() == 1;
        }

        System.out.println(noPlay);

    }

    public static void updateGameLog(String solution, String[] guesses, boolean solved)
    {
        // Initialize stuff kinda to make try catches smoother
        BufferedReader bfr = null;
        FileOutputStream fos = null;
        boolean newFile = false;

        // List to store the contents of the file
        ArrayList<String> lines = new ArrayList<>();
        String line = "";

        // actually initialize the files and reader/ writer
        try
        {
            // if the file doesn't exist yet, make one, remember that it's a new file
            if (!new File("gamelog.txt").exists())
            {
                new File("gamelog.txt").createNewFile();
                newFile = true;
            }

            bfr = new BufferedReader(new FileReader("gamelog.txt"));

            // get each line and add it to the list until you reach a null
            try
            {
                while ((line = bfr.readLine()) != null)
                    lines.add(line);

            } catch (IOException e){
                e.printStackTrace();
            } finally {
                if (bfr != null) {
                    try {
                        bfr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        // make the writer and some prelim vars
        try {
            fos = new FileOutputStream("gamelog.txt", false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fos);
        String firstLine = "";
        int totalGames = 0;

        // If the file is new
        if (newFile)
        {
            // You get one game yay
            firstLine = "Games Completed: 1";
            pw.println(firstLine);
            totalGames  = 0;
        } else // otherwise grab the first line, find the prev total games, print it out with that incremented
        {
            firstLine = lines.get(0);
            totalGames = Integer.parseInt(firstLine.substring(firstLine.indexOf(": ") + 2));
            pw.println("Games Completed: " + (totalGames++));

            // re-add all the lines of the file
            for (int i = 1; i < lines.size(); i++)
                pw.println(lines.get(i));
        }

        // Add lines for most recent game
        totalGames++;
        pw.println("Game " + totalGames);
        pw.println("- Solution: " + solution);
        pw.println("- Guesses: " + Arrays.toString(guesses).substring(1, Arrays.toString(guesses).length() - 1));

        if (solved)
            pw.println("- Solved: Yes");
        else
            pw.println("- Solved: No");

        pw.close();
        try {
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





