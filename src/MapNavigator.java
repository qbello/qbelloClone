import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class that creates a 10x10 field with an X in it for multiple players to move around
 *
 * CS180 Purdue University Spring 2022
 *
 * @author Quintin Bello
 * @version 3/30/2022
 */

public class MapNavigator extends Thread
{
    private static AtomicInteger currentRow = new AtomicInteger(4);
    private static AtomicInteger currentColumn = new AtomicInteger(4);
    private static AtomicInteger moveNumber = new AtomicInteger(0);
    private static boolean started;
    private static char[][] map = new char[10][10];
    private int playerNumber;
    private String fileName;

    public MapNavigator(int playerNumber, String filename)
    {
        this.playerNumber = playerNumber;
        this.fileName = filename;

        for (int col = 0; col < 10; col++)
            for (int row = 0; row < 10; row++)
                map[col][row] = ' ';

        map[4][4] = 'X';
    }

    public void printBoard()
    {
        for (int col = 0; col < 10; col++)
        {
            System.out.print("[");
            for (int row = 0; row < 10; row++)
            {
                System.out.print(map[col][row]);

                if (row != 9)
                    System.out.print("|");
            }
            System.out.println("]");
            System.out.println("---------------------");
        }
    }

    public void run()
    {
        // iterate through each line of the file and apply the move to the character in the map
        String line;
        BufferedReader fromFile = null;

        try
        {
            fromFile = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        try
        {
            while ((line = fromFile.readLine()) != null)
            {
                try
                {
                    int move = Integer.parseInt(line);
                    map[currentColumn.get()][currentRow.get()] = ' ';

                    switch (move)
                    {
                        case 1:
                            currentColumn.getAndDecrement();
                            break;
                        case 2:
                            currentColumn.getAndIncrement();
                            break;
                        case 3:
                            currentRow.getAndDecrement();
                            break;
                        case 4:
                            currentRow.getAndIncrement();
                            break;
                        default:
                            System.out.println("Error, invalid input!");
                    }

                    map[currentColumn.get()][currentRow.get()] = 'X';

                } catch (NumberFormatException e)
                {
                    System.out.println("Error, invalid input!");
                }

                moveNumber.getAndIncrement();

                System.out.println("Move number: " + moveNumber);
                System.out.println("Player: " + playerNumber);
                System.out.println("Move: " + line);
                printBoard();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        MapNavigator mapNav = new MapNavigator(0, "schmutz");
        System.out.println("Welcome! Initial map:");
        mapNav.printBoard();

        try
        {
            MapNavigator[] mapNavigators = {new MapNavigator(1, "PlayerOneMoves.txt"),
                new MapNavigator(2, "PlayerTwoMoves.txt")};

            for (int i = 0; i < mapNavigators.length; i++)
                mapNavigators[i].start();

            for (int i = 0; i < mapNavigators.length; i++)
                mapNavigators[i].join();

        } catch (Exception ex)
        {
            ex.printStackTrace();
            return;
        }
    }

}
