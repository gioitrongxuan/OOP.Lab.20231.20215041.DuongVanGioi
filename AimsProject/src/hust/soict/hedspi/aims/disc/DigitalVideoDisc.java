package hust.soict.hedspi.aims.disc;
import hust.soict.hedspi.aims.media.Media;
public class DigitalVideoDisc extends Media {
	private String director;
	private int length=-1;
	private static int nbDigitalVideoDisc=0;
	
	@SuppressWarnings("unused")
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Boolean a,b,c;
		a=(super.getTitle()!=null&&super.getTitle().length()>20);
		b=(super.getCategory()!=null&&super.getCategory().length()>10);
		c=(director!=null&&director.length()>15);
		String atitle = super.getTitle();
		String bcategory = super.getCategory();
		String cdirector = director;
		if(a) atitle = atitle.substring(0,16)+"...";
		if(b) bcategory = bcategory.substring(0,6)+"...";
		if(c) cdirector = cdirector.substring(0,11)+"...";
		return String.format("DVD-%-20s %-10s %-15s%-10d: %.2f\n",atitle,bcategory,cdirector,length,super.getCost());
	}
	//kiểm tra title có giống không
	public boolean isMatch(String titleSearch) {
		if(titleSearch.equals(titleSearch)) return true;
		else return false;
		
	}
	
	
	public static int getNbDigitalVideoDisc() {
		return nbDigitalVideoDisc;
	}
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public DigitalVideoDisc() {
		super();
		nbDigitalVideoDisc++;
	}
	public DigitalVideoDisc(String id, String title, String category, String director,int length, float cost) {
		super(id,title,category,cost);
		this.length = length;
		this.director=director;
		nbDigitalVideoDisc++;
	}
	
 
}
