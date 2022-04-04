package SubmittedJunk;

/**
 * A class that manages labs
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Project 2
 *
 * @author Quintin Bello
 * @version March 2, 2022
 */

public class LabManager
{
    private Lab labOne;
    private Lab labTwo;
    private Lab labThree;

    public LabManager(Lab labOne, Lab labTwo, Lab labThree)
    {
        this.labOne = labOne;
        this.labTwo = labTwo;
        this.labThree = labThree;
    }

    public String toString()
    {
        String ret = "";

        ret += "SubmittedJunk.LabManager{" + labOne.toString() + ", " + labTwo.toString() + ", " +
                labThree.toString() + "}";

        return ret;
    }

    public int calculateTotalCapacity()
    {
        return labOne.getCapacity() * 2 + labTwo.getCapacity() * 2 + labThree.getCapacity() * 2;
    }

    public double calculateTotalUtilization()
    {
        double labOneTot = labOne.getMorning().getEnrollment() + labOne.getAfternoon().getEnrollment();
        double labTwoTot = labTwo.getMorning().getEnrollment() + labTwo.getAfternoon().getEnrollment();
        double labThreeTot = labThree.getMorning().getEnrollment() + labThree.getAfternoon().getEnrollment();
        double totAvg = (labOneTot + labTwoTot + labThreeTot) / (double) calculateTotalCapacity();

        return (double) Math.round(totAvg * 100) / 100;
    }

    public int calculateAvailableSeats()
    {
        return 2 * labOne.getCapacity() - labOne.getMorning().getEnrollment() - labOne.getAfternoon().getEnrollment() +
                2 * labTwo.getCapacity() - labTwo.getMorning().getEnrollment() - labTwo.getAfternoon().getEnrollment() +
                2 * labThree.getCapacity() - labThree.getMorning().getEnrollment() -
                labThree.getAfternoon().getEnrollment();
    }

    public String listReservedLabs()
    {
        String ret = "";
        ret += "SubmittedJunk.Lab One\n" + labOne.listReservations();
        ret += "\n\nSubmittedJunk.Lab Two\n" + labTwo.listReservations();
        ret += "\n\nLabThree\n" + labThree.listReservations() + "\n";
        return ret;
    }

    public String listAvailableLabs()
    {
        String ret = "\n";
        ret += "SubmittedJunk.Lab One\n" + labOne.listAvailabilities();
        ret += "\nSubmittedJunk.Lab Two\n" + labTwo.listAvailabilities();
        ret += "\nLabThree\n" + labThree.listAvailabilities();
        return ret;
    }

    public String addReservation(String location, String time, String name, int enrollment)
    {
        Lab[] labs = {labOne, labTwo, labThree};
        int lab = -1;

        for (int i = 0; i < 3; i++)
            if (labs[i].getLocation().compareTo(location) == 0)
                lab = i;

        // check for valid location
        if (lab == -1)
            return "Error. Invalid location";

        if ("morning".compareTo(time) != 0 && "afternoon".compareTo(time) != 0)
            return "Error. Invalid time.";

        boolean isMorning = time.compareTo("morning") == 0;

        // check for valid time
        if (isMorning)
        {
            // check for enrollment
            if (labs[lab].getMorning().getEnrollment() != 0)
                return "Error. Invalid time.";

            if (labs[lab].getCapacity() < enrollment)
                return "Error. Capacity exceeded";

            labs[lab].setMorning(new Session(name, enrollment));

        } else if (time.compareTo("afternoon") == 0)
        {
            if (labs[lab].getAfternoon().getEnrollment() != 0)
                return "Error. Invalid time.";

            if (labs[lab].getCapacity() < enrollment)
                return "Error. Capacity exceeded";

            labs[lab].setAfternoon(new Session(name, enrollment));
        }

        return "Reservation added!";
    }

    public String removeReservation(String location, String time)
    {
        Lab[] labs = {labOne, labTwo, labThree};
        int lab = -1;

        for (int i = 0; i < 3; i++)
            if (labs[i].getLocation().compareTo(location) == 0)
                lab = i;

        // check for valid location
        if (lab == -1)
            return "Error. Invalid location";

        if ("morning".compareTo(time) != 0 && "afternoon".compareTo(time) != 0)
            return "Error. Invalid time.";

        boolean isMorning = time.compareTo("morning") == 0;

        if (isMorning)
            if (labs[lab].getMorning().getEnrollment() == 0)
                return "Error. Invalid time.";
            else
                labs[lab].setMorning(new Session("", 0));
        else
            if (labs[lab].getAfternoon().getEnrollment() == 0)
                return "Error. Invalid time.";
            else
                labs[lab].setAfternoon(new Session("", 0));

        return "Reservation removed!";
    }

    public String modifyReservation(String location, String time, String name, int enrollment)
    {
        Lab[] labs = {labOne, labTwo, labThree};
        int lab = -1;

        for (int i = 0; i < 3; i++)
            if (labs[i].getLocation().compareTo(location) == 0)
                lab = i;

        // check for valid location
        if (lab == -1)
            return "Error. Invalid location";

        if ("morning".compareTo(time) != 0 && "afternoon".compareTo(time) != 0)
            return "Error. Invalid time.";

        boolean isMorning = time.compareTo("morning") == 0;

        // check for valid time
        if (isMorning)
        {
            if (labs[lab].getMorning().getEnrollment() == 0)
                return "Error. Invalid time.";
            else if (labs[lab].getCapacity() < enrollment)
                return "Error. Capacity exceeded";

            labs[lab].setMorning(new Session(name, enrollment));
        } else
        {
            if (labs[lab].getAfternoon().getEnrollment() == 0)
                return "Error. Invalid time.";
            else if (labs[lab].getCapacity() < enrollment)
                return "Error. Capacity exceeded";

            labs[lab].setAfternoon(new Session(name, enrollment));
        }


        return "Reservation modified!";
    }

    public void setLabOne(Lab labOne)
    {
        this.labOne = labOne;
    }

    public void setLabTwo(Lab labTwo)
    {
        this.labTwo = labTwo;
    }

    public void setLabThree(Lab labThree)
    {
        this.labThree = labThree;
    }

    public Lab getLabOne()
    {
        return labOne;
    }

    public Lab getLabTwo()
    {
        return labTwo;
    }

    public Lab getLabThree()
    {
        return labThree;
    }
}
