package SubmittedJunk;

/**
 * A SubmittedJunk.Rollercoaster class
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 09 -- Challenge
 *
 * @author Quintin Bello
 * @version March 23, 2022
 */

public class Rollercoaster extends Ride
{
    private boolean simulated;

    public Rollercoaster(String name, String color, int minHeight, int maxRiders, boolean simulated)
    {
        this.simulated = simulated;
        this.setName(name);
        this.setColor(color);
        this.setMinHeight(minHeight);
        this.setMaxRiders(maxRiders);
    }

    public String toString()
    {
        return super.toString() + "\nSimulated: " + simulated;
    }

    public boolean equals(Object o)
    {
        return super.equals(o) && simulated == ((Rollercoaster) o).isSimulated();
    }

    public boolean isSimulated()
    {
        return simulated;
    }

    public void setSimulated(boolean simulated) {
        this.simulated = simulated;
    }
}
