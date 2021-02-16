package solvd.hotel.room;

import java.util.Date;

public class Receive {
	private boolean  isReceive=false;

//	 Data data;
	 private Date dataCheckOut = new Date();
	 private Date dataCheckIn = new Date();
	public Receive() {
		
	}
	public Receive(boolean isReceive, Date dataCheckIn, Date dataCheckOut ) {
		this.isReceive=isReceive;
		this.dataCheckIn=dataCheckIn;
		this.dataCheckOut=dataCheckOut;

	}
	public void setReceive(boolean isReceive) {
		this.isReceive=isReceive;	
	}
	public boolean getReceive() {
		return isReceive;
	}

	public void setDataCheckIn(Date dataCheckIn) {
		this.dataCheckIn=dataCheckIn;
	}
	public Date getDataCheckIn() {
		return dataCheckIn;
	}
	public void setDataCheckOut(Date dataCheckOut) {
		this.dataCheckOut=dataCheckOut;
	}
	public Date getDataCheckOut() {
		return dataCheckOut;
	}
}
