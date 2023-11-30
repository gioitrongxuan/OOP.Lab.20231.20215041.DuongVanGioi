package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;

public class AddBookToStoreScreen extends JFrame {
    private StoreManagerScreen parentScreen;

        

//        // Method to refresh the center panel with the updated store items
//        private void refreshCenterPanel() {
//            getContentPane().removeAll(); // Remove existing components
//            getContentPane().add(createNorth(), BorderLayout.NORTH);
//            getContentPane().add(createCenter(), BorderLayout.CENTER);
//            revalidate(); // Revalidate the container
//            repaint();    // Repaint the container
//        }
//        
        // ... existing code ...

    public AddBookToStoreScreen(StoreManagerScreen parentScreen) {
        this.parentScreen = parentScreen;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Add Book to Store");
        setSize(400, 200);
    }
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2, 2, 5, 5));
        
        JLabel idLabel = new JLabel("Id :");
        JTextField idField = new JTextField();

        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();
        
        JLabel categoryLabel = new JLabel("Category :");
        JTextField categoryField = new JTextField();
        
        JLabel costLabel = new JLabel("Cost: ");
        JTextField costField = new JTextField();

        JLabel authorLabel = new JLabel("Author:");
        JTextField authorField = new JTextField();
        
        JButton addButton = new JButton("Add Book");
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the entered information and add the book to the store
            	String id = idField.getText();
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                String author = authorField.getText();
                List<String> authorList = new ArrayList<String>();
                // Assuming you have a method in your StoreManagerScreen to add a book
                parentScreen.addBookToStore(id,title,category,cost, authorList);

                // Close the current window after adding the book
                dispose();
            }
        });

        center.add(titleLabel);
        center.add(titleField);
        center.add(authorLabel);
        center.add(authorField);
        center.add(addButton);

        return center;
    }
}

