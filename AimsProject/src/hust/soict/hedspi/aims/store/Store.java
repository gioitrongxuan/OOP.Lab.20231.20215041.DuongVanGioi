package hust.soict.hedspi.aims.store;
import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<>();
	
	// Thêm media vào Store
	public void addMedia(Media disc) {	
		itemsInStore.add(disc);
		System.out.println("The disc has been added!");
	}
	
	// Xóa media khỏi Store 
	public void removeMedia(Media disc) {	
		itemsInStore.remove(disc);
		System.out.println("The disc has been removed!");
	}
	
	public void print() {
		for(Media media : itemsInStore) {
			System.out.println(media.toString());
		}
	}
	
		
}
