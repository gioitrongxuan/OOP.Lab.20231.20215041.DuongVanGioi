package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;
	private JButton btnPlay,btnAddToCart;
	public MediaStore(Media media,final JFrame frame) {
		ActionListener btnListener = new ButtonListener(frame);
		this.media = media;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
//		btnAddToCart = new JButton("Add to cart");
//		container.add(btnAddToCart);
//		btnAddToCart.addActionListener(btnListener);
				
		if(media instanceof Playable) {
			btnPlay = new JButton("Play");
			container.add(btnPlay);
			btnPlay.addActionListener(btnListener);
		}
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));	
	}
	private class ButtonListener implements ActionListener{
		private JFrame frame;
		public ButtonListener(JFrame frame) {
			super();
			this.frame = frame;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			
			
			// Play
			if (button.equals("Play")) {
				// Hiển thị JDialog khi nút "Play" được nhấn
                playMediaDialog mediaDialog = new playMediaDialog(frame, "Media Player", true);
//                mediaDialog.setSize(150,100);
                // chỉnh kích thước tương đối
                mediaDialog.setSizeRelativeToParent(0.5, 0.5);
                //chỉnh vị trí tương đối 
                mediaDialog.setLocationRelativeToParent(0.5, 0.5);
                mediaDialog.setVisible(true);
			}
			
			// Add to cart
			if(button.equals("Add to cart")) {
				JOptionPane.showMessageDialog(null, "Added Media" +media.getTitle() +" to Cart!");
				CartScreen.getCart().addMedia(media);
			}
		}
	}
	
	
	class playMediaDialog extends JDialog {
	    public playMediaDialog(JFrame parent, String title, boolean modal) {
	        super(parent, title, modal);
	        setLocationRelativeTo(parent); // Hiển thị dialog ở giữa cửa sổ chính

	        ((Playable)media).play();
	        JLabel label = new JLabel(media.getTitle() +"is playing!");
	        label.setHorizontalAlignment(JLabel.CENTER);
	        JButton closeButton = new JButton("Close");
	        closeButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dispose(); // Đóng dialog khi nút "Close" được nhấn
	            }
	        });

	        JPanel panel = new JPanel(new BorderLayout());
	        panel.add(label, BorderLayout.CENTER);
	        panel.add(closeButton, BorderLayout.SOUTH);

	        getContentPane().add(panel);
	        pack();
	    }
	    
	    
	    // Phương thức để đặt kích thước tương đối so với cửa sổ chính
	    public void setSizeRelativeToParent(double widthRatio, double heightRatio) {
	        int parentWidth = getParent().getWidth();
	        int parentHeight = getParent().getHeight();

	        int dialogWidth = (int) (parentWidth * widthRatio);
	        int dialogHeight = (int) (parentHeight * heightRatio);

	        setSize(dialogWidth, dialogHeight);
	    }
	    
	    
	    
	    // Phương thức để đặt vị trí tương đối so với cửa sổ chính
	    public void setLocationRelativeToParent(double xRatio, double yRatio) {
	        int parentX = getParent().getX();
	        int parentY = getParent().getY();
	        int parentWidth = getParent().getWidth();
	        int parentHeight = getParent().getHeight();

	        int dialogWidth = getWidth();
	        int dialogHeight = getHeight();

	        int x = parentX + (int) ((parentWidth - dialogWidth) * xRatio);
	        int y = parentY + (int) ((parentHeight - dialogHeight) * yRatio);

	        setLocation(x, y);
	    }
	}
}


