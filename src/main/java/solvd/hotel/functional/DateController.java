package solvd.hotel.functional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class DateController {
	private final static Logger LOGGER = Logger.getLogger(DateController.class);
	private Date dataCheckIn = null;
	private Date dataCheckOut = null;
	
	private boolean use=true;
	Date dateNow = new Date();
	public DateController() {
		
	}
	
	public void correctDateEntry() {
		

	}
	
	public void inputDate() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter data receive Room(dd/MM/yyyy)");
		System.out.println("Enter data CheckIn(dd/MM/yyyy)");
		String dateCheckIn = scanner.nextLine();
		System.out.println("Enter data CheckOut(dd/MM/yyyy)");
		String dateCheckOut = scanner.nextLine();
		
		try {
			dataCheckIn = new SimpleDateFormat("dd/MM/yyyy").parse(dateCheckIn);
			dataCheckOut = new SimpleDateFormat("dd/MM/yyyy").parse(dateCheckOut);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			dataCheckIn = new Date ();
			dataCheckOut = new Date ();
			LOGGER.info(dataCheckIn);
			LOGGER.error("Date Type incorect");
		}finally {
		try {
			if((dataCheckIn.before(dataCheckOut))&(dateNow.before(dataCheckIn))&(dateNow.before(dataCheckOut))) {
			use=true;}else {
				use=false;
				LOGGER.error("Date incorect");
			}
		} catch (NullPointerException e) {
			LOGGER.error("Date incorect/NullPoiterExeption");
		}}
		

		
		
	}
	public boolean getUsed() {
		return use;
		
	}
	public Date getDateCheckIn() {
		return dataCheckIn;
		
	}
	public Date getDateCheckOut() {
		return dataCheckOut;
		
	}
}
