import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ShoppingCartGUI extends JFrame implements ActionListener {
    // creates the labels, text fields, and buttons that will be added to the frame
    JLabel heading = new JLabel("Shopping Cart");
    //sets a default font size that will be used for things like the header
    Font bigFont = new Font("Arial", Font.BOLD, 16);
    JLabel pogoLabel = new JLabel("How many pogo sticks ($50) would you like to buy?");
    JTextField pogoField = new JTextField();
    JLabel cornLabel = new JLabel("How many corn dogs ($4) would you like to buy?");
    JTextField cornField = new JTextField();
    JLabel lightLabel = new JLabel("How many flashlights ($8) would you like to buy?");
    JTextField lightField = new JTextField();
    JButton press = new JButton("Confirm");
    //creates empty labels that will have user input added to
    JLabel priceSum = new JLabel("");
    JLabel priceTax = new JLabel("");
    //declares the default size for the frame
    final int WIDTH = 500;
    final int HEIGHT = 450;
    //UParty class
    public ShoppingCartGUI(){
        super("My Frame");
        //sets the width and height of the frame
        setSize(WIDTH,HEIGHT);
        setLayout(new BorderLayout());
        //creates a new gridlayout for the labels, buttons, and text fields
        JPanel gridPanel1 = new JPanel(new GridLayout(0, 1));
        //adds our elements to the grid layout.
        gridPanel1.add(heading);
        gridPanel1.add(pogoLabel);
        gridPanel1.add(pogoField);
        gridPanel1.add(cornLabel);
        gridPanel1.add(cornField);
        gridPanel1.add(lightLabel);
        gridPanel1.add(lightField);
        gridPanel1.add(priceSum);
        gridPanel1.add(priceTax);
        //sets the size and color of title text
        heading.setFont(bigFont);
        heading.setForeground(Color.red);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adds an action listener to the button
        press.addActionListener(this);
        //creates a new flowlayout for the confirm button
        JPanel button = new JPanel(new FlowLayout());
        button.add(press);
        //adds the panels to the frame
        add(gridPanel1, BorderLayout.NORTH);
        add(button, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final DecimalFormat df = new DecimalFormat("0.00");
        //creates new classes
        Item pogoStick = new Item("Pogo stick", 50);
        Item cornDog = new Item("Corn dog", 4);
        Item flashlight = new Item("Flashlight", 8);

        //establishes quantities of items into each item
        String pnum = pogoField.getText();
        int pQuant = (Integer.parseInt(pnum));
        ItemOrder pogoOrder = new ItemOrder(pogoStick, pQuant);

        String cnum = cornField.getText();
        int cQuant = (Integer.parseInt(cnum));
        ItemOrder cornOrder = new ItemOrder(cornDog, cQuant);

        String fnum = lightField.getText();
        int fQuant = (Integer.parseInt(fnum));
        ItemOrder lightOrder = new ItemOrder(flashlight, fQuant);

        ShoppingCart sc = new ShoppingCart(pogoOrder);
        sc.addArrayList(pogoOrder);
        sc.addArrayList(cornOrder);
        sc.addArrayList(lightOrder);

        double cost = 0;
        for (ItemOrder order : sc.getArrayList()) {
            cost += order.getItem().getPrice() * order.getAmnt(); // Accumulate the cost
        }
        double taxCost = (cost * 0.15) + cost;
        String total = "The total of your shopping cart is: $" + df.format(cost);
        priceSum.setText(total);
        String tTotal = "The total with tax is: $" + df.format(taxCost);
        priceTax.setText(tTotal);
    }

    //main function that runs the Party Class
    public static void main(String[] args) {

        ShoppingCartGUI ex = new ShoppingCartGUI();
        ex.setVisible(true);
    }
}