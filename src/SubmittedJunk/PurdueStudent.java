package SubmittedJunk;

public class PurdueStudent
{
    private String firstName;
    private String lastName;
    private int age;
    private String major;
    private String studentType;
    private String homeCountry;
    private String hometown;

    public PurdueStudent(String firstName, String lastName, int age, String major, String studentType,
                         String homeCountry, String hometown)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this. age = age;
        this.major = major;
        this.studentType = studentType;
        this.homeCountry = homeCountry;
        this.hometown = hometown;
    }

    @Override
    public String toString()
    {
        return "SubmittedJunk.PurdueStudent<" +
                "firstName=" + firstName + ", lastName=" + lastName +
                ", age=" + age + ", major=" + major +
                ", studentType=" + studentType +
                ", homeCountry=" + homeCountry +
                ", hometown=" + hometown +
                '>';
    }

    public void setHometown(String hometown)
    {
        this.hometown = hometown;
    }

    public void setHomeCountry(String homeCountry)
    {
        this.homeCountry = homeCountry;
    }

    public void setStudentType(String studentType)
    {
        this.studentType = studentType;
    }

    public void setMajor(String major)
    {
        this.major = major;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getHometown()
    {
        return hometown;
    }

    public String getHomeCountry()
    {
        return homeCountry;
    }

    public String getStudentType()
    {
        return studentType;
    }

    public String getMajor()
    {
        return major;
    }

    public int getAge()
    {
        return age;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }
}
