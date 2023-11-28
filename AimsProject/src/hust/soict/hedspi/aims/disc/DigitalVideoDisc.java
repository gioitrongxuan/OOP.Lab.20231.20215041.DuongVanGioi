package hust.soict.hedspi.aims.disc;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Disc;
public class DigitalVideoDisc extends Disc {
	Scanner scanner = new Scanner(System.in);
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%5s%60s","DVD:",super.toString());
	}
	//kiểm tra title có giống không
	public DigitalVideoDisc() {
		super();
	}
	public DigitalVideoDisc(String id, String title, String category, String director,int length, float cost) {
		super(id, title, category, director, length, cost);
	}
	@Override
	public void play() {
		System.out.println("Playing DVD: "+ this.getTitle());
		System.out.println("DVD length: "+ this.getLength());
		System.out.println("Press enter to stop playing");
		scanner.nextLine();
	}
}
