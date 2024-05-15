import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RegisterPanel {

   public void RegisterForm() {
      JFrame rframe = new JFrame();
      
      //Username
      JLabel rUserLabel = new JLabel("Username:");
      rUserLabel.setBounds(50,70,100,100);
      
      JTextField rUserText = new JTextField();
      rUserText.setBounds(50,127,250,30);
      
      //Password
      JLabel rPasswordLabel = new JLabel("Password:");
      rPasswordLabel.setBounds(50,125,100,100);
      
      JTextField rPasswordText = new JTextField();
      rPasswordText.setBounds(50,100,100,30);
      
      
      
      //Settings
      rframe.setVisible(true);
      rframe.setTitle("Register");
      rframe.setSize(350,525);
      rframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      rframe.setLocationRelativeTo(null);
      
      //
      rframe.add(rUserLabel);
      rframe.add(rUserText);
      rframe.add(rPasswordLabel);
      rframe.add(rPasswordText);
   }
}