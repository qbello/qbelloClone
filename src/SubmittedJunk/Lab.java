package SubmittedJunk;

/**
 * A class that represents the lab
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Project 2
 *
 * @author Quintin Bello
 * @version March 2, 2022
 */

public class Lab
{
    private Session morning;
    private Session afternoon;
    private int capacity;
    private String location;

    public Lab(Session morning, Session afternoon, int capacity, String location)
    {
        this.morning = morning;
        this.afternoon = afternoon;
        this.capacity = capacity;
        this.location = location;
    }

    public Lab(int capacity, String location)
    {
        this.capacity = capacity;
        this.location = location;
        morning = new Session();
        afternoon = new Session();
    }

    public Session getMorning()
    {
        return morning;
    }

    public Session getAfternoon()
    {
        return afternoon;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public String getLocation()
    {
        return location;
    }

    public void setMorning(Session morning)
    {
        this.morning = morning;
    }

    public void setAfternoon(Session afternoon)
    {
        this.afternoon = afternoon;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String listAvailabilities()
    {
        if (morning.getEnrollment() != 0 && afternoon.getEnrollment() != 0)
            return "No Availabilities";

        String avail = "";

        if (morning.getEnrollment() == 0)
            avail += "Morning: Available\n";

        if (afternoon.getEnrollment() == 0)
            avail += "Afternoon: Available\n";

        return avail;
    }

    public String listReservations()
    {
        if (morning.getEnrollment() == 0 && afternoon.getEnrollment() == 0)
            return "No Reservations";

        String reser = "";

        if (morning.getEnrollment() > 0)
            reser += "Morning: Reserved\n";

        if (afternoon.getEnrollment() > 0)
            reser += "Afternoon: Reserved\n";

        return reser;
    }

    public String toString()
    {
        String chyur = "SubmittedJunk.Lab{Capacity - " + capacity + ", Location - " + location + ", Morning: ";

        if (morning.getEnrollment() == 0)
            chyur += "Available";
        else
            chyur += morning.toString();

        chyur += ", Afternoon: ";

        if (afternoon.getEnrollment() == 0)
            chyur += "Available";
        else
            chyur += afternoon.toString();

        return chyur + "}";
    }
}





