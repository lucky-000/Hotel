package solvd.hotel.room;

import java.util.Date;

public class Receive {
	private boolean  receive;

//	 Data data;
	 private Date dataCheckOut = new Date();
	 private Date dataCheckIn = new Date();
	public Receive() {
		
	}
	public Receive(boolean receive, Date dataCheckIn, Date dataCheckOut ) {
		this.receive=receive;
		this.dataCheckIn=dataCheckIn;
		this.dataCheckOut=dataCheckOut;

	}
	public void setReceive(boolean receive) {
		this.receive=receive;	
	}
	public boolean getReceive() {
		return receive;
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
