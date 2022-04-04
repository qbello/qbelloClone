import java.io.*;
import java.net.*;

public class SimpleServer
{

    public static void main(String[] args)
    {
        ServerSocket serverSocket = null;

        try
        {
            serverSocket = new ServerSocket(4242);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("Waiting for the client to connect...");
        Socket socket = null;

        try
        {
            socket = serverSocket.accept();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("Client connected!");

        BufferedReader reader = null;
        PrintWriter writer = null;

        try
        {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        String message = null;

        try
        {
            message = reader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.printf("Received from client:\n%s\n", message);
        String response = message.replaceAll(" ",",");
        writer.write(response);
        writer.println();
        writer.flush(); // Ensure data is sent to the client.
        System.out.printf("Sent to client:\n%s\n", response);
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