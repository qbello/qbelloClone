package SubmittedJunk.PracticeExam1Q2;

public class Entree
{
    private String name;
    private int calories;
    private boolean vegetarian;
    private boolean vegan;

    public Entree(String name, int calories, boolean vegetarian, boolean vegan)
    {
        this.name = name;
        this.calories = calories;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
    }

    public Entree(Entree entree)
    {
        this.name = entree.getName();
        this.calories = entree.getCalories();
        this.vegetarian = entree.isVegetarian();
        this.vegan = entree.isVegan();
    }

    @Override
    public String toString() {
        return "Entree<" +
                "name=" + name +
                ", calories=" + calories +
                ", vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                '>';
    }

    public void setVegan(boolean vegan)
    {
        this.vegan = vegan;
    }

    public void setVegetarian(boolean vegetarian)
    {
        this.vegetarian = vegetarian;
    }

    public void setCalories(int calories)
    {
        this.calories = calories;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isVegan()
    {
        return vegan;
    }

    public boolean isVegetarian()
    {
        return vegetarian;
    }

    public int getCalories()
    {
        return calories;
    }

    public String getName()
    {
        return name;
    }

    public Entree()
    {
        name = null;
        calories = 0;
        vegetarian = false;
        vegan = false;
    }
}
