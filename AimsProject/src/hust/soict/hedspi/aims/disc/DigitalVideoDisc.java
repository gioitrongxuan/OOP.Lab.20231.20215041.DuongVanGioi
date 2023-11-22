package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length=-1;
	private float cost;
	private int id;
	private static int nbDigitalVideoDisc=0;
	
	@SuppressWarnings("unused")
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Boolean a,b,c;
		a=(title!=null&&title.length()>20);
		b=(category!=null&&category.length()>10);
		c=(director!=null&&director.length()>15);
		String atitle = title;
		String bcategory = category;
		String cdirector = director;
		if(a) atitle = title.substring(0,16)+"...";
		if(b) bcategory = category.substring(0,6)+"...";
		if(c) cdirector = director.substring(0,11)+"...";
		return String.format("DVD-%-20s %-10s %-15s%-10d: %.2f\n",atitle,bcategory,cdirector,length,cost);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static int getNbDigitalVideoDisc() {
		return nbDigitalVideoDisc;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public DigitalVideoDisc() {
		super();
		nbDigitalVideoDisc++;
		this.id=nbDigitalVideoDisc;
	}
	public DigitalVideoDisc(String title) {
		super();
		nbDigitalVideoDisc++;
		this.id=nbDigitalVideoDisc;
		this.title = title;
	}
	public DigitalVideoDisc(String category, String title, float cost) {
		super();
		nbDigitalVideoDisc++;
		this.id=nbDigitalVideoDisc;
		this.category = category;
		this.title = title;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		nbDigitalVideoDisc++;
		this.id=nbDigitalVideoDisc;
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		nbDigitalVideoDisc++;
		this.id=nbDigitalVideoDisc;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	
 
}
