import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class RegisterPanel {
   
    private Map<String, String> userDatabase = new HashMap<>();
   

    public void registerForm() {
        JFrame rframe = new JFrame("Register");

        // Username
        JLabel rUsernameLabel = new JLabel("Username:");
        rUsernameLabel.setBounds(55, 55, 100, 30);

        JTextField rUsernameField = new JTextField();
        rUsernameField.setBounds(55, 85, 225, 25);

        // Password
        JLabel rPasswordLabel = new JLabel("Password:");
        rPasswordLabel.setBounds(55, 120, 100, 30);

        JPasswordField rPasswordField = new JPasswordField();
        rPasswordField.setBounds(55, 150, 225, 25);

        JButton doneButton = new JButton("Done");
        doneButton.setBounds(55, 200, 100, 30);
        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = rUsernameField.getText();
                String password = new String(rPasswordField.getPassword());

                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(rframe, "The username is empty.");
                    return;
                }

                if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(rframe, "The password is empty.");
                    return;
                }

                if (userDatabase.containsKey(username)) {
                    JOptionPane.showMessageDialog(rframe, "Username already exists.");
                    return;
                }

                if (isValidPassword(password)) {
                    userDatabase.put(username, password);
                    JOptionPane.showMessageDialog(rframe, "Registration Successful");
                    rframe.dispose();
                } else {
                    JOptionPane.showMessageDialog(rframe, "Password must contain at least one letter and one number, and be 8 characters or longer.");
                }
            }
        });

        // Frame Settings
        rframe.setSize(350, 500);
        rframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        rframe.setLocationRelativeTo(null);
        rframe.setLayout(null);

        // Add components
        rframe.add(rUsernameLabel);
        rframe.add(rPasswordLabel);
        rframe.add(rUsernameField);
        rframe.add(rPasswordField);
        rframe.add(doneButton);

        rframe.setVisible(true);
    }

    public boolean checkLogin(String username, String password) {
        return password.equals(userDatabase.get(username));
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d).{8,}$");
    }
}
