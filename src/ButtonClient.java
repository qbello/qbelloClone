import javafx.util.Pair;
import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * A class for clients of a crazy fun clicking game! (socket number: 123)
 *
 * CS18000 Spring 2022 HW 11 Challenge
 *
 * @author Quinn Bello
 * @version 4/6/22
 */

//  @#@# SOCKET NUMBER: 123 #@#@ \\

public class ButtonClient
{
    public static void main(String[] args)
    {
        // step 1
        JOptionPane.showMessageDialog(null, "Welcome to an exciting clicking game!",
                "Welcome", JOptionPane.INFORMATION_MESSAGE);
        Scanner fromKeyboard = new Scanner(System.in);
        int totalSeshClicks = 0;
        ButtonClient thisGame = new ButtonClient();

        // step 2
        Pair<Boolean, Socket> clientPair = thisGame.getPortInfo();
        Socket socket = clientPair.getValue();
        boolean isClear = !clientPair.getKey();

        // step 3
        while (isClear)
        {
            JOptionPane.showMessageDialog(null, "Connection established successfully.",
                    "Connection Established", JOptionPane.INFORMATION_MESSAGE);
            BufferedReader reader = null;
            PrintWriter writer = null;
            int reply = 1;

            try
            {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream());
                System.out.println("Step 4");
                reply = JOptionPane.showConfirmDialog(null, "Are you ready to play?" +
                        "\nPast Players: " + reader.readLine(), "Ready?", JOptionPane.YES_NO_OPTION);
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            // Step 4
            int userClickCount = 0;

            // Entry point
            while (reply == 0)
            {
                // Step 5
                JOptionPane.showOptionDialog(null, "Click if you want", "The Game",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Click here"},
                        "Click here");
                // after clicking, add to click count
                userClickCount++;

                // Step 6
                reply = JOptionPane.showOptionDialog(null, "Would you like to click some more?", "Continue?",
                        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
            }
            // Either the window gets closed or they choose not to click anymore

            // Send click info to server
            writer.write("" + userClickCount);
            writer.println();
            writer.flush();

            // Get session info from server: clicks this session, average clicks per player
            double avgClicks = -1;

            try
            {
                totalSeshClicks = Integer.parseInt(reader.readLine());
                avgClicks = Double.parseDouble(reader.readLine());
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            // Step 7
            JOptionPane.showOptionDialog(null, "Clicks this round: " + userClickCount +
                    "\nClicks this session: " + totalSeshClicks + "\nAverage clicks per person: " + avgClicks,
                    "Game Statistics", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                    new String[]{"Done"}, "Done");

            // Step 8
            reply = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Play Again?",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

            writer.close();

            try
            {
                reader.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            if (reply == 0)
            {
                // Step 2
                clientPair = thisGame.getPortInfo();
                socket = clientPair.getValue();
                isClear = !clientPair.getKey();
            } else
                isClear = false;

            // Below here is all the learning/ testing I did
//            int players = 0;
//
//            try
//            {
//                String line = reader.readLine();
//                System.out.println("setting 'line' to second line");
//                System.out.println("Line: " + line);
//                players = Integer.parseInt(line);
//            } catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//
//            System.out.println("Players: " + players);
//
//            while (players != 69)
//            {
//                System.out.println("Current players: " + players);
//                System.out.println("Enter new number of players");
//                players = fromKeyboard.nextInt();
//                fromKeyboard.nextLine();
//                writer.write("" + players);
//                writer.println();
//                writer.flush();
//            }
        }

        // Step 9
        JOptionPane.showMessageDialog(null, "Thank you for playing!",
                "Goodbye", JOptionPane.INFORMATION_MESSAGE);

    }

    public Pair<Boolean, Socket> getPortInfo()
    {
        String hostName = JOptionPane.showInputDialog(null, "Enter the host name:",
                "Host Name", JOptionPane.QUESTION_MESSAGE);
        String portNumber = JOptionPane.showInputDialog(null, "Enter the port number:",
                "Port Number", JOptionPane.QUESTION_MESSAGE);

        boolean inError = false;
        Socket socket = null;

        try
        {
            socket = new Socket(hostName, Integer.parseInt(portNumber));
        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Port number must be an integer!",
                    "Port Number Error", JOptionPane.WARNING_MESSAGE);
            inError = true;
        } catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "I/O error with port initialization.",
                    "Port Initialization Error", JOptionPane.WARNING_MESSAGE);
            inError = true;
        }

        return new Pair<>(inError, socket);
    }
}
