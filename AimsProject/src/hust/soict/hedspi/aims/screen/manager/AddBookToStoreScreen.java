package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Book;

public class AddBookToStoreScreen extends JFrame {
    private StoreManagerScreen parentScreen;
    public AddBookToStoreScreen(StoreManagerScreen parentScreen) {
        this.parentScreen = parentScreen;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createCenter(), BorderLayout.CENTER);

        
        setTitle("Add Book to Store");
        setSize(400, 200);
     // Tính toán kích thước mới dựa trên kích thước của parentScreen
        int parentWidth = parentScreen.getWidth();
        int parentHeight = parentScreen.getHeight();

        // Đặt kích thước mới (ví dụ: giảm 20% kích thước của parentScreen)
        int newWidth = (int) (parentWidth * 0.8);
        int newHeight = (int) (parentHeight * 0.8);

        setSize(newWidth, newHeight);

        // Tính toán tọa độ mới dựa trên kích thước mới
        int parentX = parentScreen.getX();
        int parentY = parentScreen.getY();
        int newX = parentX + (parentWidth - newWidth) / 2;
        int newY = parentY + (parentHeight - newHeight) / 2;

        setLocation(newX, newY);

        setVisible(true);
        
    }
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 10, 10));
        
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

        // ...
        center.add(titleLabel);
        center.add(titleField);
        center.add(idLabel);
        center.add(idField); 
        center.add(categoryLabel);
        center.add(categoryField);
        center.add(costLabel);
        center.add(costField);
        center.add(authorLabel);
        center.add(authorField);
        center.add(new JLabel()); // Thêm một label trống để căn chỉnh giao diện
        center.add(addButton);

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
                authorList.add(author);
                addBookToStore(id,title,category,cost, authorList);

                // Close the current window after adding the book
                // dispose();
            }
        });
        return center;
    }
    
 // Method to add a book to the store
    public void addBookToStore(String id,String title, String category, float cost,List<String> authors) {
        // Assuming you have a constructor for the Book class in your Media hierarchy
        Media book = new Book(id,title,category,cost, authors);

        // Assuming your store has a method to add items
        parentScreen.getStore().addMedia(book);

        // Refresh the center panel to display the updated store
        parentScreen.refreshCenterPanel();
    }
    
}

