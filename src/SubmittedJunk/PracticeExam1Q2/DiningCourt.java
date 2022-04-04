package SubmittedJunk.PracticeExam1Q2;

public class DiningCourt
{
    private Entree firstEntree;
    private Entree secondEntree;
    private Entree thirdEntree;

    public DiningCourt(Entree firstEntree, Entree secondEntree, Entree thirdEntree)
    {
        this.firstEntree = firstEntree;
        this.secondEntree = secondEntree;
        this.thirdEntree = thirdEntree;
    }

    public DiningCourt(DiningCourt diningCourt)
    {
        firstEntree = diningCourt.getFirstEntree();
        secondEntree = diningCourt.getSecondEntree();
        thirdEntree = diningCourt.getThirdEntree();
    }

    @Override
    public String toString()
    {
        return "DiningCourt<" +
                "firstEntree=" + firstEntree +
                ", secondEntree=" + secondEntree +
                ", thirdEntree=" + thirdEntree +
                '>';
    }

    public void printVeganEntrees()
    {
        if (firstEntree.isVegan())
            System.out.println(firstEntree);
        if (secondEntree.isVegan())
            System.out.println(secondEntree);
        if (thirdEntree.isVegan())
            System.out.println(thirdEntree);

        if (! firstEntree.isVegan() && ! secondEntree.isVegan() && !thirdEntree.isVegan())
            System.out.println("No vegan options are available :(");
    }

    public void printVegetarianEntrees()
    {
        if (firstEntree.isVegetarian())
            System.out.println(firstEntree);
        if (secondEntree.isVegetarian())
            System.out.println(secondEntree);
        if (thirdEntree.isVegetarian())
            System.out.println(thirdEntree);

        if (! firstEntree.isVegetarian() && ! secondEntree.isVegetarian() && !thirdEntree.isVegetarian())
            System.out.println("No vegetarian options are available :(");
    }

    public Entree getLowestCalorieEntree()
    {
        if (firstEntree.getCalories() < secondEntree.getCalories() &&
                firstEntree.getCalories() < thirdEntree.getCalories())
            return firstEntree;

        if (secondEntree.getCalories() < firstEntree.getCalories() &&
                secondEntree.getCalories() < thirdEntree.getCalories())
            return secondEntree;

        if (thirdEntree.getCalories() < firstEntree.getCalories() &&
                thirdEntree.getCalories() < secondEntree.getCalories())
            return thirdEntree;

        return firstEntree;
    }

    public Entree getHighestCalorieEntree()
    {
        if (firstEntree.getCalories() > secondEntree.getCalories() &&
                firstEntree.getCalories() > thirdEntree.getCalories())
            return firstEntree;

        if (secondEntree.getCalories() > firstEntree.getCalories() &&
                secondEntree.getCalories() > thirdEntree.getCalories())
            return secondEntree;

        if (thirdEntree.getCalories() > firstEntree.getCalories() &&
                thirdEntree.getCalories() > secondEntree.getCalories())
            return thirdEntree;

        return firstEntree;
    }

    public void setFirstEntree(Entree firstEntree)
    {
        this.firstEntree = firstEntree;
    }

    public void setSecondEntree(Entree secondEntree)
    {
        this.secondEntree = secondEntree;
    }

    public void setThirdEntree(Entree thirdEntree)
    {
        this.thirdEntree = thirdEntree;
    }

    public Entree getFirstEntree()
    {
        return firstEntree;
    }

    public Entree getSecondEntree()
    {
        return secondEntree;
    }

    public Entree getThirdEntree()
    {
        return thirdEntree;
    }

    public DiningCourt()
    {
        firstEntree = null;
        secondEntree = null;
        thirdEntree = null;
    }
}
