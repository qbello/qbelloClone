package SubmittedJunk.loanCalc;

/**
 * A class that stores and calculates values for hypothetical loans
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 06 -- Challenge
 *
 * @author Quintin Bello
 * @version February 16, 2022
 */

public class Loan
{
    private int duration;
    private double rate;
    private double amount;
    private double monthlyPayment;

    public Loan(int duration, double rate, double amount)
    {
        this.duration = duration;
        this.rate = rate;
        this.amount = amount;
        this.monthlyPayment = calculateMonthlyPayment();
    }

    public int getDuration()
    {
        return duration;
    }

    public double getRate()
    {
        return rate;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public void setRate(double rate)
    {
        this.rate = rate;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public double calculateMonthlyPayment()
    {
        double interest = Math.pow(1 + rate / 12, duration);
        return amount * ((rate / 12) * interest / (interest - 1));
    }

    public double calculateTotalCost(boolean output)
    {
        double principal = 0;
        double interest = 0;
        double remaining = this.amount;
        double totalInterest = 0;

        for (int paymentNumber = 1; paymentNumber <= duration; paymentNumber++)
        {
            interest = remaining * rate / 12;
            principal = monthlyPayment - interest;
            remaining -= principal;
            totalInterest += interest;

            if (output)
                System.out.println("Payment: " + paymentNumber +
                    " - Principal: " + String.format("%.2f", (double) Math.round(principal * 100) / 100) +
                    " - Interest: " + String.format("%.2f", (double) Math.round(interest * 100) / 100) +
                    " - Remaining: " + String.format("%.2f", (double) Math.round(remaining * 100) / 100));
        }

        return this.amount + totalInterest;
    }

    public String toString()
    {
        return "Amount: " + String.format("%.2f", (double) Math.round(amount * 100) / 100) +
                " - Rate: " + String.format("%.2f", (double) Math.round(rate * 100) / 100) +
                " - Duration: " + duration +
                " - Payment: " + String.format("%.2f", (double) Math.round(monthlyPayment * 100) / 100);
    }
}
