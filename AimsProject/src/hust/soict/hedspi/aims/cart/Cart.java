package hust.soict.hedspi.aims.cart;
import java.util.Collections;
import java.util.Comparator;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart  {
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	@SuppressWarnings("unused")
	private static final int MAX_NUMBERS_ORDERED =1000;
	private int qtyOrdered = 0;
	
	public void addMedia(Media media) throws LimitExceededException  {
		if( itemsOrdered.size() <  MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			qtyOrdered++;
			System.out.println("The media has been added!");
		}
		else {
			throw new LimitExceededException("ERROR: The number of"+ "media has reached its limit");
		}

	}
	
	public void removeMedia(Media media) {
		itemsOrdered.remove(media);
		qtyOrdered--;
		System.out.println("The media has been removed!");
	}

	public ObservableList< Media > getItemsOrdered() {
		return itemsOrdered;
	}

	public float totalCost() {
		float total=0;
		for(Media media : itemsOrdered) {
			total+=media.getCost();
		}
		return total;
	}
	
	//Tìm kiếm  theo Id
	public void searchByID(String id) {
		for(Media media : itemsOrdered) {
			if(media.getId() == id) 
			System.out.println(media.toString());
		}
		System.out.println("Can't found this DVD\n");
	}
	
	// Tìm kiếm theo Title
	@SuppressWarnings("unlikely-arg-type")
	public void searchByTitle(String title) {
		for(Media media : itemsOrdered) {
			if(media.equals(title)) {
				System.out.println(media.toString());
				return;
			}
			
		}
		System.out.println("Can't found this DVD\n");
	}
	
	// Sắp xếp và in ra
	public void sortPrint(Comparator<Media> comparator) {
		Cart cartClone = new Cart();
		cartClone.itemsOrdered.addAll(itemsOrdered);
		Collections.sort(cartClone.itemsOrdered,comparator);
		cartClone.print();
	}
	public void reset() {
		itemsOrdered.clear();
	}
	// In ra thông tin chi tiết đơn hàng
	public void print() {
		int stt=0;
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		System.out.printf("%5s%-5s%-5s%-20s%-10s%5s\n","STT","Type","ID","Title","Category","Cost");
		for(Media media : itemsOrdered) {
			stt++;
			System.out.printf("%5d%s\n",stt,media.toString());
		}
		System.out.printf("%45s,%5f\n","Total Cost",totalCost());
		System.out.println("***************************************************");
	}
	
}
