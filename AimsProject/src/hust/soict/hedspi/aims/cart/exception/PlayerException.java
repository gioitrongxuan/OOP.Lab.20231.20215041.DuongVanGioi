package hust.soict.hedspi.aims.cart.exception;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.StageStyle;
public class PlayerException extends Exception{
	public PlayerException(String message) {
        super(message);
    }
    public void show(String errorMessage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Lỗi Phát Media");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.initStyle(StageStyle.UTILITY);
        alert.getButtonTypes().add(ButtonType.OK);
        alert.showAndWait();
    }
}
