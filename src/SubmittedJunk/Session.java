package SubmittedJunk;

/**
 * A class that represents an individual session in a lab
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Project 2
 *
 * @author Quintin Bello
 * @version March 2, 2022
 */

public class Session
{
    private String name;
    private int enrollment;

    public Session(String name, int enrollment)
    {
        this.name = name;
        this.enrollment = enrollment;
    }

    public Session()
    {
        name = "";
        enrollment = 0;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public int getEnrollment()
    {
        return enrollment;
    }

    public void setEnrollment(int enrollment)
    {
        this.enrollment = enrollment;
    }

    public String toString()
    {
        return "SubmittedJunk.Session{Name - " + name + ", Enrollment - " + enrollment + "}";
    }
}
