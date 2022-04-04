package SubmittedJunk;

import javax.swing.*;

public class OrderFormGUI
{
    public static void main(String[] args)
    {
        do {
            /** DO NOT CHANGE VALUES BELOW **/
            boolean hoodieInStock = true;
            boolean tshirtInStock = false;
            boolean longsleeveInStock = true;
            String item = "";
            int quantity = 0;
            String name = "";
            /** DO NOT CHANGE VALUES ABOVE **/

            // Code to get type of item
            boolean error;
            String[] options = {"Hoodie", "T-shirt", "Long sleeve"};

            do {
                item = (String) JOptionPane.showInputDialog(null, "Select item style ", "Order Form",
                        JOptionPane.PLAIN_MESSAGE, null, options, null);
                error = item.compareTo("T-shirt") == 0;

                if (error)
                    JOptionPane.showMessageDialog(null,
                            "That item is not in stock. Please select another item.", "Out of Stock",
                            JOptionPane.ERROR_MESSAGE);
            } while (error);

            // Code to get quantity of item
            do {
                error = false;

                try {
                    quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter quantity", "Order Form",
                            JOptionPane.QUESTION_MESSAGE));
                } catch (NumberFormatException e) {
                    error = true;
                    JOptionPane.showMessageDialog(null, "Enter and integer",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }

                if (quantity <= 0 && !error) {
                    error = true;
                    JOptionPane.showMessageDialog(null, "Enter a number greater than 0",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }

            } while (error);

            // Code to get name for order
            //TODO: display error GUI if input does not include a space
            do {
                error = false;
                name = JOptionPane.showInputDialog(null, "Enter your Name", "Order Form",
                        JOptionPane.QUESTION_MESSAGE);

                if (name.indexOf(" ") == -1) {
                    error = true;
                    JOptionPane.showMessageDialog(null, "Enter first and last name",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (error);


            /** Order Confirmation Message **/
            String resultMessage = "Name: " + name + "\nItem: " + item + "\nQuantity: " + quantity;
            JOptionPane.showMessageDialog(null, resultMessage, "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);

        } while (0 == JOptionPane.showConfirmDialog(null, "Would you like to place another order?",
                "Order Form", JOptionPane.YES_NO_OPTION));


    }
}
