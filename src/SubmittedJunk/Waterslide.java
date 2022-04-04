package SubmittedJunk;

/**
 * A SubmittedJunk.Waterslide class
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 09 -- Challenge
 *
 * @author Quintin Bello
 * @version March 23, 2022
 */

public class Waterslide extends Ride
{
    private double splashDepth;

    public Waterslide(String name, String color, int minHeight, int maxRiders, double splashDepth)
    {
        super.setName(name);
        super.setColor(color);
        super.setMinHeight(minHeight);
        super.setMaxRiders(maxRiders);
        this.splashDepth = splashDepth;
    }

    public double getSplashDepth() {
        return splashDepth;
    }

    public void setSplashDepth(double splashDepth) {
        this.splashDepth = splashDepth;
    }

    public boolean equals(Object o)
    {
        return super.equals(o) && ((Waterslide) o).getSplashDepth() == splashDepth;
    }

    public String toString()
    {
        return super.toString() + "\nSplashDepth: " + splashDepth + " feet";
    }
}
