package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED=20;
	private DigitalVideoDisc itemsOrdered[]=new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered>=MAX_NUMBERS_ORDERED) {
			System.out.println("The Cart is almost full!");
			return;
		}
		itemsOrdered[qtyOrdered]=disc;
		qtyOrdered ++;
		System.out.println("The disc has been added!");
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc ... discsList) {
		for (DigitalVideoDisc disc : discsList) {
            if ( qtyOrdered < MAX_NUMBERS_ORDERED ) {
            	itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The disc " + disc.getTitle() + " has been added!");
            } else {
            	System.out.println("The Cart is almost full!");
            }
        }
		return;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc1,DigitalVideoDisc disc2) {
            if ( qtyOrdered < MAX_NUMBERS_ORDERED ) {
            	itemsOrdered[qtyOrdered] = disc1;
                qtyOrdered++;
                System.out.println("The disc " + disc1.getTitle() + " has been added 1!");
            } else {
            	System.out.println("The Cart is almost full!");
            }
            if ( qtyOrdered < MAX_NUMBERS_ORDERED ) {
            	itemsOrdered[qtyOrdered] = disc2;
                qtyOrdered++;
                System.out.println("The disc " + disc2.getTitle() + " has been added! 2");
            } else {
            	System.out.println("The Cart is almost full!");
            }
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i] == disc) {
				itemsOrdered[i] = null;
				for(int j=i;j<qtyOrdered;j++) itemsOrdered[j]=itemsOrdered[j+1];
				qtyOrdered--;
				System.out.println("Remove succesfully!");
			}
		}

	}
	
	public float totalCost() {
		float total=0;
		for(int i=0;i<qtyOrdered;i++) {
			total+=itemsOrdered[i].getCost();
		}
		return total;
	}
	
	//Tìm kiếm  theo Id
	public DigitalVideoDisc searchByID(String id) {
		for(int i =0; i< this.qtyOrdered ;i++) {
			if(itemsOrdered[i].getId() == id) 	return itemsOrdered[i];
		}
		return null;
	}
	
	// Tìm kiếm theo Title
	public DigitalVideoDisc searchByTitle(String title) {
		for(int i =0; i< this.qtyOrdered ;i++) {
			if(itemsOrdered[i].isMatch(title)) 	return itemsOrdered[i];
		}	
		return null;
	}
	
	// In ra thông tin chi tiết đơn hàng
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		System.out.printf("%-3s %-24s %-10s %-15s%-11s %s\n","STT","Title","Category","Director","Length","Cost");
		for(int i=0;i<qtyOrdered;i++) {
			System.out.printf("%-3d.%s",i+1,itemsOrdered[i].toString());
		}
		System.out.printf("%5s%-62s%.2f\n"," ","Total Cost",totalCost());
		System.out.println("***************************************************");
	}
}
