package restaurant.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteItem extends JFrame implements ActionListener {

    JLabel leusername, lefood, leitem, ledrink, lecity, lestate, leaddress;
    JButton delete, back;
    String username;

    DeleteItem(String username) {

        this.username = username;
        setLayout(null);
        setBounds(230, 100, 800, 500);
        getContentPane().setBackground(new Color(245, 235, 200));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/J.jfif"));
        Image i2 = i1.getImage().getScaledInstance(300, 500, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 300, 500);
        add(image);

        JLabel title = new JLabel("Delete Items");
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

        JLabel state = new JLabel("State:");
        state.setBounds(320, 295, 200, 30);
        state.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(state);

        lestate = new JLabel();
        lestate.setBounds(450, 295, 200, 30);
        lestate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(lestate);

        JLabel address = new JLabel("Address:");
        address.setBounds(320, 340, 200, 30);
        address.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(address);

        leaddress = new JLabel();
        leaddress.setBounds(450, 340, 200, 30);
        leaddress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(leaddress);

        delete = new JButton("Delete");
        delete.setBounds(350, 420, 130, 30);
        delete.setFont(new Font("Times New Roman", Font.BOLD, 16));
        delete.setBackground(new Color(52, 58, 64));
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(580, 420, 100, 30);
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
                lestate.setText(rs.getString("state"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("DELETE FROM additem WHERE username='" + username + "'");
                JOptionPane.showMessageDialog(null, "Item Deleted Successfully");
                setVisible(false);
                new Dashbord(username).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Dashbord("").setVisible(true);
        }
    }

    public static void main(String[] arg) {
        new DeleteItem("");
    }
}
