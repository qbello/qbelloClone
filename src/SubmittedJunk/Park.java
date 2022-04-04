package SubmittedJunk;

import java.util.ArrayList;

/**
 * A SubmittedJunk.Park interface
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 09 -- Challenge
 *
 * @author Quintin Bello
 * @version March 23, 2022
 */

interface Park
{
    void addRide(Ride ride) throws WrongRideException;
    void close();
    void enlarge(double addedLand, double maxLand, boolean addedIndoor, boolean addedOutdoor) throws SpaceFullException;
    double getAdmissionCost();
    double getLand();
    String getName();
    ArrayList<Ride> getRides();
    boolean[] getSeasons();
    boolean isIndoor();
    boolean isOutdoor();
    void removeRide(Ride ride);
    void setAdmissionCost(double admissionCost);
    void setName(String name);
    void setSeasons(boolean[] seasons);
}
