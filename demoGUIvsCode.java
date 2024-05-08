import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class StudentManagementSystem extends JFrame {

    private JTextField loginNameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel loginPanel;
    private JPanel adminPanel;
    private JButton addStudentButton;
    private JButton deleteStudentButton;
    private JButton changeStudentInfoButton;

    private HashMap<String, String> adminCredentials;
    private HashMap<String, String> studentDetails;

    public StudentManagementSystem() {
        setTitle("Student Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        adminCredentials = new HashMap<>();
        studentDetails = new HashMap<>();

        loginPanel = new JPanel();
        loginNameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loginName = loginNameField.getText().trim();
                String password = new String(passwordField.getPassword());

                if (loginName.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both login name and password");
                } else if (adminCredentials.containsKey(loginName) && adminCredentials.get(loginName).equals(password)) {
                    showAdminPanel();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login credentials");
                }
            }
        });

        loginPanel.add(new JLabel("Login Name:"));
        loginPanel.add(loginNameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        adminPanel = new JPanel();
        addStudentButton = new JButton("Add Student");
        deleteStudentButton = new JButton("Delete Student");
        changeStudentInfoButton = new JButton("Change Student Info");

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        deleteStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });

        changeStudentInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        adminPanel.add(addStudentButton);
        adminPanel.add(deleteStudentButton);
        adminPanel.add(changeStudentInfoButton);

        add(loginPanel);
    }

    private void showAdminPanel() {
        getContentPane().removeAll();
        add(adminPanel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentManagementSystem().setVisible(true);
            }
        });
    }
}
