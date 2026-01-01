package restaurant.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JButton create, back;
    JTextField leusername, lename, lepassword, ledob, leage, lephone, leaddress;
    JRadioButton male, female;

    Login() {
        setLayout(null);
        setBounds(200, 50, 800, 600);
        getContentPane().setBackground(new Color(220, 240, 230));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/H.jfif"));
        Image i2 = i1.getImage().getScaledInstance(300, 570, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 300, 570);
        add(image);

        JLabel title = new JLabel("Employee Details");
        title.setBounds(150, 20, 430, 50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        title.setBackground(Color.BLACK);
        title.setBackground(Color.WHITE);
        add(title);

        JLabel username = new JLabel("Username:");
        username.setBounds(50, 100, 250, 25);
        username.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(username);

        leusername = new JTextField();
        leusername.setBounds(180, 100, 200, 25);
        add(leusername);

        JLabel name = new JLabel("Name:");
        name.setBounds(50, 150, 250, 25);
        name.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(name);

        lename = new JTextField();
        lename.setBounds(180, 150, 200, 25);
        add(lename);

        JLabel password = new JLabel("Password:");
        password.setBounds(50, 200, 250, 25);
        password.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(password);

        lepassword = new JTextField();
        lepassword.setBounds(180, 200, 200, 25);
        add(lepassword);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(50, 250, 250, 25);
        gender.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(180, 250, 80, 25);
        male.setBackground(getContentPane().getBackground());
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(270, 250, 100, 25);
        female.setBackground(getContentPane().getBackground());
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel dob = new JLabel("date of birth:");
        dob.setBounds(50, 300, 250, 25);
        dob.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(dob);

        ledob = new JTextField();
        ledob.setBounds(180, 300, 200, 25);
        add(ledob);

        JLabel age = new JLabel("Age:");
        age.setBounds(50, 350, 250, 25);
        age.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(age);

        leage = new JTextField();
        leage.setBounds(180, 350, 200, 25);
        add(leage);

        JLabel phone = new JLabel("Phone:");
        phone.setBounds(50, 400, 250, 25);
        phone.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(phone);

        lephone = new JTextField();
        lephone.setBounds(180, 400, 200, 25);
        add(lephone);

        JLabel address = new JLabel("Address:");
        address.setBounds(50, 450, 250, 25);
        address.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(address);

        leaddress = new JTextField();
        leaddress.setBounds(180, 450, 200, 25);
        add(leaddress);

        create = new JButton("Create");
        create.setBounds(90, 520, 130, 28);
        create.setFont(new Font("Times New Roman", Font.BOLD, 16));
        create.setBackground(Color.BLACK);
        create.setBackground(Color.WHITE);
        create.addActionListener(this);
        add(create);

        back = new JButton("Back");
        back.setBounds(280, 520, 130, 28);
        back.setFont(new Font("Times New Roman", Font.BOLD, 16));
        back.setBackground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String username = leusername.getText();
            String name = lename.getText();
            String password = lepassword.getText();
            String gender = null;

            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            }
            String dob = ledob.getText();
            String age = leage.getText();
            String phone = lephone.getText();
            String address = leaddress.getText();
            
            String query ="insert into login values('"+username+"','"+name+"','"+password+"','"+gender+"','"+dob+"','"+age+"','"+phone+"','"+address+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Account Created Succsessfully");
                
                setVisible(false);
                new Signup();
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Signup();
        }
    }

    public static void main(String[] arg) {
        new Login();
    }
}
