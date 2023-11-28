package hust.soict.hedspi.aims.media;

import java.util.Scanner;

public class Track implements Playable {
	Scanner scanner = new Scanner(System.in);
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
		System.out.println("Press enter to stop playing");
		scanner.nextLine();
	}
	@Override
	public boolean equals(Object obj) {
		Track track=(Track)obj;
		if(this.title==track.title && this.length == track.length) return true;
		else return false;
	}
	
}
