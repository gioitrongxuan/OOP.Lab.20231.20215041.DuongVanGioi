package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlaceOrderController {
	private Cart cart;
	public PlaceOrderController(Cart cart) {
		this.cart = cart;
	}
    @FXML
    private ToggleGroup btnPaymentMethod;

    @FXML
    private TextField myTextField;

    @FXML
    private TextField tfAddress;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPhone;
    
    @FXML
    private Text textDiscount;

    @FXML
    private Text textPayment;

    @FXML
    private Text textTotal;

    @FXML
    private Text textTransport;
    @FXML
    void submitOrder(ActionEvent event) {
    	cart.reset();
    	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    	stage.close();
    }
    @FXML
    void initialize() {

    	float payment = cart.totalCost();
    	float discount = (float)(payment*0.1);
    	float transport = (float)2.5;
    	float total = payment+transport-discount;

    	textDiscount.setText(discount+"$");
    	textPayment.setText(payment+"$");
    	textTransport.setText(transport+"$");
    	textTotal.setText(total+"$");
    }

}
