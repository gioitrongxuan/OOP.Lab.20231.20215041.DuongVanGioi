package hust.soict.hedspi.test.screen.customer.cart;

import java.util.Arrays;
import java.util.List;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewCart extends Application{
	private static Cart cart;
	private static Store store;
	@Override
	public void start(Stage primaryStage) throws Exception {
		final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
		CartController cartController = new CartController(cart,store);
		fxmlLoader.setController(cartController);
		Parent root = fxmlLoader.load();
	
		primaryStage.setTitle("Cart");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	public static void main(String[] args) throws LimitExceededException {
		cart = new Cart();
		//Nhap media
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("D001", "The Matrix", "Action", "Wachowski Brothers", 136, 19.99f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("D002", "Inception", "Sci-Fi", "Christopher Nolan", 148, 24.99f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("D003", "The Shawshank Redemption", "Drama", "Frank Darabont", 142, 15.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("D004", "Forrest Gump", "Drama", "Robert Zemeckis", 142, 18.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("D005", "The Dark Knight", "Action", "Christopher Nolan", 152, 21.99f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("D006", "Pulp Fiction", "Crime", "Quentin Tarantino", 154, 17.99f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("D007", "The Godfather", "Crime", "Francis Ford Coppola", 175, 22.99f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("D008", "Jurassic Park", "Adventure", "Steven Spielberg", 127, 16.99f);
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("D009", "Avatar", "Sci-Fi", "James Cameron", 162, 23.99f);
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("D010", "Titanic", "Romance", "James Cameron", 195, 20.99f);
	    CompactDisc cd1 = new CompactDisc("C001", "Thriller", "Pop", "Michael Jackson", 42, 14.99f, "Various Artists");
	    CompactDisc cd2 = new CompactDisc("C002", "Abbey Road", "Rock", "The Beatles", 47, 18.99f, "The Beatles");
	    List<String> authors1 = Arrays.asList("J.K. Rowling","J.K.K Rowling");
	    Book book1 = new Book("B001", "Harry Potter and the Sorcerer's Stone", "Fantasy", 29.99f, authors1);
	    System.out.println(dvd2.toString());
	    List<String> authors2 = Arrays.asList("George Orwell");
	    Book book2 = new Book("B002", "1984", "Dystopian", 19.99f, authors2);
	    cart.addMedia(book2);
	    cart.addMedia(book1);
	    cart.addMedia(cd1);
	    cart.addMedia(cd2);
	    cart.addMedia(dvd1);
	    cart.addMedia(dvd2);
	    cart.addMedia(dvd3);
	    cart.addMedia(dvd4);
	    cart.addMedia(dvd5);
	    cart.addMedia(dvd6);
	    cart.addMedia(dvd7);
	    cart.addMedia(dvd8);
	    cart.addMedia(dvd9);
	    cart.addMedia(dvd10);
		launch(args);
	}
}
