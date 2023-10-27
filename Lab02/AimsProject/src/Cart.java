
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
	
//	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
//		for (DigitalVideoDisc dvd : dvdList) {
//            if ( qtyOrdered < MAX_NUMBERS_ORDERED ) {
//            	itemsOrdered[qtyOrdered] = dvd;
//                qtyOrdered++;
//                System.out.println("The disc " + dvd.getTitle() + " has been added!");
//            } else {
//            	System.out.println("The Cart is almost full!");
//            }
//        }
//		return;
//	}
//	
	public void addDigitalVideoDisc(DigitalVideoDisc ... dvdList) {
		for (DigitalVideoDisc dvd : dvdList) {
            if ( qtyOrdered < MAX_NUMBERS_ORDERED ) {
            	itemsOrdered[qtyOrdered] = dvd;
                qtyOrdered++;
                System.out.println("The disc " + dvd.getTitle() + " has been added!");
            } else {
            	System.out.println("The Cart is almost full!");
            }
        }
		return;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
            if ( qtyOrdered < MAX_NUMBERS_ORDERED ) {
            	itemsOrdered[qtyOrdered] = dvd1;
                qtyOrdered++;
                System.out.println("The disc " + dvd1.getTitle() + " has been added!");
            } else {
            	System.out.println("The Cart is almost full!");
            }
            if ( qtyOrdered < MAX_NUMBERS_ORDERED ) {
            	itemsOrdered[qtyOrdered] = dvd2;
                qtyOrdered++;
                System.out.println("The disc " + dvd2.getTitle() + " has been added!");
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
	public void displayCart() {
		for(int i=0;i<qtyOrdered;i++) {
			System.out.printf("%-5d%-30s%.2f\n",i+1,itemsOrdered[i].getTitle(),itemsOrdered[i].getCost());
		}
		System.out.printf("%5s%-30s%.2f"," ","Total Cost",totalCost());
	}
}
