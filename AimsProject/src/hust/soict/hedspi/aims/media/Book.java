package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public List<String> getAuthors() {
		return authors;
	}
	public void addAuthor(String author) {
		this.authors.add(author);
	}
	public void removeAuthor(String author) {
		this.authors.remove(author);
	}
	@Override
	public String toString() {
		return super.toString();
	}

}
