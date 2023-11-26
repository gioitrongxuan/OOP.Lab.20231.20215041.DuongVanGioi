package hust.soict.hedspi.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
	
	public CompactDisc() {
		super();
	}
	
	public void addTrack(Track track) {
		tracks.add(track);
	}
	public void removeTrack(Track track) {
		tracks.remove(track);
	}

	public CompactDisc(String id, String title, String category, String director, int length, float Cost, String artist) {
		super(id, title, category, director, length, Cost);
		this.artist= artist;
	}
	@Override
	public String toString() {
		return String.format("%5s%60s%10s","CD:",super.toString(),artist);
	}
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
	public String getArtist() {
		return artist;
	}

}
