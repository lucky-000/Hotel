package solvd.hotel.functional;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.apache.log4j.Logger;
import solvd.hotel.room.Receive;
import solvd.hotel.room.Room;
import solvd.hotel.room.TypeRoom;


public class Menu {
	private final static Logger LOGGER = Logger.getLogger(Menu.class);

	public Menu() {
		
	}
	
	public void createMenu() {
		Creator list = new Creator();
		
		boolean menu=true;
		Room room = new Room();
		TypeRoom typeRoom = new TypeRoom();
		Receive receive = new Receive();
		DateController dateCont = new DateController();
		Date date =new Date();
		do {
			list.readFileAndConvertToPOJO();
			System.out.println("Print number");
			System.out.println("1.Add Room");
			System.out.println("2.Print All Rooms");
			System.out.println("3.Delete Room");
			System.out.println("4.Cancel the reservation");
			Scanner scaner = new Scanner(System.in);
			Scanner scanner = new Scanner(System.in);
			int choice = scaner.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter Number Room");
				room.setNumberRoom(scaner.nextInt());
				System.out.println("Enter Count Bed");
				room.setCountBed(scaner.nextInt());
				System.out.println("Enter Type Room");
				typeRoom.setTypeRoom(scanner.nextLine());
				System.out.println("Enter Price Room");
				room.setPrice(scaner.nextInt());
				System.out.println("Enter receive Room(yes/no)");
				String answer = scanner.nextLine();
				switch(answer) {
				case "no":{
					receive.setReceive(false);
					receive.setDataCheckIn(date);
					receive.setDataCheckOut(date);
					break;
				}
				case "yes":{
//					
					dateCont.inputDate();
					if(dateCont.getUsed()) {
					receive.setReceive(true);

					receive.setDataCheckIn(dateCont.getDateCheckIn());
					receive.setDataCheckOut(dateCont.getDateCheckOut());}
					
					break;
					
				}
				default:
					LOGGER.error("Incorect value");
					break;
				}
				
				room.setReceive(receive);
				room.setTypeRoom(typeRoom);
				list.addRoom(room);
				LOGGER.info("Room added To List");
				list.addListToJson();
				LOGGER.info("List added To File");
				break;
			case 2:
				list.printInfo();
				break;
			case 3:
				list.printInfo();
				System.out.println("Print number del");
				Scanner index = new Scanner(System.in);
				list.delRoom(index.nextInt());
				list.printInfo();
				list.addListToJson();
				break;
			case 4:
				System.out.println("Enter the room number:");
				int numberRoom =  scaner.nextInt();
				dateCont.inputDate();
				list.cancelReceivedRoom(numberRoom, dateCont.getDateCheckIn(), dateCont.getDateCheckOut());
				list.addListToJson();
				break;
			default:
				menu=false;
				break;
				
			}	
		} while(menu);
	}

}
