import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class AdminPanel {
    private Map<String, Student> studentDatabase = new HashMap<>();
   


    public void adminPanel() {
        JFrame adminFrame = new JFrame("Admin Panel");
        adminFrame.setSize(600, 600);
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setLayout(null);

        JLabel label = new JLabel("Admin Panel: Manage Student Information");
        label.setBounds(150, 20, 300, 30);
        adminFrame.add(label);

        JButton addButton = new JButton("Add Student");
        addButton.setBounds(50, 70, 150, 30);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
        adminFrame.add(addButton);

        JButton deleteButton = new JButton("Delete Student");
        deleteButton.setBounds(220, 70, 150, 30);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });
        adminFrame.add(deleteButton);

        JButton editButton = new JButton("Edit Student");
        editButton.setBounds(390, 70, 150, 30);
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editStudent();
            }
        });
        adminFrame.add(editButton);

        adminFrame.setLocationRelativeTo(null);
        adminFrame.setVisible(true);
    }

    private void addStudent() {
        JFrame addFrame = new JFrame("Add Student");
        addFrame.setSize(400, 400);
        addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addFrame.setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 50, 100, 30);
        addFrame.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(150, 50, 200, 30);
        addFrame.add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 100, 100, 30);
        addFrame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 100, 200, 30);
        addFrame.add(nameField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 150, 100, 30);
        addFrame.add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setBounds(150, 150, 200, 30);
        addFrame.add(ageField);

        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(50, 200, 100, 30);
        addFrame.add(courseLabel);

        JTextField courseField = new JTextField();
        courseField.setBounds(150, 200, 200, 30);
        addFrame.add(courseField);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(150, 250, 100, 30);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String course = courseField.getText();

                if (studentDatabase.containsKey(id)) {
                    JOptionPane.showMessageDialog(addFrame, "Student with this ID already exists.");
                    return;
                }

                Student student = new Student(id, name, age, course);
                studentDatabase.put(id, student);
                JOptionPane.showMessageDialog(addFrame, "Student added successfully.");
                addFrame.dispose();
            }
        });
        addFrame.add(saveButton);

        addFrame.setLocationRelativeTo(null);
        addFrame.setVisible(true);
    }

    private void deleteStudent() {
        JFrame deleteFrame = new JFrame("Delete Student");
        deleteFrame.setSize(400, 200);
        deleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteFrame.setLayout(null);

        JLabel idLabel = new JLabel("Enter Student ID to delete:");
        idLabel.setBounds(50, 50, 200, 30);
        deleteFrame.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(250, 50, 100, 30);
        deleteFrame.add(idField);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(150, 100, 100, 30);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();

                if (!studentDatabase.containsKey(id)) {
                    JOptionPane.showMessageDialog(deleteFrame, "Student not found.");
                    return;
                }

                studentDatabase.remove(id);
                JOptionPane.showMessageDialog(deleteFrame, "Student deleted successfully.");
                deleteFrame.dispose();
            }
        });
        deleteFrame.add(deleteButton);

        deleteFrame.setLocationRelativeTo(null);
        deleteFrame.setVisible(true);
    }

    private void editStudent() {
        JFrame editFrame = new JFrame("Edit Student");
        editFrame.setSize(400, 400);
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editFrame.setLayout(null);

        JLabel idLabel = new JLabel("Enter Student ID to edit:");
        idLabel.setBounds(50, 50, 200, 30);
        editFrame.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(250, 50, 100, 30);
        editFrame.add(idField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(150, 100, 100, 30);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();

                if (!studentDatabase.containsKey(id)) {
                    JOptionPane.showMessageDialog(editFrame, "Student not found.");
                    return;
                }

                Student student = studentDatabase.get(id);

                JTextField nameField = new JTextField(student.getName());
                nameField.setBounds(150, 150, 200, 30);
                editFrame.add(nameField);

                JTextField ageField = new JTextField(String.valueOf(student.getAge()));
                ageField.setBounds(150, 200, 200, 30);
                editFrame.add(ageField);

                JTextField courseField = new JTextField(student.getCourse());
                courseField.setBounds(150, 250, 200, 30);
                editFrame.add(courseField);

                JButton saveButton = new JButton("Save");
                saveButton.setBounds(150, 300, 100, 30);
                saveButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        student.setName(nameField.getText());
                        student.setAge(Integer.parseInt(ageField.getText()));
                        student.setCourse(courseField.getText());
                        JOptionPane.showMessageDialog(editFrame, "Student updated successfully.");
                        editFrame.dispose();
                    }
                });
                editFrame.add(saveButton);

                editFrame.revalidate();
                editFrame.repaint();
            }
        });
        editFrame.add(searchButton);

        editFrame.setLocationRelativeTo(null);
        editFrame.setVisible(true);
    }
}
