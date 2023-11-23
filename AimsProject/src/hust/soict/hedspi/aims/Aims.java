package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Aims {
	public static void main(String[] args) {
		Cart anOrder= new Cart();
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("A344","Ruby on Rails","Programming","Dương Văn Giới", 234, (float) 10);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("A345","Duong toi cung thanh","com","Dương Văn Xuan", 224, (float) 13);
		anOrder.addDigitalVideoDisc(dvd5);
		anOrder.print();
	}
	
}