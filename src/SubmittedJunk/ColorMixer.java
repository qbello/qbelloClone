package SubmittedJunk;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ColorMixer
{
    public static void main(String[] args) {
        // scanner
        Scanner fromKeyboard = new Scanner(System.in);
        // input file name
        System.out.println("Enter the filename of the color map.");
        String filename = fromKeyboard.nextLine();

        // read the file, handle file read error
        Color[] cols = new Color[0];

        try
        {
            cols = readFile(filename);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        // prompt for output file name and handle error
        System.out.println("Enter the filename to output the colors to.");
        writeFile(cols, fromKeyboard.nextLine());
        // print success
        System.out.println("The file was written to!");
    }

    public static Color[] readFile(String filename) throws IOException
    {
        // must be multiple of 3 lines
        String line = "";
        BufferedReader fromFile = null;
        ArrayList<Color> cols = new ArrayList<>();
        int red = 0;
        int green = 0;
        int blue = 0;

        try
        {
            fromFile = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }

        while ((line = fromFile.readLine()) != null)
        {
            red = Integer.parseInt(line);

            if ((line = fromFile.readLine()) != null)
                green = Integer.parseInt(line);
            else
                return null;

            if ((line = fromFile.readLine()) != null)
                blue = Integer.parseInt(line);
            else
                return null;

            cols.add(new Color(red, green, blue));
        }

        return cols.toArray(new Color[cols.size()]);
    }

    public static boolean writeFile(Color[] colors, String filename)
    {
        PrintWriter writer = null;

        try
        {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        } catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }

        for (Color col : colors)
            writer.println(col.toString());

        writer.close();
        return true;
    }
}
