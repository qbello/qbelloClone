package SubmittedJunk;

public class OneDollar extends DollarBill
{
    public OneDollar()
    {
        super(1, "George Washington");
    }

    public boolean acceptedVending()
    {
        return true;
    }
}
