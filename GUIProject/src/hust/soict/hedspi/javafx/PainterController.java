package hust.soict.hedspi.javafx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	private Color color;
    @FXML
    private Pane drawingAreaPane;
    @FXML RadioButton eraser;
	@FXML RadioButton pen;
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	// implement clearing of canvas here
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	// implement drawing here
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
    	drawingAreaPane.getChildren().add(newCircle);
    }
    @FXML
    public void setPen() {
    	eraser.setSelected(false);
		this.color = Color.BLACK;
	}
    @FXML
    public void setEraser() {
    	pen.setSelected(false);
		this.color = Color.WHITE;
		
	}
}
