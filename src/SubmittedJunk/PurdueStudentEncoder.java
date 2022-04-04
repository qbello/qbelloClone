package SubmittedJunk;

import java.util.Scanner;

public class PurdueStudentEncoder
{

    public static final String INTRO_MESSAGE = "SubmittedJunk.Welcome to the Purdue University Student Encoder!";
    public static final String NAME_PROMPT = "What is the student's first and last name?";
    public static final String PREVIOUS_CREDIT_PROMPT = "How many credits has the student " +
            "taken prior to this semester?";
    public static final String NUMBER_OF_TRACKS = "How many tracks are you on?";
    public static final String ITH_TRACK_PROMPT = "What is the name of track number ";
    public static final String HOMECOUNTRY_PROMPT = "What is the student's home country?";
    public static final String HOMETOWN_PROMPT = "What is the student's hometown?";
    public static final String MAJOR_PROMPT = "What is the student's major?";
    public static final String CREDIT_COUNT_PROMPT = "How many credits is the student taking this semester?";

    public static void main(String[] args)
    {
        // Initialize a scanner and the studentCode guy
        Scanner fromKeyboard = new Scanner(System.in);
        String studentName;
        String studentCode = "";
        System.out.println(INTRO_MESSAGE);

        // Get proper input for Student Name
        do
        {
            System.out.println(NAME_PROMPT);
            studentName = fromKeyboard.nextLine();
        } while (!studentName.contains(" ") && ("" + studentName.charAt(0)).compareTo(" ") != 0);

        // Add the initials to the code
        studentCode += "" + studentName.charAt(0) + studentName.charAt(studentName.indexOf(" ") + 1);
        int credits = 0;

        // Get proper input for number of credits
        do
        {
            System.out.println(PREVIOUS_CREDIT_PROMPT);
            credits = fromKeyboard.nextInt();
        } while (credits < 0);

        // Set appropriate year
        if (credits < 30)
            studentCode += "_Freshman_";
        else if (credits < 60)
            studentCode += "_Sophomore_";
        else if (credits < 90)
            studentCode += "_Junior_";
        else
            studentCode += "_Senior_";

        int tracks = 0;

        // Gat valid input for tracks
        do
        {
            System.out.println(NUMBER_OF_TRACKS);
            tracks = fromKeyboard.nextInt();
        } while (tracks < 1);

        fromKeyboard.nextLine();
        String curTrack;

        // Add each track
        for (int i = 1; i <= tracks; i++)
        {
            curTrack = "";
            System.out.println(ITH_TRACK_PROMPT + i + "?");
            curTrack = fromKeyboard.nextLine();
            studentCode += curTrack;

            // If it isn't the final track, add a comma and space
            if(i != tracks)
                studentCode += ", ";
        }

        // Get input for country and add DOMES or INTER to code
        System.out.println(HOMECOUNTRY_PROMPT);
        String homeCountry = fromKeyboard.nextLine();

        if (homeCountry.compareTo("USA") == 0 || homeCountry.compareTo("United States of America") == 0)
            studentCode += "_DOMES:";
        else
            studentCode += "_INTER:";


        System.out.println(HOMETOWN_PROMPT);
        String homeTown = fromKeyboard.nextLine();
        studentCode += homeTown + "_";

        System.out.println(MAJOR_PROMPT);
        String major  = fromKeyboard.nextLine();
        studentCode += major + "_";

        int curCreds = 0;

        do
        {
            System.out.println(CREDIT_COUNT_PROMPT);
            curCreds = fromKeyboard.nextInt();
        } while (curCreds < 0);

        if(curCreds >= 12)
            studentCode += "FT:" + curCreds + ";";
        else
            studentCode += "PT:" + curCreds + ";";

        System.out.println(studentCode);
    }
}
