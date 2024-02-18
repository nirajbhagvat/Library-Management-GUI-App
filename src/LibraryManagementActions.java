import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LibraryManagementActions implements ActionListener {
    private final LibraryManagementGUI gui;
    private final ArrayList<String[]> books = new ArrayList<>();

    public LibraryManagementActions(LibraryManagementGUI gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.addButton) {
            if (areFieldsEmpty()) {
                JOptionPane.showMessageDialog(gui, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String[] book = new String[7];
                book[0] = gui.getTextField1().getText();
                book[1] = gui.getTextField2().getText();
                book[2] = gui.getTextField3().getText();
                book[3] = gui.getTextField4().getText();
                book[4] = gui.getTextField5().getText();
                book[5] = gui.getTextField6().getText();
                book[6] = gui.getTextField7().getText();
                books.add(book);
                JOptionPane.showMessageDialog(gui, "Book added successfully");
                clearFields();
            }
        } else if (e.getSource() == gui.viewButton) {
            // Handle viewButton action
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

        } else if (e.getSource() == gui.editButton) {
            // Handle editButton action
            if (areFieldsEmpty()) {
                JOptionPane.showMessageDialog(gui, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String bookID = JOptionPane.showInputDialog(this, "Enter book ID to edit:");
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i)[0].equals(bookID)) {
                        String[] book = new String[7];
                        book[0] = bookID;
                        book[1] = gui.getTextField2().getText();
                        book[2] = gui.getTextField3().getText();
                        book[3] = gui.getTextField4().getText();
                        book[4] = gui.getTextField5().getText();
                        book[5] = gui.getTextField6().getText();
                        book[6] = gui.getTextField7().getText();
                        books.set(i, book);
                        JOptionPane.showMessageDialog(gui, "Book edited successfully");
                        clearFields();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(gui, "Book not found");
            }

        } else if (e.getSource() == gui.deleteButton) {
            // Handle deleteButton action
            String bookID = JOptionPane.showInputDialog(gui, "Enter book ID to delete:","");
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i)[0].equals(bookID)) {
                    books.remove(i);
                    JOptionPane.showMessageDialog(gui, "Book deleted successfully");
                    clearFields();
                    return;
                } else if (i==(books.size()-1))
                    JOptionPane.showMessageDialog(gui, "Book not found");
            }
        } else if (e.getSource() == gui.clearButton) {
            clearFields();
        } else if (e.getSource() == gui.exitButton) {
            System.exit(0);
        }
    }

    private boolean areFieldsEmpty() {
        return gui.getTextField1().getText().isEmpty() ||
                gui.getTextField2().getText().isEmpty() ||
                gui.getTextField3().getText().isEmpty() ||
                gui.getTextField4().getText().isEmpty() ||
                gui.getTextField5().getText().isEmpty() ||
                gui.getTextField6().getText().isEmpty() ||
                gui.getTextField7().getText().isEmpty();
    }

    private void clearFields() {
        gui.getTextField1().setText("");
        gui.getTextField2().setText("");
        gui.getTextField3().setText("");
        gui.getTextField4().setText("");
        gui.getTextField5().setText("");
        gui.getTextField6().setText("");
        gui.getTextField7().setText("");
    }
}
