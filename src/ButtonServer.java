import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * A class for servers for a crazy fun clicking game !!! (socket number: 123)
 *
 * CS18000 Spring 2022 HW 11 Challenge
 *
 * @author Quinn Bello
 * @version 4/6/22
 */

//  @#@# SOCKET NUMBER: 123 #@#@ \\

public class ButtonServer
{
    public static void main(String[] args)
    {
        int numberOfPlayers = 0;
        ServerSocket serverSocket = null;
        Scanner fromKeyboard = new Scanner(System.in);

        try
        {
            serverSocket = new ServerSocket(123);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;

        try
        {
            socket = serverSocket.accept();
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
            writer.write("" + numberOfPlayers);
            writer.println();
            writer.flush();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        String line = "";
        int clicks = 0;
        double avgClicks = 0;

        try
        {
            while ((line = reader.readLine()) != null || socket.getInetAddress().isReachable(1000))
            {
                // Do calculations then send to client
                numberOfPlayers++;
                clicks += Integer.parseInt(line);
                writer.write("" + clicks);
                writer.println();

                avgClicks = (double) clicks / numberOfPlayers;
                avgClicks *= 100;
                avgClicks = Math.round(avgClicks);
                avgClicks /= 100;

                writer.write("" + avgClicks);
                writer.println();
                writer.flush();

                socket = serverSocket.accept();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream());
                writer.write("" + numberOfPlayers);
                writer.println();
                writer.flush();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        writer.close();
    }
}
