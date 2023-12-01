package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Store store;
	public Store getStore() {
		return store;
	}
	public StoreManagerScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024,768);
	}
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem btnAddBook = new JMenuItem("Add Book");
		JMenuItem btnAddCD = new JMenuItem("Add CD");
		JMenuItem btnAddDVD = new JMenuItem("Add DVD");
		JMenuItem btnRemove = new JMenuItem("Remove");
		smUpdateStore.add(btnAddBook);
		smUpdateStore.add(btnAddCD);
		smUpdateStore.add(btnAddDVD);
		smUpdateStore.add(btnRemove);
		
		
		// Xử lý add book
		btnAddBook.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        AddBookToStoreScreen addBookScreen = new AddBookToStoreScreen(StoreManagerScreen.this);
		        addBookScreen.setVisible(true);
		    }
		});
		
		// Xử lý add DVD
		btnAddDVD.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        AddDigitalVideoDiscToStoreScreen addDVDScreen = new AddDigitalVideoDiscToStoreScreen(StoreManagerScreen.this);
		        addDVDScreen.setVisible(true);
		    }
		});
		
		// Xử lý add CD
		btnAddCD.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        AddCompactDiscToStoreScreen addCDScreen = new AddCompactDiscToStoreScreen(StoreManagerScreen.this);
		        addCDScreen.setVisible(true);
		    }
		});
	
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("View cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100,50));
		cart.setMaximumSize(new Dimension(100,50));
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		
		List<Media> mediaInStore = store.getItemsInStore();
		int quantity = mediaInStore.size();
		for(int i = quantity -1 ; i > quantity -10 ; i--) {
			MediaStore cell = new MediaStore(mediaInStore.get(i),this);
			center.add(cell);
		}
		return center;
	}
	
//	
//	
//	
//	
//	
	// Method to refresh the center panel with the updated store items
    public void refreshCenterPanel() {
        // Remove existing components
        getContentPane().removeAll();
        // Add components again
        getContentPane().add(createNorth(), BorderLayout.NORTH);
        getContentPane().add(createCenter(), BorderLayout.CENTER);
        revalidate(); // Revalidate the container
        repaint();    // Repaint the container
    }

}
