import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * A simplified version of Microsoft Paint
 *
 * CS18000 Spring 2022 HW-12 Challenge
 *
 * @author Quinn Bello
 * @version 4/12/22
 */

public class Paint extends JComponent implements Runnable
{
    /*
     * The GUI appears in center of screen
     * Top Panel has 4 buttons: Clear, Fill, Erase, Random
     * Middle section is white canvas
     * Bottom Panel has Hex TextField, Hex Button, R TextField, G TextField, B TextField, RGB Button
     */

    Image image; // the canvas *specific to pain program*
    Graphics2D graphics2D;  // this will enable drawing *specific to paint program*
    int curX; // current mouse x coordinate
    int curY; // current mouse y coordinate
    int oldX; // previous mouse x coordinate
    int oldY; // previous mouse y coordinate

    JButton clearButton; // the button for the clearing functionality
    JButton fillButton; // button for filling canvas
    JButton eraseButton; // button for erasing
    JButton randomButton; // button for random?

    Color curDrawColor = Color.black; // active drawing color
    Color backgroundColor = Color.white;
    Paint paint; // object of this class
    JTextField hexText;
    JButton hexButton;
    TextField redTextField;
    TextField greenTextField;
    TextField blueTextField;
    JButton rgbButton;

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Paint());
    }

    public void draw()
    {

    }

    public void setGraphicsColor(Color color)
    {
        graphics2D.setPaint(color);
    }

    public void drawFullScreenRectangle()
    {
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
    }

    /* action listener for buttons */
    ActionListener actionListener = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
//            clearButton = new JButton("Clear");
//            fillButton = new JButton("Fill");
//            eraseButton = new JButton("Erase");
//            randomButton = new JButton("Random");
//            hexButton = new JButton("Hex");
//            rgbButton = new JButton("RGB");

            if (e.getSource() == clearButton)
            {
                // set canvas to white with default paint color
                paint.setGraphicsColor(Color.white);
                paint.drawFullScreenRectangle();
                curDrawColor = Color.black;
                paint.setGraphicsColor(Color.black);
                paint.repaint();
                hexText.setText("#");
                redTextField.setText("");
                greenTextField.setText("");
                blueTextField.setText("");
            }

            if (e.getSource() == fillButton)
            {
                // fill canvas with current drawing color and reset drawing color to black
                paint.setGraphicsColor(curDrawColor);
                paint.drawFullScreenRectangle();
                backgroundColor = curDrawColor;
                curDrawColor = Color.black;
                paint.setGraphicsColor(curDrawColor);
                paint.repaint();
                hexText.setText("#");
                redTextField.setText("");
                greenTextField.setText("");
                blueTextField.setText("");
            }

            if (e.getSource() == eraseButton)
            {
                paint.setGraphicsColor(backgroundColor);
                paint.repaint();
            }

            if (e.getSource() == randomButton)
            {
                Random random = new Random();
                int r = random.nextInt(256);
                int g = random.nextInt(256);
                int b = random.nextInt(256);
                Color randomColor = new Color(r, g, b);
                curDrawColor = randomColor;
                paint.setGraphicsColor(curDrawColor);
                hexText.setText(String.format("#%02x%02x%02x", r, g, b));
                redTextField.setText("" + r);
                greenTextField.setText("" + g);
                blueTextField.setText("" + b);
                paint.repaint();
            }

            if (e.getSource() == hexButton)
            {
                try
                {
                    curDrawColor = Color.decode(hexText.getText());
                    paint.setGraphicsColor(curDrawColor);
                    redTextField.setText("" + curDrawColor.getRed());
                    greenTextField.setText("" + curDrawColor.getGreen());
                    blueTextField.setText("" + curDrawColor.getBlue());
                    paint.repaint();
                } catch (NumberFormatException exception)
                {
                    JOptionPane.showMessageDialog(null, "Not a valid Hex Value",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (e.getSource() == rgbButton)
            {
                String r = redTextField.getText();
                String g = greenTextField.getText();
                String b = blueTextField.getText();

                if (r.compareTo("") == 0)
                    redTextField.setText("0");

                if (g.compareTo("") == 0)
                    greenTextField.setText("0");

                if (b.compareTo("") == 0)
                    blueTextField.setText("0");

                r = redTextField.getText();
                g = greenTextField.getText();
                b = blueTextField.getText();

                try
                {
                    Color rgbColor = new Color(Integer.parseInt(r), Integer.parseInt(g), Integer.parseInt(b));
                    curDrawColor = rgbColor;
                    paint.setGraphicsColor(rgbColor);
                    hexText.setText(String.format("#%02x%02x%02x", Integer.parseInt(r), Integer.parseInt(g),
                            Integer.parseInt(b)));
                    paint.repaint();
                } catch (IllegalArgumentException except)
                {
                    JOptionPane.showMessageDialog(null, "Not a valid RGB Value",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    };

    public void run()
    {
        JFrame frame = new JFrame("Simple Paint Walkthrough");
        Container content = frame.getContentPane();

        content.setLayout(new BorderLayout());
        paint = new Paint();
        content.add(paint, BorderLayout.CENTER);

        clearButton = new JButton("Clear");
        fillButton = new JButton("Fill");
        eraseButton = new JButton("Erase");
        randomButton = new JButton("Random");
        hexButton = new JButton("Hex");
        rgbButton = new JButton("RGB");

        clearButton.addActionListener(actionListener);
        fillButton.addActionListener(actionListener);
        eraseButton.addActionListener(actionListener);
        randomButton.addActionListener(actionListener);
        hexButton.addActionListener(actionListener);
        rgbButton.addActionListener(actionListener);

        hexText = new JTextField("#", 10);
        redTextField = new TextField("", 5);
        greenTextField = new TextField("", 5);
        blueTextField = new TextField("", 5);

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.add(clearButton);
        panel.add(fillButton);
        panel.add(eraseButton);
        panel.add(randomButton);
        content.add(panel, BorderLayout.NORTH);

        panel = new JPanel();
        panel.add(hexText);
        panel.add(hexButton);
        panel.add(redTextField);
        panel.add(greenTextField);
        panel.add(blueTextField);
        panel.add(rgbButton);
        content.add(panel, BorderLayout.SOUTH);

        draw();
    }

    public Paint()
    {
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                // set oldX and oldY coordinates to beginning mouse press
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                // set current coordinates to where mouse is being dragged
                curX = e.getX();
                curY = e.getY();

                // draw the line between old coordinates and new ones
                graphics2D.drawLine(oldX, oldY, curX, curY);

                // refresh frame and reset old coordinates
                repaint();
                oldX = curX;
                oldY = curY;

            }
        });
    }

    protected void paintComponent(Graphics g)
    {
        if (image == null)
        {
            image = createImage(getSize().width, getSize().height);

            // this lets us draw on the image (ie. the canvas)
            graphics2D = (Graphics2D) image.getGraphics();

            // gives us better rendering quality for the drawing lines
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            // set canvas to white with default paint color
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);
            graphics2D.setStroke(new BasicStroke(5));
            repaint();
        }

        g.drawImage(image, 0, 0, null);
    }
}
