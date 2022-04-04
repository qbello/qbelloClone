package SubmittedJunk;

/**
 * A Word Guesser that can handles a field and the solution and the round
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 07 -- Challenge
 *
 * @author Quintin Bello
 * @version February 23, 2022
 */

public class WordGuesser
{
    private String[][] playingField;
    private int round;
    private String solution;

    public WordGuesser(String solution)
    {
        this.solution = solution;
        round = 1;
        playingField = new String[5][5];

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                playingField[i][j] = " ";
    }

    // Checks the guess ig
    public boolean checkGuess(String guess) throws InvalidGuessException
    {
        boolean toReturn = false;

        if (guess.length() != 5)
            throw new InvalidGuessException("Invalid guess!");

        // Set the return variable to true if they got it right
        if (guess.compareTo(solution) == 0)
            toReturn = true;

        // For every letter in the guess
        for (int i = 0; i < 5; i++)
        {
            // If it's ...
            if (guess.charAt(i) == solution.charAt(i))                      // in the solution and in the right spot:
                playingField[round - 1][i] = "'" + guess.charAt(i) + "'";       // surround with ' '
            else if (solution.contains("" + guess.charAt(i)))               // in the solution but in the wrong spot:
                playingField[round - 1][i] = "*" + guess.charAt(i) + "*";       // surround with * *
            else                                                            // not in the solution:
                playingField[round - 1][i] = "{" + guess.charAt(i) + "}";       // surround with { }
        }

        // Return the return boolean
        return toReturn;
    }

    // Prints the field with specific formatting
    public void printField()
    {
        // For every row
        for (int i = 0; i < 5; i++)
        {
            // For every column
            for (int j = 0; j < 5; j++)
            {
                // nothing before the first element, but space before every other element
                if (j != 0)
                    System.out.print(" ");

                // print the element
                System.out.print(playingField[i][j]);

                // nothing after the last element, but " |" after every other element
                if (j != 4)
                    System.out.print(" |");
            }

            // new line every row
            System.out.println();
        }

    }

    public String[][] getPlayingField()
    {
        return playingField;
    }

    public int getRound()
    {
        return round;
    }

    public String getSolution()
    {
        return solution;
    }

    public void setPlayingField(String[][] playingField)
    {
        this.playingField = playingField;
    }

    public void setRound(int round)
    {
        this.round = round;
    }

    public void setSolution(String solution)
    {
        this.solution = solution;
    }


}
