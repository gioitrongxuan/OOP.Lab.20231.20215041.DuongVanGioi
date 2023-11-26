package hust.soict.hedspi.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	@Override
	public void play() {
		System.out.println("Playing Track: "+ this.title);
		System.out.println("Track length: "+ this.length);
	}
	@Override
	public boolean equals(Object obj) {
		Track track=(Track)obj;
		if(this.title==track.title && this.length == track.length) return true;
		else return false;
	}
	
}
