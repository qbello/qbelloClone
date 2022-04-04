package SubmittedJunk;

public class Course
{
    private PurdueStudent studentOne;
    private PurdueStudent studentTwo;
    private PurdueStudent studentThree;

    public Course(PurdueStudent studentOne, PurdueStudent studentTwo, PurdueStudent studentThree)
    {
        this.studentOne = studentOne;
        this.studentTwo = studentTwo;
        this.studentThree = studentThree;
    }

    public Course()
    {

    }

    public boolean enrollStudent(PurdueStudent student)
    {
        if (studentOne == null)
        {
            studentOne = student;
            return true;
        }

        if (studentTwo == null)
        {
            studentTwo = student;
            return true;
        }

        if (studentThree == null)
        {
            studentThree = student;
            return true;
        }

        return false;
    }

    public boolean dropStudent(PurdueStudent student)
    {
        if (student.getFirstName().compareTo(studentOne.getFirstName()) == 0)
        {
            studentOne = null;
            return true;
        }

        if (student.getFirstName().compareTo(studentTwo.getFirstName()) == 0)
        {
            studentTwo = null;
            return true;
        }

        if (student.getFirstName().compareTo(studentThree.getFirstName()) == 0)
        {
            studentThree = null;
            return true;
        }

        return false;
    }

    public int getAvailableSeats()
    {
        int availableSeats = 0;

        if (studentOne == null)
            availableSeats++;

        if (studentTwo == null)
            availableSeats++;

        if (studentThree == null)
            availableSeats++;

        return availableSeats;
    }

    public int getNumEnrolled()
    {
        return 3 - getAvailableSeats();
    }
}
