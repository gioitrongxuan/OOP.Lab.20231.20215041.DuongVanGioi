package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public abstract class AddItemToStoreScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected StoreManagerScreen parentScreen;
	private List<LabelTextField> labelTextFields =new ArrayList<LabelTextField>();
	private JLabel idLabel;
	private JLabel titleLabel;
	private JLabel categoryLabel;
	private JLabel costLabel;
	private JTextField idField;
	private JTextField titleField;
	private JTextField categoryField;
	private JTextField costField;
	private JButton addButton;

    public AddItemToStoreScreen(StoreManagerScreen parentScreen) {
        this.parentScreen = parentScreen;
        // Phương thức để khởi tạo các thành phần giao diện
        initComponents();
        // Khởi tạo giao diện và các thành phần chung
        setupUI();
        // Xử lý sự kiện
        evenHandler();
    }
    
    // Phương thức để khởi tạo các thành phần giao diện
    public void initComponents() {
    	idLabel = new JLabel("Id :");
        idField = new JTextField();
        titleLabel = new JLabel("Title:");
        titleField = new JTextField();
        categoryLabel = new JLabel("Category :");    
        categoryField = new JTextField();
        costLabel = new JLabel("Cost: ");
        costField = new JTextField();
        addButton = new JButton("Add");
        addButton.setEnabled(false);
        labelTextFields.add(new LabelTextField(idLabel, idField));
        labelTextFields.add(new LabelTextField(titleLabel, titleField));
        labelTextFields.add(new LabelTextField(categoryLabel, categoryField));
        labelTextFields.add(new LabelTextField(costLabel, costField));
    };
    
    // Phương thức để cài đặt giao diện chung
    public void setupUI() {
		Container cp = getContentPane();
    	cp.setLayout(new BorderLayout());
    	cp.add(createCenter(), BorderLayout.CENTER);
    	
    	setTitle("Add to Store");
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
		};
		
		public GridLayout getGridLayout(int size) {
			return new GridLayout(size+1,2,10,10);
		};
			
		// Phương thức để khởi tạo các thành phần giao diện
    	public JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(getGridLayout(labelTextFields.size()));
        for(int i = 0; i < labelTextFields.size(); i++) {
        	center.add(labelTextFields.get(i).label);
        	center.add(labelTextFields.get(i).textField);
        }
        center.add(new JLabel()); // Thêm một label trống để căn chỉnh giao diện
        center.add(addButton);
		return center;
    	}
    	public void setMyFont() {
    		 Font textFieldFont = new Font("Tahoma", Font.PLAIN, 25);
    		 Font labelFont = new Font("Tahoma", Font.BOLD, 30);
    		 for (LabelTextField labelTextField : labelTextFields) {
    			 labelTextField.label.setFont(labelFont);
    			 labelTextField.textField.setFont(textFieldFont);
			}

		}
    // Xử lý sự kiện
    	public void evenHandler() {
		textFieldDocumentListener(labelTextFields);
		setMyFont();
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addMediaToStore();
			}
		});
		
	};
    
	static void resetTextField(List<LabelTextField> labelTextFields) {
        for (LabelTextField labelTextField : labelTextFields) {
        	labelTextField.textField.setText("");
        }
    }
	 private void textFieldDocumentListener(List<LabelTextField> labelTextFields) {
		 for (LabelTextField  labelTextField: labelTextFields) {
	        	labelTextField.textField.getDocument().addDocumentListener(new  MyDocumentListener(addButton,labelTextFields));
	        }
	 }
	 
	 private class MyDocumentListener implements DocumentListener {
	        private JButton button;
	        private List<LabelTextField> labelTextFields;

	        public MyDocumentListener(JButton addButton, List<LabelTextField> labelTextFields) {
	            this.button = addButton;
	            this.labelTextFields = labelTextFields;
	        }

	        @Override
	        public void insertUpdate(DocumentEvent e) {
	            updateButtonState();
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            updateButtonState();
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {
	            updateButtonState();
	        }

	        private void updateButtonState() {
	            // Check conditions and enable/disable the button accordingly
	            boolean condition = true; // Example condition
	            for (LabelTextField labelTextField : labelTextFields) {
	                condition = condition && !labelTextField.textField.getText().trim().isEmpty();
	            }
	            button.setEnabled(condition);
	        }
	 }
	 void addMediaToStore(){
		 resetTextField(labelTextFields);		//reset textfields
		 parentScreen.refreshCenterPanel();		// refresh media in store 
		 getAddButton().setEnabled(false);		// disable play button
	 }
	 
	 class LabelTextField {
		 JLabel label;
		 JTextField textField;
		public LabelTextField(JLabel label, JTextField textField) {
			this.label = label;
			this.textField = textField;
		}

	}
	public List<LabelTextField> getLabelTextFields() {
		return labelTextFields;
	}
	 public JLabel getIdLabel() {
			return idLabel;
		}

		public JLabel getTitleLabel() {
			return titleLabel;
		}

		public JLabel getCategoryLabel() {
			return categoryLabel;
		}

		public JLabel getCostLabel() {
			return costLabel;
		}

		public JTextField getIdField() {
			return idField;
		}

		public JTextField getTitleField() {
			return titleField;
		}

		public JTextField getCategoryField() {
			return categoryField;
		}

		public JTextField getCostField() {
			return costField;
		}

		public JButton getAddButton() {
			return addButton;
		}
	
	 
}






