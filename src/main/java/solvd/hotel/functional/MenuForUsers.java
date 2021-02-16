package solvd.hotel.functional;



import java.util.Scanner;

import org.apache.log4j.Logger;



public class MenuForUsers {
	private final static Logger LOGGER = Logger.getLogger(MenuForUsers.class);

	public MenuForUsers() {
		
	}
	public void createMenuForUsers() {
		boolean menu=true;
		Creator list =new Creator();
		

		do {
			list.readFileAndConvertToPOJO();
			System.out.println("Print number");
			System.out.println("1.Information by room number.");
			System.out.println("2.Book room");
			System.out.println("3.Information on all rooms");
			Scanner scaner = new Scanner(System.in);
			Scanner scanner = new Scanner(System.in);
			DateController dateCont = new DateController();
			

			int choice = scaner.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the room number:");
				int numberRoom =  scaner.nextInt();
				list.searchRoom(numberRoom);
				break;
			case 2:
				System.out.println("Enter the room number");
				int numberRoom1 =  scaner.nextInt();
				dateCont.inputDate();
				if(dateCont.getUsed()) {
					list.receivedRoomDateCheck(numberRoom1, dateCont.getDateCheckIn(), dateCont.getDateCheckOut());
					list.addListToJson();
					LOGGER.info("You received room!");
				}
				
				
				break;
			case 3:
				list.printInfoForUser();

				break;

			default:
				menu=false;
				break;
				
			}	
		} while(menu);
		
	}
}
