package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{

	@Override
	public int compare(Media o1, Media o2) {
		if(o1.getTitle().compareTo(o2.getTitle()) == 0) {
			if(o1.getCost() == o2.getCost()) return 0;
			else return o1.getCost() > o2.getCost() ? 1 : -1;
		}
		else return o1.getTitle().compareTo(o2.getTitle()) > 0 ? 1 : -1;
	}
	

}
