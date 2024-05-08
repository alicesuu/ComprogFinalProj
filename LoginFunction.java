    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.util.HashMap;

    public class LoginFunction extends JPanel {
        private JTextField usernameField;
        private JPasswordField passwordField;
        private JButton loginButton;
    
        public LoginFunction(HashMap<String, String> adminCredentials, CardLayout cardLayout, Container contentPane) {
            setLayout(new GridLayout(3, 2));
            JLabel usernameLabel = new JLabel("Username:");
            JLabel passwordLabel = new JLabel("Password:");
            usernameField = new JTextField();
            passwordField = new JPasswordField();
            loginButton = new JButton("Login");
    
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = usernameField.getText();
                    String password = new String(passwordField.getPassword());
                    if (adminCredentials.containsKey(username) && adminCredentials.get(username).equals(password)) {
                        cardLayout.next(contentPane);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
    
            add(usernameLabel);
            add(usernameField);
            add(passwordLabel);
            add(passwordField);
            add(loginButton);
        }
    }
    

