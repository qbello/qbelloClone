package SubmittedJunk;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * A Word Library that can clean a given library and generate a random word (only 5 letter words)
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 07 -- Challenge
 *
 * @author Quintin Bello
 * @version February 23, 2022
 */

public class WordLibrary
{
    private String[] library;
    private String fileName;
    private int seed;
    private Random random;

    public WordLibrary(String fileName) throws InvalidWordException
    {
        // read File an shit
        try
        {
            File file = new File(fileName);
            FileReader fs = new FileReader(file);
            BufferedReader bfr = new BufferedReader(fs);
            String firstLine = bfr.readLine();

            int fileSeed = Integer.parseInt(firstLine.substring(firstLine.indexOf(" ") + 1));
            random = new Random(fileSeed);

            ArrayList<String> words = new ArrayList<String>();
            String line = bfr.readLine();

            while (line != null)
            {
                words.add(line);
                line = bfr.readLine();
            }

            library = new String[words.size()];
            words.toArray(library);
            bfr.close();

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }


        // Note: The constructor should handle the exception by printing the error message to the terminal.
        try
        {
            processLibrary();
        } catch (InvalidWordException e)
        {
            e.printStackTrace();
        }
    }

    public void processLibrary() throws InvalidWordException
    {
        for (int i = 0; i < library.length; i++)
            if (library[i].length() != 5)
                throw new InvalidWordException("Invalid word!");
    }

    public WordLibrary(String[] library, int seed)
    {
        this.library = library;
        this.seed = seed;
        random = new Random(seed);
        cleanLibrary();
    }

    // Cleaning the library
    public void cleanLibrary()
    {
        // Make slave arrays
        String[] cleanLibrary = new String[0];
        String[] tempLib;

        // For every element in the og library
        for (int i = 0; i < library.length; i++)
        {
            // If the current element is 5 letters long
            if (library[i].length() == 5)
            {
                // Save a copy of the clean library
                tempLib = cleanLibrary;
                // Make the clean library one element longer
                cleanLibrary = new String[cleanLibrary.length + 1];
                // Save the last element as the current 5-letter word
                cleanLibrary[cleanLibrary.length - 1] = library[i];

                // Restore the rest of the elements in the clean library
                for (int j = 0; j < tempLib.length; j++)
                    cleanLibrary[j] = tempLib[j];
            }
        }

        // Set the library to the cleaned library
        library = cleanLibrary;
    }

    public String chooseWord()
    {
        return library[random.nextInt(library.length)];
    }

    public void setSeed(int seed)
    {
        this.seed = seed;
    }

    public void setLibrary(String[] library)
    {
        this.library = library;
    }

    public int getSeed()
    {
        return seed;
    }

    public String[] getLibrary()
    {
        return library;
    }
}
