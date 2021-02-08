package solvd.hotel.room;

public abstract class Hotel{
	private String title;
	public Hotel() {
		title="default";
	}
	public Hotel(String title) {
		this.title=title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public String getTitle() {
		return title;
	}
	
}
