package SubmittedJunk;

/**
 * An exception to handle invalid words
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 08 -- Challenge
 *
 * @author Quintin Bello
 * @version March 10, 2022
 */

public class InvalidWordException extends Exception
{
    public InvalidWordException(String message)
    {
        super(message);
    }
}
