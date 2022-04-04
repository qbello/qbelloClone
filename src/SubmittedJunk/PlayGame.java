package SubmittedJunk;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that allows you to play battleship
 *
 * Purdue CS1800 Spring 2022
 *
 * @author Quinn Bello
 * @version 3/27/2022
 */

public class PlayGame
{

    public static void main(String[] args)
    {
        // make an object of this class to allow use of methods
        PlayGame disGame = new PlayGame();

        // make arraylist with hit spots based on the ship position files
        ArrayList<String> playerOneHits = null;
        ArrayList<String> playerTwoHits = null;

        //use the method i wrote to get a list of valid hits
        try {
            playerOneHits = disGame.getHits("ShipPositionsPlayerOne.txt");
            playerTwoHits = disGame.getHits("ShipPositionsPlayerTwo.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Welcome message and pick a game mode
        System.out.println("Hello, Welcome to Battleship!");
        System.out.println("Please enter a Game mode:\n" +
                "1. Automated\n2. Active");

        Scanner fromKeyboard = new Scanner(System.in);
        boolean isActiveMode = fromKeyboard.nextLine().compareTo("2") == 0;

        int turns = 0;
        int winningPlayer = 0;
        int losingPlayerHits = 0;

        // get the board types with the methods that work
        String boardOneType = disGame.getBoardType(playerOneHits);
        String boardTwoType = disGame.getBoardType(playerTwoHits);

        // if game mode 1 then ask for the filename with the game data
        if (!isActiveMode)
        {
            System.out.println("Enter the filename with the game data:");
            ArrayList<String> guesses = null;
            int index = 0;

            try
            {
                guesses = disGame.getGuesses(fromKeyboard.nextLine()); // guesses contains player 1 and 2's guesses
            } catch (IOException e) { // the guesses alternate from player one to player two
                e.printStackTrace();
            }

            // go through each guess one at a time until someone's all used up
            while (playerOneHits.size() > 0 && playerTwoHits.size() > 0)
            {
                // if the guess is a hit on player two, remove it from his list of hits
                if (playerTwoHits.contains(guesses.get(index)))
                    playerTwoHits.remove(guesses.get(index));

                // increment = switch to player two guess
                index++;

                // if playerTwo didn't just lose, check player two's guess
                if (playerTwoHits.size() > 0)
                    if (playerOneHits.contains(guesses.get(index)))
                        playerOneHits.remove(guesses.get(index));

                // move to next round of guesses
                index++;
                // increment turns/ rounds
                turns++;

                // ***TEST***
//                System.out.println("Turns: " + turns);
//                System.out.println("TEST: SubmittedJunk.Player hit lists:\n" + playerOneHits + "\n" + playerTwoHits);
//                System.out.println("SubmittedJunk.Player Two hits: " + (17 - playerOneHits.size()));
//                System.out.println("SubmittedJunk.Player One hits: " + (17 - playerTwoHits.size()));
            }

            // Prep the winner's message
            String winner = "Enemy fleet destroyed. Congratulations player ";

            // if player one lost all their ships
            if (playerOneHits.size() == 0)
            {
                winningPlayer = 2;
                losingPlayerHits = 17 - playerTwoHits.size(); // 17 - number one's hits
                winner += "2!";
            } else
            {
                winningPlayer = 1;
                losingPlayerHits = 17 - playerOneHits.size(); // 17 - number two's hits
                winner += "1!";
            }

            System.out.println(winner);
        } else
        {
            // while both players still have lives
            while (playerOneHits.size() > 0 && playerTwoHits.size() > 0)
            {
                // ask for letter then number, then check if that's a hit
                System.out.println("SubmittedJunk.Player 1 - Enter a row letter from A - J");
                String playerOneGuess = fromKeyboard.nextLine();
                System.out.println("SubmittedJunk.Player 1 - Enter a column number from 1 - 14");
                playerOneGuess += fromKeyboard.nextLine();

                // if it's a hit on player two
                if (playerTwoHits.contains(playerOneGuess))
                {
                    // print "H" and remove it from his list
                    System.out.println("Value:H");
                    playerTwoHits.remove(playerOneGuess);
                } else
                    System.out.println("Value:M");

                // if player two still has lives
                if (playerTwoHits.size() > 0)
                {
                    // get a guess from him
                    System.out.println("SubmittedJunk.Player 2 - Enter a row letter from A - J");
                    String playerTwoGuess = fromKeyboard.nextLine();
                    System.out.println("SubmittedJunk.Player 2 - Enter a column number from 1 - 14");
                    playerTwoGuess += fromKeyboard.nextLine();

                    // if it's a hit on player one
                    if (playerOneHits.contains(playerTwoGuess))
                    {
                        // print h and get it out the list
                        System.out.println("Value:H");
                        playerOneHits.remove(playerTwoGuess);
                    } else
                        System.out.println("Value:M");
                }

                // increment turns/ rounds
                turns++;

                // ***TEST***
//                System.out.println("Turns: " + turns);
//                System.out.println("TEST: SubmittedJunk.Player hit lists:\n" + playerOneHits + "\n" + playerTwoHits);
//                System.out.println("SubmittedJunk.Player Two hits: " + (17 - playerOneHits.size()));
//                System.out.println("SubmittedJunk.Player One hits: " + (17 - playerTwoHits.size()));
            }

            // prep winner string
            String winner = "Enemy fleet destroyed. Congratulations player ";

            if (playerOneHits.size() == 0) // for player 2 being the winner ...
            {
                winningPlayer = 2;
                losingPlayerHits = 17 - playerTwoHits.size(); // use how many lives player 2 has left
                winner += "2!";
            } else // for player 1 being the winner
            {
                winningPlayer = 1;
                losingPlayerHits = 17 - playerOneHits.size(); // use how many live they have left
                winner += "1!";
            }

            // print reslting string
            System.out.println(winner);
        }

        // prep writer, then initialize it in
        PrintWriter writer = null;

        try
        {
            writer = new PrintWriter(new BufferedWriter(new FileWriter("SubmittedJunk.GameLog.txt")));
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        // Here is the Log stuff, pretty straight forward
        writer.println(new GameLog(winningPlayer, losingPlayerHits, turns, boardOneType, boardTwoType).toString());
        writer.close();
    }

    public ArrayList<String> getGuesses(String filename) throws IOException
    {
        ArrayList<String> guesses = new ArrayList<>();
        BufferedReader fromFile = null;
        String line;

        try
        {
            fromFile = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        while ((line = fromFile.readLine()) != null)
            guesses.add("" + line + fromFile.readLine());

        return guesses;
    }

    public String getBoardType(ArrayList<String> hitList)
    {
        int counter = 0;
        char cur;

        for (int i = 0; i < hitList.size(); i++)
        {
            cur = hitList.get(i).charAt(0);

            if (cur == 'A' || cur == 'B' || cur == 'C')
                counter++;
        }

        if (counter >= 9)
            return "Top Heavy";

        counter = 0;

        for (int i = 0; i < hitList.size(); i++)
        {
            cur = hitList.get(i).charAt(0);

            if (cur == 'D' || cur == 'E' || cur == 'F' || cur == 'G')
                counter++;
        }

        if (counter >= 9)
            return "Middle Heavy";

        counter = 0;

        for (int i = 0; i < hitList.size(); i++)
        {
            cur = hitList.get(i).charAt(0);

            if (cur == 'H' || cur == 'I' || cur == 'J')
                counter++;
        }

        if (counter >= 9)
            return "Bottom Heavy";

        return "Scattered";
    }

    public ArrayList<String> getHits(String filename) throws IOException
    {
        // this works I tested it
        char[] rows = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        ArrayList<String> hits = new ArrayList<>();
        BufferedReader fromFile = null;
        String line;
        int row = 0;

        try
        {
            fromFile = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        // loop through line by line
        while ((line = fromFile.readLine()) != null)
        {
            // loop through each line
            for (int index = 0; index < line.length(); index++)
            {
                if (line.charAt(index) == 'H')
                    hits.add("" + rows[row] + (index + 1));
            }

            row++;
        }

        return hits;
    }
}
