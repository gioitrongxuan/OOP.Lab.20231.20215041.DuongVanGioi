package hust.soict.hedspi.aims.store;
import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Media;

public class Store {
	private List<Media> itemsInStore = new ArrayList<Media>();
	
	public List<Media> getItemsInStore() {
		return itemsInStore;
	}

	// Thêm media vào Store
	public void addMedia(Media disc) {	
		itemsInStore.add(disc);
		System.out.println("The media has been added!");
	}
	
	// Xóa media khỏi Store 
	public void removeMedia(Media disc) {	
		itemsInStore.remove(disc);
		System.out.println("The media has been removed!");
	}
	
	public Media searchByTitle(String title) {
		for(Media media : itemsInStore) {
			if(media.isMatch(title)) {
				System.out.println(media.toString());
				return media;
			}
		}
		return null;
	}
	public void print() {
		int stt=0;
		for(Media media : itemsInStore) {
			stt++;
			System.out.println(stt+media.toString());
		}
	}
	
		
}
