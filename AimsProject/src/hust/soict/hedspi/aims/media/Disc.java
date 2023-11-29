package hust.soict.hedspi.aims.media;

public abstract class Disc extends Media implements Playable{
	private int length;
	private String director;
	
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
	public Disc() {
		// TODO Auto-generated constructor stub
	}
	public Disc(String id,String title,String category, String director,int length,float Cost) {
		
		super(id, title, category, Cost);
		this.length = length;
		this.director = director;
		
	}
	@Override
	public String toString() {
		Boolean a;
		a=(director!=null&&director.length()>15);
		String cdirector = director;
		if(a) cdirector = cdirector.substring(0,11)+"...";
		return String.format("%40s%-5d%-15s",super.toString(),length,director);
	}
	
}
