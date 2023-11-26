package hust.soict.hedspi.test.store;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("B114","The Lion King","Animation","Roger Allers",87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("D425","Star Wars","Science Fiction","Gerge Lucas",87,24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("D342","Aladin","Animation","H",56,18.99f);

		// Test addDvd method	
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		
		store.print();
		//Test removeDVD method
		store.removeMedia(dvd2);
	}
}
