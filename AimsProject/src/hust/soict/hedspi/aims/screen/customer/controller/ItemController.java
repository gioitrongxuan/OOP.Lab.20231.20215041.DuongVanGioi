package hust.soict.hedspi.aims.screen.customer.controller;


import java.io.IOException;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ItemController {
	
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;
    @FXML
    void btnAddToCartClicked(ActionEvent event) throws LimitExceededException {
    	cart.addMedia(this.media);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
    	try {
			final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Playing.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
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
    
    private Media media;
    private Cart cart;
    public ItemController(Cart cart) {
    	this.cart = cart;
	}
    public void setData(Media media) {
    	this.media = media;
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(media.getCost()+"$");
    	if(media instanceof Playable) {
    		btnPlay.setVisible(true);
    		
    	}else {
			btnPlay.setVisible(false);
			HBox.setMargin(btnAddToCart, new Insets(0,0,0,120));
		}
    }
}