package restaurant.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Menu extends JFrame implements ActionListener {

    JLabel leusername,leaddress;
    JButton add,back;
    JTextField lefood,leitem,lecity;
    JComboBox ledrink,lestate;
    String username;

    Menu(String username) {
        
        this.username = username;
        
        setLayout(null);
        setBounds(200, 100, 800, 500);
        getContentPane().setBackground(new Color(133, 199, 233));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/HHH.jfif"));
        Image i2 = i1.getImage().getScaledInstance(350, 500, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(450, 0, 350, 500);
        add(image1);

        JLabel title = new JLabel("Book Items");
        title.setBounds(150, 20, 200, 30);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(title);

        JLabel username1 = new JLabel("Username:");
        username1.setBounds(20, 70, 200, 30);
        username1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(username1);

        leusername = new JLabel();
        leusername.setBounds(160, 70, 200, 20);
        add(leusername);

        JLabel food = new JLabel("Food:");
        food.setBounds(20, 115, 200, 30);
        food.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(food);

        lefood = new JTextField("Null");
        lefood.setBounds(160, 120, 200, 20);
        add(lefood);

        JLabel Item = new JLabel("Item no. :");
        Item.setBounds(20, 160, 200, 30);
        Item.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(Item);

        leitem = new JTextField("1");
        leitem.setBounds(160, 165, 200, 20);
        add(leitem);

        JLabel drink = new JLabel("Cold Drink:");
        drink.setBounds(20, 205, 200, 30);
        drink.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(drink);

        ledrink = new JComboBox(new String[]{"Null", "Coca-Cola", "Pepsi", "Sprite"});
        ledrink.setBounds(160, 210, 200, 20);
        ledrink.setBackground(Color.WHITE);
        add(ledrink);

        JLabel address = new JLabel("Address:");
        address.setBounds(20, 250, 200, 30);
        address.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(address);

        leaddress = new JLabel();
        leaddress.setBounds(160, 255, 200, 20);
        add(leaddress);

        JLabel city = new JLabel("City:");
        city.setBounds(20, 295, 200, 30);
        city.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(city);

        lecity = new JTextField();
        lecity.setBounds(160, 300, 200, 20);
        add(lecity);

        JLabel state = new JLabel("State:");
        state.setBounds(20, 340, 100, 30);
        state.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(state);

        lestate = new JComboBox(new String[]{"Maharashtra ", "Tamil Nadu", "Uttar Pradesh"});
        lestate.setBounds(160, 345, 200, 20);
        lestate.setBackground(Color.WHITE);
        add(lestate);

        add = new JButton("Add Item");
        add.setBounds(60, 420, 100, 30);
        add.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add.setBackground(new Color(52, 58, 64));    
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(260, 420, 100, 30);
        back.setFont(new Font("Times New Roman", Font.BOLD, 16));
        back.setBackground(new Color(52, 58, 64));    
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where username = '"+username+"'");

            while (rs.next()) {
                leusername.setText(rs.getString("username"));
                leaddress.setText(rs.getString("address"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==add){
            String username = leusername.getText();
            String food = lefood.getText(); 
            String item = leitem.getText();
            String drink = (String) ledrink.getSelectedItem();
            String address = leaddress.getText();
            String city = lecity.getText();
            String state = (String) lestate.getSelectedItem();
            
             String query ="insert into additem values('"+username+"','"+food+"','"+item+"','"+drink+"','"+city+"','"+state+"','"+address+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Order Added Succsessfully");
                
                setVisible(false);
                new Dashbord(username);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()== back){
            setVisible(false);
            new Dashbord(username).setVisible(true);
        }
        
    }

    public static void main(String[] arg) {
        new Menu("");
    }
}
