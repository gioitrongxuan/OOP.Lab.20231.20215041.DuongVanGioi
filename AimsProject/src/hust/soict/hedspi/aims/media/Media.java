package hust.soict.hedspi.aims.media;

public abstract class Media {
	private String id;
	private String title;
	private String category;
	private float cost;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public Media() {
		super();
	}
	public Media(String id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	@Override
	public String toString() {
		boolean a,b;
		String atitle = title,bcategory = category;
		a=(title!=null&& title.length()>20);
		b=(category!=null&&category.length()>10);
		if(a) atitle = atitle.substring(0,16)+"...";
		if(b) bcategory = bcategory.substring(0,6)+"...";
		return String.format("%-5s%-20s%-10s%5.2f",this.id,atitle,bcategory,cost);
	}

}
