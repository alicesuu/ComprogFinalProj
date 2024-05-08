import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class FinalProjMain {
    private JFrame frame;
    private CardLayout cardLayout;
    private Container contentPane;
    private HashMap<String, String> adminCredentials;

    public FinalProjMain() {
        frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        cardLayout = new CardLayout();
        contentPane = frame.getContentPane();
        contentPane.setLayout(cardLayout);

        adminCredentials = new HashMap<>();

        LoginFunction loginPanel = new LoginFunction(adminCredentials, cardLayout, contentPane);
        contentPane.add(loginPanel, "login");

        RegisterFunction registrationPanel = new RegisterFunction(adminCredentials);
        contentPane.add(registrationPanel, "register");

        cardLayout.show(contentPane, "login");

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FinalProjMain();
    }
}
