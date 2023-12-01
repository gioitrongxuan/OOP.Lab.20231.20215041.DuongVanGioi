package hust.soict.hedspi.aims.screen.manager;
import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.media.Book;
public class AddBookToStoreScreen extends AddItemToStoreScreen {
	private static final long serialVersionUID = 1L;
    private JLabel authorsLabel;
    private JTextField authorsField;
    @Override
    public GridLayout getGridLayout() {
    	return new GridLayout(6, 2, 10, 10);
    }
    public AddBookToStoreScreen(StoreManagerScreen parentScreen) {
    	super(parentScreen);
    }
    @Override
    public void initComponents() {
    	super.initComponents();
        authorsLabel = new JLabel("Artist:");
        authorsField = new JTextField();
        getLabelTextFields().add(new LabelTextField(authorsLabel, authorsField));
    }
    @Override
    public JPanel createCenter() {
        JPanel center = super.createCenter();
        // ...
        center.add(new JLabel()); // Thêm một label trống để căn chỉnh giao diện
        center.add(getAddButton());
        return center;
    }
    // Xử Lý sự kiện
    @Override
    void addMediaToStore() {
    	parentScreen.getStore().addMedia(new Book(getIdField().getText(),getTitleField().getText(),getCategoryField().getText(),Float.parseFloat(getCostField().getText()),Book.convertAuthorsString(authorsField.getText())));
    	super.addMediaToStore();
    }
    
}