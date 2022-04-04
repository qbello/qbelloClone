package SubmittedJunk;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleClient
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;

        try
        {
            socket = new Socket("localhost", 4242);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("What do you want to send to the server?");
        String response = scan.nextLine();

        writer.write(response);
        writer.println();
        writer.flush(); // ensure data is sent to the server
        System.out.printf("Sent to server:\n%s\n", response);

        String s1 = null;

        try
        {
            s1 = reader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.printf("Received from server:\n%s\n", s1);
        writer.close();

        try
        {
            reader.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
