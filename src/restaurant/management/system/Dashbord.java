package restaurant.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashbord extends JFrame implements ActionListener {

    JButton about, add, menu, update, delete, pbooking, belling, payment;
    String username;

    Dashbord(String username) {

        this.username = username;

        setLayout(null);
        setBounds(0, 0, 1290, 670);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/HH.jfif"));
        Image i2 = i1.getImage().getScaledInstance(1290, 640, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 30, 1290, 640);
        add(image);

        JPanel line = new JPanel();
        line.setLayout(null);
        line.setBounds(0, 0, 1300, 30);
        line.setBackground(new Color(33, 47, 61));
        add(line);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icons/HH.jfif"));
        Image i6 = i5.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel image1 = new JLabel(i7);
        image1.setBounds(5, 5, 20, 20);
        line.add(image1);

        JLabel heading = new JLabel("Restaurant Management System");
        heading.setBounds(35, 0, 300, 30);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 20));
        heading.setForeground(Color.WHITE);
        line.add(heading);

        JPanel line1 = new JPanel();
        line1.setLayout(null);
        line1.setBounds(0, 320, 180, 640);
        line1.setBackground(new Color(112, 128, 144));
        image.add(line1);

        JLabel userLabel = new JLabel("Welcome, " + username);
        userLabel.setBounds(900, 0, 300, 30);
        userLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        userLabel.setForeground(Color.WHITE);
        line.add(userLabel);

        menu = new JButton("Menu");
        menu.setBounds(0, 0, 180, 40);
        menu.setFont(new Font("Times New Roman", Font.BOLD, 18));
        menu.setBackground(new Color(112, 128, 144));
        menu.setForeground(Color.WHITE);
        menu.addActionListener(this);
        image.add(menu);

        add = new JButton("Add Item");
        add.setBounds(0, 40, 180, 40);
        add.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add.setBackground(new Color(112, 128, 144));
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        image.add(add);

        update = new JButton("Update Item");
        update.setBounds(0, 80, 180, 40);
        update.setFont(new Font("Times New Roman", Font.BOLD, 18));
        update.setBackground(new Color(112, 128, 144));
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        image.add(update);

        delete = new JButton("Delete Item");
        delete.setBounds(0, 120, 180, 40);
        delete.setFont(new Font("Times New Roman", Font.BOLD, 18));
        delete.setBackground(new Color(112, 128, 144));
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        image.add(delete);

        pbooking = new JButton("Order");
        pbooking.setBounds(0, 160, 180, 40);
        pbooking.setFont(new Font("Times New Roman", Font.BOLD, 18));
        pbooking.setBackground(new Color(112, 128, 144));
        pbooking.setForeground(Color.WHITE);
        pbooking.addActionListener(this);
        image.add(pbooking);

        belling = new JButton("Billing");
        belling.setBounds(0, 200, 180, 40);
        belling.setFont(new Font("Times New Roman", Font.BOLD, 18));
        belling.setBackground(new Color(112, 128, 144));
        belling.setForeground(Color.WHITE);
        belling.addActionListener(this);
        image.add(belling);

        payment = new JButton("Payment");
        payment.setBounds(0, 240, 180, 40);
        payment.setFont(new Font("Times New Roman", Font.BOLD, 18));
        payment.setBackground(new Color(112, 128, 144));
        payment.setForeground(Color.WHITE);
        payment.addActionListener(this);
        image.add(payment);

        about = new JButton("About");
        about.setBounds(0, 280, 180, 40);
        about.setFont(new Font("Times New Roman", Font.BOLD, 18));
        about.setBackground(new Color(112, 128, 144));
        about.setForeground(Color.WHITE);
        image.add(about);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new Menu(username).setVisible(true);
        } else if (ae.getSource() == menu) {
            setVisible(false);
            new Menu(username).setVisible(true);
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateItem(username).setVisible(true);
        } else if (ae.getSource() == delete) {
            setVisible(false);
            new DeleteItem(username).setVisible(true);
        } else if (ae.getSource() ==  pbooking) {
            setVisible(false);
            new Order(username).setVisible(true);
        } else if (ae.getSource() ==  belling) {
            setVisible(false);
            new  Billing(username).setVisible(true);
        } else if (ae.getSource() ==  payment) {
            setVisible(false);
            new  Payment().setVisible(true);
        }
    }

    public static void main(String[] arg) {
        new Dashbord("username");
    }
}
