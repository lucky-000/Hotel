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
		list.readFileAndConvertToPOJO();
		boolean menu=true;
		Room room = new Room();
		TypeRoom typeRoom = new TypeRoom();
		Receive receive = new Receive();
		do {
			System.out.println("Print number");
			System.out.println("1.Add Room");
			System.out.println("2.Print All Rooms");
			System.out.println("3.Delete Room");
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
				if ("no".equals(answer)) {
					receive.setReceive(false);
					receive.setData(null);
				} if("yes".equals(answer)) {
					receive.setReceive(true);
					System.out.println("Enter data receive Room(dd/MM/yyyy)");
					String date = scanner.nextLine();
					Date data = null;
					try {
						data = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						LOGGER.error("Date Type incorect");
						e.printStackTrace();
					}
					receive.setData(data);
					
					
				}else{
					LOGGER.error("Incorect value");
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
			default:
				menu=false;
				break;
				
			}	
		} while(menu);
	}
}
