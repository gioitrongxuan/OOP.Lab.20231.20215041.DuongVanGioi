package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;
public class Cart {
	private ArrayList<Media> itemsOrdered = new ArrayList<>();
	@SuppressWarnings("unused")
	private int qtyOrdered = 0;
	
	public void addMedia(Media media) {
		itemsOrdered.add(media);
		qtyOrdered++;
	}
	
	public void removeMedia(Media media) {
		itemsOrdered.remove(media);
		qtyOrdered--;
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
	public void searchByTitle(String title) {
		for(Media media : itemsOrdered) {
			if(media.equals(title)) {
				System.out.println(media.toString());
				return;
			}
			
		}
		System.out.println("Can't found this DVD\n");
	}
	
	// In ra thông tin chi tiết đơn hàng
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		System.out.printf("%-5s%-5s%-20s%-10s%5s\n","Type","ID","Title","Category","Cost");
		for(Media media : itemsOrdered) {
			System.out.println(media.toString());
		}
		System.out.printf("%40s,%5f","Total Cost",totalCost());
		System.out.println("***************************************************");
	}
}
