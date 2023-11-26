package hust.soict.hedspi.aims.disc;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Playable;
public class DigitalVideoDisc extends Disc implements Playable {
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%5s%60s","DVD:",super.toString());
	}
	//kiểm tra title có giống không
	public boolean isMatch(String titleSearch) {
		if(titleSearch.equals(titleSearch)) return true;
		else return false;
		
	}
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
	}
}
