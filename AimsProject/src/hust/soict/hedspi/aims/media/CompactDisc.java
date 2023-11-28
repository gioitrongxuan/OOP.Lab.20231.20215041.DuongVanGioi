package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc{
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	
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
		if(tracks.isEmpty()) {
			System.out.println("There are no tracks on the CD");
		}
		for(Track track : tracks) {
			track.play();
		}
		
	}
	public String getArtist() {
		return artist;
	}

}
