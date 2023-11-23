package hust.soict.hedspi.test.disc;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String [] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc();
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc();
		
		swap(jungleDVD,cinderellaDVD);
		System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD,cinderellaDVD.getTitle());
		System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
	}
	public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
		DigitalVideoDisc temp = o1;
		o1 = o2;
		o2 = temp;
		return;
	}
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
//		String oldTitle = dvd.getTitle();
//		dvd.setTitle(title);
		dvd = new DigitalVideoDisc();
	}
}
