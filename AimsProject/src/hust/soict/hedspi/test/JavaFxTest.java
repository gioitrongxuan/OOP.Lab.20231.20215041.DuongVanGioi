package hust.soict.hedspi.test;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
public class JavaFxTest extends Application {
	@Override
	public void start(Stage primaryStage)  {
		primaryStage.setTitle("Hello World");
		Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");			
			}
		});
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root,300,250));
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
