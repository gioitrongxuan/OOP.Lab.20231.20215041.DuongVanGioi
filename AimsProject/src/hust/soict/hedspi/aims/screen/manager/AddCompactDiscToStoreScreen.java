package hust.soict.hedspi.aims.screen.manager;
import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	private static final long serialVersionUID = 1L;
    private JLabel directorLabel;
    private JLabel lengthLabel;
    private JLabel artistLabel;
    private JTextField directorField;
    private JTextField lengthField;
    private JTextField artistField;
    @Override
    public GridLayout getGridLayout() {
    	return new GridLayout(8, 2, 10, 10);
    }
    public AddCompactDiscToStoreScreen(StoreManagerScreen parentScreen) {
    	super(parentScreen);
    }
    @Override
    public void initComponents() {
    	super.initComponents();
    	directorLabel =new JLabel("Director:");
        directorField = new JTextField();
        lengthLabel = new JLabel("Length: ");
        lengthField = new JTextField();
        artistLabel = new JLabel("Artist:");
        artistField = new JTextField();
        getLabelTextFields().add(new LabelTextField(directorLabel, directorField));
        getLabelTextFields().add(new LabelTextField(lengthLabel, lengthField));
        getLabelTextFields().add(new LabelTextField(artistLabel, artistField));
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
    	parentScreen.getStore().addMedia(new CompactDisc(getIdField().getText(),getTitleField().getText(),getCategoryField().getText(),directorField.getText(),Integer.parseInt(lengthField.getText()), Float.parseFloat(getCostField().getText()), artistField.getText()));
    	super.addMediaToStore();
    }
    
}

