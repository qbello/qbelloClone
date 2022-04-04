package SubmittedJunk;

public class MyThread implements Runnable
{

    public static void main(String[] args)
    {
        Thread toRun = new Thread(new MyThread()); // passing our class to the Java-defined Thread Object
        toRun.start(); // starts the Thread. The logic in SubmittedJunk.MyThread’s run() method will execute.

        try
        { // MUST encapsulate in a try-catch block for InterruptedExceptions.
            toRun.join(); // pauses the program here until toRun has finished executing its run() method.
        } catch (InterruptedException ie)
        {
            ie.printStackTrace(); // will print the stack trace of the origin of the InterruptedException
        }
    }

    public void run()
    {
        // thread logic
        System.out.println("Running!");
    }
}