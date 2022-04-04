package SubmittedJunk;

/**
 * An exception to handle invalid exceptions
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 07 -- Challenge
 *
 * @author Quintin Bello
 * @version March 10, 2022
 */

public class InvalidGuessException extends Exception
{
    public InvalidGuessException(String message)
    {
        super(message);
    }
}
