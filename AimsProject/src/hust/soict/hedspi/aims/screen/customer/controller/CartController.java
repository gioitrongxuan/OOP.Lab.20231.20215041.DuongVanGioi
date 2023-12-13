package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	private Cart cart;
	private Store store;
	private FilteredList<Media> listItems ;
    public CartController(Cart cart, Store store) {
		super();
		this.cart = cart;
		this.store = store;
		this.listItems = new FilteredList<Media>(cart.getItemsOrdered());
	}
    
    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
			final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
			fxmlLoader.setController(new ViewStoreController(store, cart));
			Parent root = fxmlLoader.load();
			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
			
			stage.setScene(new Scene(root));
			stage.setTitle("Store");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    public void initialize() {
    	colMediaId.setCellValueFactory(new PropertyValueFactory<Media, String>("id"));
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	if(cart.getItemsOrdered() != null ) tblMedia.setItems(listItems);
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
    		@Override
    		public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    			System.out.println(newValue.getTitle());
    			updateButtonBar(newValue);
    			
    		}
		});
    	
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			showFilteredMedia(newValue);
    		}
		});
    	
    	filterCategory.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
    		@Override
    		public void changed(ObservableValue<? extends Toggle> arg0, Toggle arg1, Toggle arg2) {
    			showFilteredMedia(tfFilter.getText());
    		}
		});
    	costLabel.setText(cart.totalCost()+"$");
    }
    void updateButtonBar(Media media) {
    	if(media == null ) {
    		btnPlay.setVisible(false);
    		btnRemove.setVisible(false);
    		
    	}else {
    		btnRemove.setVisible(true);
    		if(media instanceof Playable) {
    			btnPlay.setVisible(true);
    			
    		}else {
				btnPlay.setVisible(false);
			}
    	}
    }
    void showFilteredMedia(String filter) {
    	RadioButton selectedButton =(RadioButton)filterCategory.getSelectedToggle();
    	if(selectedButton == radioBtnFilterId) {
    		listItems.setPredicate(item ->item.getId().contains(filter));
    	}
    	if(selectedButton == radioBtnFilterTitle) {
    		listItems.setPredicate(item ->item.getTitle().contains(filter));
    	}
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	try {
			final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Playing.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
			Media media = tblMedia.getSelectionModel().getSelectedItem();
			fxmlLoader.setController(new PlayController((Disc)media));//
			Parent root = fxmlLoader.load();
			Stage stage = new Stage();
			
			stage.setScene(new Scene(root));
			stage.setTitle("Play Disc");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	costLabel.setText(cart.totalCost()+"$");
    }
    @FXML
    void btnPlaceOrderPressed() {
    	try {
			final String PLACEORDER_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/PlaceOrder.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PLACEORDER_FXML_FILE_PATH));
			fxmlLoader.setController(new PlaceOrderController(cart));//
			Parent root = fxmlLoader.load();
			Stage stage = new Stage();
			
			stage.setScene(new Scene(root));
			stage.setTitle("Play Disc");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	@FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;
    
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private TextField tfFilter;

    @FXML
    private TableView<Media> tblMedia;




}
