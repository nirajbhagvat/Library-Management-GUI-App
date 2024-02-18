import javax.swing.*;
import java.awt.*;

public class LibraryManagementGUI extends JFrame {
    private final JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    protected final JButton addButton, viewButton, editButton, deleteButton, clearButton, exitButton;

    public LibraryManagementGUI() {
        setTitle("Library Management System");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel(new GridLayout(10, 2));
        panel.setBackground(new Color(245, 245, 4)); // Set panel background color

        // Initialize text fields
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();

        // Initialize buttons
        addButton = new JButton("Add");
        viewButton = new JButton("View");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        // Add labels and text fields to the panel
        panel.add(new JLabel("Book ID"));
        panel.add(textField1);
        panel.add(new JLabel("Book Title"));
        panel.add(textField2);
        panel.add(new JLabel("Author"));
        panel.add(textField3);
        panel.add(new JLabel("Publisher"));
        panel.add(textField4);
        panel.add(new JLabel("Year of Publication"));
        panel.add(textField5);
        panel.add(new JLabel("ISBN"));
        panel.add(textField6);
        panel.add(new JLabel("Number of Copies"));
        panel.add(textField7);

        // Add buttons to the panel
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(exitButton);

        // Add panel to the frame
        add(panel);

        // Create an instance of LibraryManagementActions to handle button actions
        LibraryManagementActions actionHandler = new LibraryManagementActions(this);

        // Add action listeners to buttons
        addButton.addActionListener(actionHandler);
        viewButton.addActionListener(actionHandler);
        editButton.addActionListener(actionHandler);
        deleteButton.addActionListener(actionHandler);
        clearButton.addActionListener(actionHandler);
        exitButton.addActionListener(actionHandler);

        setVisible(true);
    }

    // Getters for text fields
    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public JTextField getTextField4() {
        return textField4;
    }

    public JTextField getTextField5() {
        return textField5;
    }

    public JTextField getTextField6() {
        return textField6;
    }

    public JTextField getTextField7() {
        return textField7;
    }
}
