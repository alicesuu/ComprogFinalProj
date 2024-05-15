import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LogInPanel {
  
  public void LogIn() {
      JFrame lframe = new JFrame();
      
      JLabel llabel = new JLabel("Log In");
      llabel.setBounds(220,75,100,100);
      
      //Username
      JLabel userLabel = new JLabel("Username:");
      userLabel.setBounds(122,118,100,100);
      
      JTextField userText = new JTextField();
      userText.setBounds(120,175,100,100);
      userText.setSize(250,30);
      
      //Password
      JLabel passLabel = new JLabel("Password:");
      passLabel.setBounds(122,195,100,100);
      
      JTextField passText = new JTextField();
      passText.setBounds(120,250,100,100);
      passText.setSize(250,30);
      
      //Button
      JButton lbutton = new JButton("Log In");
      lbutton.setBounds(200,300,75,30);
      
      lbutton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(userText.getText().isEmpty()) {
               JOptionPane.showMessageDialog(null, "Empty Username");
            }
            
            if(passText.getText().isEmpty()) {
               JOptionPane.showMessageDialog(null, "Empty Password");
            }
         }
      });
      
      //Register
      JLabel lregister = new JLabel("Don't have an account?");
      lregister.setBounds(125,360,200,100);
      
      JButton lregisterbutton = new JButton("Register");
      lregisterbutton.setBounds(275,398,75,30);
      
      lregisterbutton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            RegisterPanel registerPanel = new RegisterPanel();
            registerPanel.RegisterForm();
         }
      });
      
      
      //Settings
      lframe.setVisible(true);
      lframe.setTitle("Student Management System");
      lframe.setSize(500,500);
      lframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      lframe.setLocationRelativeTo(null);
      
      //-------------------//
      lframe.add(llabel);
      lframe.add(userLabel);
      lframe.add(userText);
      lframe.add(passLabel);
      lframe.add(passText);
      lframe.add(lbutton);
      lframe.add(lregister);
      lframe.add(lregisterbutton);
      lframe.setLayout(null);
   }
}
