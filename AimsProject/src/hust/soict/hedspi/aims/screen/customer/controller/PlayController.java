package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.exception.PlayerException;
import hust.soict.hedspi.aims.media.Disc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PlayController {
	private Disc disc;
	public PlayController(Disc disc) {
		this.disc = disc;
	}

    @FXML
    private Button btnPlay;

    @FXML
    private Label titleLabel;
    
    @FXML
    public void initialize() {
        titleLabel.setText(disc.getTitle());
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
    	
        if (btnPlay.getText().equals("Resume")) {
        	btnPlay.setText("Pause");
        } else {
        	btnPlay.setText("Resume");
        }
    	
    }

}
