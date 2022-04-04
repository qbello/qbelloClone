package SubmittedJunk;

/**
 * A class for a SubmittedJunk.Ride
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 09 -- Challenge
 *
 * @author Quintin Bello
 * @version March 23, 2022
 */

public class Ride
{
    private String color;
    private int maxRiders;
    private int minHeight; // in inches
    private String name;

    public Ride(String name, String color, int minHeight, int maxRiders)
    {
        this.name = name;
        this.color = color;
        this.minHeight = minHeight;
        this.maxRiders = maxRiders;
    }

    public Ride()
    {
        color = "";
        maxRiders = 0;
        minHeight = 0;
        name = "";
    }

    public String toString()
    {
        return "Name: " + name + "\nSubmittedJunk.Color: " + color + "\nMinHeight: "
                + minHeight + " inches\nMaxRiders: " + maxRiders;
    }

    public boolean equals(Object o)
    {
        if (this.getClass() != o.getClass())
            return false;

        return name.compareTo(((Ride) o).getName()) == 0 && maxRiders == ((Ride) o).getMaxRiders()
                && minHeight == ((Ride) o).getMinHeight() && color.compareTo(((Ride) o).getColor()) == 0;
    }

    public String getColor()
    {
        return color;
    }

    public int getMaxRiders()
    {
        return maxRiders;
    }

    public int getMinHeight()
    {
        return minHeight;
    }

    public String getName()
    {
        return name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxRiders(int maxRiders) {
        this.maxRiders = maxRiders;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public void setName(String name) {
        this.name = name;
    }
}