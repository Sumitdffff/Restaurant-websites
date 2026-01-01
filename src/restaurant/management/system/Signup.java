package restaurant.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {

    JButton signup, login;
    JTextField lepassword, leusername;
    String username;

    Signup() {
        setLayout(null);
        setBounds(250, 100, 800, 500);
        getContentPane().setBackground(new Color(133, 193, 233));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/singup.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 350, 500);
        add(image);

        JLabel tital = new JLabel("Restaurant Management");
        tital.setBounds(400, 10, 350, 50);
        tital.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(tital);

        JLabel username = new JLabel("Enter Username:");
        username.setBounds(370, 110, 350, 30);
        username.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(username);

        leusername = new JTextField();
        leusername.setBounds(520, 110, 250, 30);
        add(leusername);

        JLabel password = new JLabel("Enter Password:");
        password.setBounds(370, 190, 250, 30);
        password.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(password);

        lepassword = new JTextField();
        lepassword.setBounds(520, 190, 250, 30);
        add(lepassword);

        signup = new JButton("Signup");
        signup.setBounds(420, 350, 130, 28);
        signup.setFont(new Font("Times New Roman", Font.BOLD, 16));
        signup.setBackground(Color.BLACK);
        signup.setBackground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        login = new JButton("Login");
        login.setBounds(600, 350, 130, 28);
        login.setFont(new Font("Times New Roman", Font.BOLD, 16));
        login.setBackground(Color.BLACK);
        login.setBackground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {

            try {

                 username = leusername.getText();
                String password = lepassword.getText();

                String query = "select * from login where username = '" + username + "' AND password='" + password + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    String username = leusername.getText();
                    new Dashbord(username).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, " Wrong User Password");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Login();
        }

    }

    public static void main(String[] arg) {
        new Signup();
    }
}
