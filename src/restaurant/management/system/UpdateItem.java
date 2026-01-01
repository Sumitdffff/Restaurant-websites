package restaurant.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateItem extends JFrame implements ActionListener {

    JLabel leusername;
    JButton back, update;
    JTextField lefood, leitem, lecity, leaddress;
    JComboBox ledrink, lestate;
    String username;

    UpdateItem(String username) {

        this.username = username;

        setLayout(null);
        setBounds(200, 100, 800, 500);
        getContentPane().setBackground(new Color(240, 240, 240));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/HHHH.jfif"));
        Image i2 = i1.getImage().getScaledInstance(350, 500, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(450, 0, 350, 500);
        add(image1);

        JLabel title = new JLabel("Update Items");
        title.setBounds(150, 20, 200, 30);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(title);

        JLabel username1 = new JLabel("Username:");
        username1.setBounds(20, 70, 200, 30);
        username1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(username1);

        leusername = new JLabel();
        leusername.setBounds(160, 70, 200, 25);
        add(leusername);

        JLabel food = new JLabel("Food:");
        food.setBounds(20, 115, 200, 30);
        food.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(food);

        lefood = new JTextField("Null");
        lefood.setBounds(160, 120, 200, 25);
        add(lefood);

        JLabel Item = new JLabel("Item no. :");
        Item.setBounds(20, 160, 200, 30);
        Item.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(Item);

        leitem = new JTextField("1");
        leitem.setBounds(160, 165, 200, 25);
        add(leitem);

        JLabel drink = new JLabel("Cold Drink:");
        drink.setBounds(20, 205, 200, 30);
        drink.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(drink);

        ledrink = new JComboBox(new String[]{"Null", "Coca-Cola", "Pepsi", "Sprite"});
        ledrink.setBounds(160, 210, 200, 25);
        ledrink.setBackground(Color.WHITE);
        add(ledrink);

        JLabel address = new JLabel("Address:");
        address.setBounds(20, 250, 200, 30);
        address.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(address);

        leaddress = new JTextField();
        leaddress.setBounds(160, 255, 200, 25);
        add(leaddress);

        JLabel city = new JLabel("City:");
        city.setBounds(20, 295, 200, 30);
        city.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(city);

        lecity = new JTextField();
        lecity.setBounds(160, 300, 200, 25);
        add(lecity);

        JLabel state = new JLabel("State:");
        state.setBounds(20, 340, 100, 30);
        state.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(state);

        lestate = new JComboBox(new String[]{"Maharashtra ", "Tamil Nadu", "Uttar Pradesh"});
        lestate.setBounds(160, 345, 200, 25);
        lestate.setBackground(Color.WHITE);
        add(lestate);

        update = new JButton("Add Update");
        update.setBounds(60, 420, 130, 30);
        update.setFont(new Font("Times New Roman", Font.BOLD, 16));
        update.setBackground(new Color(52, 58, 64));
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(260, 420, 100, 30);
        back.setFont(new Font("Times New Roman", Font.BOLD, 16));
        back.setBackground(new Color(52, 58, 64));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from additem where username = '" + username + "'");

            while (rs.next()) {
                leusername.setText(rs.getString("username"));
                leaddress.setText(rs.getString("address"));
                lecity.setText(rs.getString("city"));
                lefood.setText(rs.getString("Food"));
                leitem.setText(rs.getString("item"));
                ledrink.setSelectedItem(rs.getString("drink"));
                lestate.setSelectedItem(rs.getString("state"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == update) {
            String username = leusername.getText();
            String food = lefood.getText();
            String item = leitem.getText();
            String drink = (String) ledrink.getSelectedItem();
            String address = leaddress.getText();
            String city = lecity.getText();
            String state = (String) lestate.getSelectedItem();

            String query = "UPDATE additem SET food = '" + food + "', item = '" + item + "', drink = '" + drink + "', city = '" + city + "', state = '" + state + "', address = '" + address + "' WHERE username = '" + username + "'";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Order updeted Succsessfully");

                setVisible(false);
                new Dashbord(username);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Dashbord(username).setVisible(true);
        }

    }

    public static void main(String[] arg) {
        new UpdateItem("");
    }
}
