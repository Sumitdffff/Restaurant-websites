package restaurant.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Order extends JFrame implements ActionListener {

    JLabel leusername, lefood, leitem, ledrink, lecity, leaddress, leprice;
    JButton billing, back, check;
    String username;

    Order(String username) {

        this.username = username;
        setLayout(null);
        setBounds(230, 100, 800, 500);
        getContentPane().setBackground(new Color(245, 235, 200));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/JJ.jfif"));
        Image i2 = i1.getImage().getScaledInstance(300, 500, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 300, 500);
        add(image);

        JLabel title = new JLabel("Order");
        title.setBounds(460, 20, 200, 30);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(title);

        JLabel username1 = new JLabel("Username:");
        username1.setBounds(320, 70, 200, 30);
        username1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(username1);

        leusername = new JLabel();
        leusername.setBounds(450, 70, 200, 30);
        leusername.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(leusername);

        JLabel food = new JLabel("Food:");
        food.setBounds(320, 115, 200, 30);
        food.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(food);

        lefood = new JLabel();
        lefood.setBounds(450, 115, 200, 30);
        lefood.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(lefood);

        JLabel item = new JLabel("Item:");
        item.setBounds(320, 160, 200, 30);
        item.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(item);

        leitem = new JLabel();
        leitem.setBounds(450, 160, 200, 30);
        leitem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(leitem);

        JLabel drink = new JLabel("Drink:");
        drink.setBounds(320, 205, 200, 30);
        drink.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(drink);

        ledrink = new JLabel();
        ledrink.setBounds(450, 205, 200, 30);
        ledrink.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(ledrink);

        JLabel city = new JLabel("City:");
        city.setBounds(320, 250, 200, 30);
        city.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(city);

        lecity = new JLabel();
        lecity.setBounds(450, 250, 200, 30);
        lecity.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(lecity);

        JLabel address = new JLabel("Address:");
        address.setBounds(320, 295, 200, 30);
        address.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(address);

        leaddress = new JLabel();
        leaddress.setBounds(450, 295, 200, 30);
        leaddress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(leaddress);

        JLabel price = new JLabel("Total Price:");
        price.setBounds(320, 340, 200, 30);
        price.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(price);

        leprice = new JLabel();
        leprice.setBounds(450, 340, 200, 30);
        leprice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(leprice);

        billing = new JButton("Billing");
        billing.setBounds(340, 420, 100, 30);
        billing.setFont(new Font("Times New Roman", Font.BOLD, 16));
        billing.setBackground(new Color(52, 58, 64));
        billing.setForeground(Color.WHITE);
        billing.addActionListener(this);
        add(billing);

        check = new JButton("Check Price");
        check.setBounds(480, 420, 130, 30);
        check.setFont(new Font("Times New Roman", Font.BOLD, 16));
        check.setBackground(new Color(52, 58, 64));
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        back = new JButton("Back");
        back.setBounds(650, 420, 100, 30);
        back.setFont(new Font("Times New Roman", Font.BOLD, 16));
        back.setBackground(new Color(52, 58, 64));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from additem Where username='" + username + "'");

            while (rs.next()) {
                leusername.setText(rs.getString("username"));
                leaddress.setText(rs.getString("address"));
                lecity.setText(rs.getString("city"));
                lefood.setText(rs.getString("food"));
                leitem.setText(rs.getString("item"));
                ledrink.setText(rs.getString("drink"));
                leprice.setText(rs.getString("price"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == check) {

            String food = lefood.getText();
            String item = leitem.getText();   // item = quantity
            String drink = ledrink.getText();

            int totalPrice = calculatePrice(food, item, drink);

            leprice.setText("₹ " + totalPrice);

            try {
                Conn c = new Conn();
                String query = "UPDATE additem SET price='" + totalPrice
                        + "' WHERE username='" + username + "'";
                c.s.executeUpdate(query);
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == billing) {

            setVisible(false);
            new Billing(username).setVisible(true);

        } else if (ae.getSource() == back) {

            setVisible(false);
            new Dashbord(username).setVisible(true);
        }
    }

    private int calculatePrice(String food, String item, String drink) {

        int foodPrice = 300; // per food price
        int quantity = Integer.parseInt(item); // item = quantity

        int drinkPrice = 0;

        if (drink.equalsIgnoreCase("Coca-Cola")) {
            drinkPrice = 50;
        } else if (drink.equalsIgnoreCase("Pepsi")) {
            drinkPrice = 40;
        } else if (drink.equalsIgnoreCase("Sprite")) {
            drinkPrice = 45;
        }

        return (foodPrice * quantity) + drinkPrice;
    }

    public static void main(String[] arg) {
        new Order("");
    }
}
