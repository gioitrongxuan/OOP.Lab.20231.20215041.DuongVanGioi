package hust.soict.hedspi.test.cart;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
public class CartTest {
	public static void main(String[] args) {
		// Crate a new cart
		Cart cart = new Cart();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("B114","The Lion King","Animation","Roger Allers",87, 19.95f);
		cart.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("D425","Star Wars","Science Fiction","Gerge Lucas",87,24.95f);
		cart.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("D342","Aladin","Animation","H",56,18.99f);
		cart.addMedia(dvd3);
		
	//Test the print method
		cart.print();
		
		
	//Test the search methods 
		
		// Test search by ID
		String idSearch = "D425";
		System.out.println("Search by Id: "+idSearch);
		cart.searchByID(idSearch);
		
		// Test search by title
		String titleSearch = "The Lion King";
		System.out.println("Search by title: "+titleSearch);
		cart.searchByTitle(titleSearch);
		
		
	}
}
