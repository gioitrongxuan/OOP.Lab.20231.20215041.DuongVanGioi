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
	public Book(String id,String title, String category, float cost,List<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}
	
	@Override
	public String toString() {
		return String.format("%5s%s","BOOK:", super.toString())+authors;
	}

}
