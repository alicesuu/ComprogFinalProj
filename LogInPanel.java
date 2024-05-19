import javax.swing.*;
import java.awt.event.*;

public class LogInPanel {
    RegisterPanel registerPanel = new RegisterPanel();
    AdminPanel adminPanel = new AdminPanel(); 

    public void logIn() {
        JFrame lframe = new JFrame("Student Management System");

        JLabel llabel = new JLabel("Log In");
        llabel.setBounds(220, 75, 100, 100);

        // Username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(122, 113, 100, 100);

        JTextField userText = new JTextField();
        userText.setBounds(120, 175, 250, 30);

        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(122, 185, 100, 100);

        JPasswordField passText = new JPasswordField();
        passText.setBounds(120, 250, 250, 30);

        // Log In Button
        JButton lbutton = new JButton("Log In");
        lbutton.setBounds(200, 305, 75, 30);
        lbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String username = userText.getText();
                String password = new String(passText.getPassword());

                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(lframe, "The username is empty.");
                    return;
                }
                if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(lframe, "The password is empty.");
                    return;
                }
                if (registerPanel.checkLogin(username, password)) {
                    JOptionPane.showMessageDialog(lframe, "Login Successful");
                    adminPanel.adminPanel(); 
                    lframe.dispose(); 
                } else {
                    JOptionPane.showMessageDialog(lframe, "Invalid username or password");
                }
            }
        });

        // Register Section
        JLabel lregister = new JLabel("Don't have an account?");
        lregister.setBounds(125, 360, 200, 100);

        JButton lregisterbutton = new JButton("Register");
        lregisterbutton.setBounds(275, 398, 100, 20);
        lregisterbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerPanel.registerForm();
            }
        });

        // Frame Settings
        lframe.setSize(500, 500);
        lframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lframe.setLocationRelativeTo(null);
        lframe.setLayout(null);

        // Add components
        lframe.add(llabel);
        lframe.add(userLabel);
        lframe.add(userText);
        lframe.add(passLabel);
        lframe.add(passText);
        lframe.add(lbutton);
        lframe.add(lregister);
        lframe.add(lregisterbutton);

        lframe.setVisible(true);

        JButton adminButton = new JButton("Admin Panel");
        adminButton.setBounds(200, 350, 150, 30);
        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
}
