package hust.soict.hedspi.aims.screen.manager;
import javax.swing.*;
import hust.soict.hedspi.aims.media.Book;
public class AddBookToStoreScreen extends AddItemToStoreScreen {
	private static final long serialVersionUID = 1L;
    private JLabel authorsLabel;
    private JTextField authorsField;
    public AddBookToStoreScreen(StoreManagerScreen parentScreen) {
    	super(parentScreen);
    }
    @Override
    public void initComponents() {
    	super.initComponents();
        authorsLabel = new JLabel("Authors:");
        authorsField = new JTextField();
        getLabelTextFields().add(new LabelTextField(authorsLabel, authorsField));
 
    }
    @Override // Xử Lý sự kiện
    void addMediaToStore() {
    	parentScreen.getStore().addMedia(new Book(getIdField().getText(),getTitleField().getText(),getCategoryField().getText(),Float.parseFloat(getCostField().getText()),Book.convertAuthorsString(authorsField.getText())));
    	parentScreen.getStore().print();
    	super.addMediaToStore();
    }
    
}