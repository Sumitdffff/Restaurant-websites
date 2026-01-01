package restaurant.management.system;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

public class Payment extends JFrame {

    Payment() {
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        try {
            Desktop.getDesktop().browse(
                    new URI("https://paytm.com")
            );
        } catch (Exception e) {
            System.out.println(e);
            pane.setContentType("text/html");
            pane.setText("<html>could not load,error 404</html>");
        }
        JScrollPane sp = new JScrollPane();
        getContentPane().add(sp);
        setVisible(true);
    }

    public static void main(String[] arg) {
        new Payment();
    }
}
