import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class LibraryManagementGUI extends JFrame implements ActionListener {
    private final JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    private final JButton addButton, viewButton, editButton, deleteButton, clearButton, exitButton;
    private final ArrayList<String[]> books = new ArrayList<>();

    public LibraryManagementGUI() {
        setTitle("Library Management System");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JLabel label1 = new JLabel("Book ID");
        JLabel label2 = new JLabel("Book Title");
        JLabel label3 = new JLabel("Author");
        JLabel label4 = new JLabel("Publisher");
        JLabel label5 = new JLabel("Year of Publication");
        JLabel label6 = new JLabel("ISBN");
        JLabel label7 = new JLabel("Number of Copies");

        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();

        addButton = new JButton("Add");
        viewButton = new JButton("View");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        // Increase font size for buttons and labels
        Font buttonFont = new Font("Arial", Font.BOLD, 24);
        addButton.setFont(buttonFont);
        viewButton.setFont(buttonFont);
        editButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
        clearButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        // Increase font size for text fields
        Font textFieldFont = new Font("Arial", Font.PLAIN, 20);
        textField1.setFont(textFieldFont);
        textField2.setFont(textFieldFont);
        textField3.setFont(textFieldFont);
        textField4.setFont(textFieldFont);
        textField5.setFont(textFieldFont);
        textField6.setFont(textFieldFont);
        textField7.setFont(textFieldFont);

        Font lebalFont = new Font("Arial", Font.PLAIN, 20);
        label1.setFont(lebalFont);
        label2.setFont(lebalFont);
        label3.setFont(lebalFont);
        label4.setFont(lebalFont);
        label5.setFont(lebalFont);
        label6.setFont(lebalFont);
        label7.setFont(lebalFont);


        // Add background color to buttons
        addButton.setBackground(new Color(150,250,255));
        viewButton.setBackground(new Color(150,250,255));
        editButton.setBackground(new Color(150,250,255));
        deleteButton.setBackground(new Color(150,250,255));
        clearButton.setBackground(new Color(150,250,255));
        exitButton.setBackground(new Color(150,250,255));

        // Set foreground color for buttons
        addButton.setForeground(Color.RED);
        viewButton.setForeground(Color.RED);
        editButton.setForeground(Color.RED);
        deleteButton.setForeground(Color.RED);
        clearButton.setForeground(Color.RED);
        exitButton.setForeground(Color.RED);

        // Add action listeners
        addButton.addActionListener(this);
        viewButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        JPanel panel = new JPanel(new GridLayout(10, 2));
        panel.setBackground(new Color(150,250,255)); // Set panel background color

        // Add labels and text fields to the panel
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textField4);
        panel.add(label5);
        panel.add(textField5);
        panel.add(label6);
        panel.add(textField6);
        panel.add(label7);
        panel.add(textField7);

        // Add buttons to the panel
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            if (areFieldsEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String[] book = new String[7];
                book[0] = textField1.getText();
                book[1] = textField2.getText();
                book[2] = textField3.getText();
                book[3] = textField4.getText();
                book[4] = textField5.getText();
                book[5] = textField6.getText();
                book[6] = textField7.getText();
                books.add(book);
                JOptionPane.showMessageDialog(this, "Book added successfully");
                clearFields();
            }
        } else if (e.getSource() == viewButton) {
            String[] columns = {"Book ID", "Book Title", "Author", "Publisher", "Year of Publication", "ISBN", "Number of Copies"};
            Object[][] data = new Object[books.size()][7];
            for (int i = 0; i < books.size(); i++) {
                data[i][0] = books.get(i)[0];
                data[i][1] = books.get(i)[1];
                data[i][2] = books.get(i)[2];
                data[i][3] = books.get(i)[3];
                data[i][4] = books.get(i)[4];
                data[i][5] = books.get(i)[5];
                data[i][6] = books.get(i)[6];
            }
            JTable table = new JTable(data, columns);
            JScrollPane scrollPane = new JScrollPane(table);
            JFrame frame = new JFrame("View Books");
            frame.add(scrollPane);
            frame.setSize(800, 400);
            frame.setVisible(true);
        } else if (e.getSource() == editButton) {
            if (areFieldsEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String bookID = JOptionPane.showInputDialog(this, "Enter book ID to edit:");
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i)[0].equals(bookID)) {
                        String[] book = new String[7];
                        book[0] = bookID;
                        book[1] = textField2.getText();
                        book[2] = textField3.getText();
                        book[3] = textField4.getText();
                        book[4] = textField5.getText();
                        book[5] = textField6.getText();
                        book[6] = textField7.getText();
                        books.set(i, book);
                        JOptionPane.showMessageDialog(this, "Book edited successfully");
                        clearFields();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Book not found");
            }

        } else if (e.getSource() == deleteButton) {
            String bookID = JOptionPane.showInputDialog(this, "Enter book ID to delete:");
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i)[0].equals(bookID)) {
                    books.remove(i);
                    JOptionPane.showMessageDialog(this, "Book deleted successfully");
                    clearFields();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Book not found");
        } else if (e.getSource() == clearButton) {
            clearFields();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
    private boolean areFieldsEmpty() {
        return textField1.getText().isEmpty() ||
                textField2.getText().isEmpty() ||
                textField3.getText().isEmpty() ||
                textField4.getText().isEmpty() ||
                textField5.getText().isEmpty() ||
                textField6.getText().isEmpty() ||
                textField7.getText().isEmpty();
    }
    private void clearFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
    }
}
