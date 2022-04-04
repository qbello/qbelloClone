package SubmittedJunk;

public class Person implements Identifiable
{
    private final String name;
    private final int age;

    public Person(String name, int age)
    {
        if (name == null)
            throw new NullPointerException();

        if (age < 0)
            throw new IllegalArgumentException();

        this.name = name;
        this.age = age;
    }

    public Person(Person person)
    {
        this.name = person.getName();
        this.age = person.getAge();
    }

    public boolean equals(Object object)
    {
        if (((Person) object).equals(object))
        {
            Person guy = (Person) object;

            if (guy.getAge() == age && guy.getName().compareTo(name) == 0)
                return true;
        }

        return false;
    }

    private int getAge()
    {
        return age;
    }

    public String getName()
    {
        return name;
    }
}
