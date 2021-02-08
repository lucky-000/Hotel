package solvd.hotel.room;

import java.util.Date;

public class Receive {
	private boolean  receive;

//	 Data data;
	 private Date data = null;
	public Receive() {
		
	}
	public Receive(boolean receive, Date data ) {
		this.receive=receive;
		this.data=data;

	}
	public void setReceive(boolean receive) {
		this.receive=receive;	
	}
	public boolean getReceive() {
		return receive;
	}

	public void setData(Date data) {
		this.data=data;
	}
	public Date getData() {
		return data;
	}
}
