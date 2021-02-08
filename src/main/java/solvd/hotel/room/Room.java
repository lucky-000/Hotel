package solvd.hotel.room;

public class Room extends Hotel{
	private int numberRoom;
	private int countBed;
	private int price;
	private TypeRoom typeRoom;
	private Receive receive;
	public Room() {
		
	}
	public Room(int numberRoom, int countBed, int price) {
		super();
		this.numberRoom=numberRoom;
		this.countBed=countBed;
		this.price=price;
		
	}
	public void setNumberRoom(int numberRoom){
		this.numberRoom=numberRoom;
	}
	public int getNumberRoom() {
		return numberRoom;
	}
	public void setCountBed(int countBed) {
		this.countBed=countBed;
	}
	public int getCountBed() {
		return countBed;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public int getPrice() {
		return price;
	}
	public void setTypeRoom(TypeRoom typeRoom) {
		this.typeRoom=typeRoom;
	}
	public TypeRoom getTypeRoom() {
		return typeRoom;
	}
	public void setReceive(Receive receive) {
		this.receive=receive;
	}
	public Receive getReceive() {
		return receive;
	}
}
