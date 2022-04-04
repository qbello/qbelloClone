public class MyThreadTwo extends Thread
{

    public static void main(String[] args)
    {
        MyThreadTwo toRun = new MyThreadTwo();
        toRun.start(); // starts the Thread. The logic in MyThreadTwo’s run() method will execute.

        try
        { // MUST encapsulate in a try-catch block for InterruptedExceptions.
            toRun.join(); // pauses the program here until toRun has finished executing its run() method.
        } catch (InterruptedException ie)
        {
            ie.printStackTrace(); // will print the stack trace of the origin of the InterruptedException
        }
    }

    public void run() // No params
    {
        // Thread logic
        System.out.println("Running!");
    }
}
