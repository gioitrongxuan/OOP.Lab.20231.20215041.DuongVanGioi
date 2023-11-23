package hust.soict.hedspi.aims.store;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBERS_ORDERED=200;
	private int qtyOrdered = 0;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	// Thêm DVD vào Store
	public void addDVD(DigitalVideoDisc disc) {
		if(qtyOrdered>=MAX_NUMBERS_ORDERED) {
			System.out.println("The Cart is almost full!");
			return;
		}
		itemsInStore[qtyOrdered]=disc;
		qtyOrdered ++;
		System.out.println("The disc has been added!");
	}
	
	// Xóa DVD khỏi Store 
	public void removeDVD(DigitalVideoDisc disc) {
		for(int i=0;i<qtyOrdered;i++) {
			if( itemsInStore[i] == disc ) {
				itemsInStore[i] = null;
				for(int j=i;j<qtyOrdered;j++) itemsInStore[j]=itemsInStore[j+1];
				qtyOrdered--;
				System.out.println("Remove succesfully!");
			}
		}
		
	}
	
	public void print() {
		for(int i=0;i<qtyOrdered;i++) {
			System.out.println(itemsInStore[i].toString());
		}
	}
	
		
}
