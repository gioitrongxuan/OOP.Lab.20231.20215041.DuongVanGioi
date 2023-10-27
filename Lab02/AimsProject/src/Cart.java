
public class Cart {
	public static final int MAX_NUMBERS_ORDERED=20;
	private DigitalVideoDisc itemsOrdered[]=new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered+1>=MAX_NUMBERS_ORDERED) {
			System.out.println("The Cart is almost full!");
			return;
		}
		itemsOrdered[qtyOrdered]=disc;
		qtyOrdered ++;
		System.out.println("The disc \" + disc.getTitle() + \" has been added!");
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
