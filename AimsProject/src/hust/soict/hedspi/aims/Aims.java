package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Aims {
	public static void main(String[] args) {
		Cart anOrder= new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc();
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Đường Đến Với Cung Thành");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Programming","Learning Java", (float) 22.23);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Learning Python","Programming","朝日", (float) 10.12);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Ruby on Rails","Programming","Dương Văn Giới", 234, (float) 10);
		anOrder.addDigitalVideoDisc(dvd5);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd4);
		anOrder.removeDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd1,dvd2,dvd3,dvd4);
		anOrder.addDigitalVideoDisc(dvd1,dvd2);
		anOrder.displayCart();
	}
	
}