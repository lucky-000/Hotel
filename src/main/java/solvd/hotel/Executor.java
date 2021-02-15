package solvd.hotel;


import java.util.Scanner;
import org.apache.log4j.Logger;
import solvd.hotel.functional.Menu;
import solvd.hotel.functional.MenuForUsers;




public class Executor {

	public static void main(String[] args)  {
		final Logger LOGGER = Logger.getLogger(Executor.class);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Are you a user or admin?(user/admin)");
		String answer = scanner.nextLine();
		switch(answer) {
		case "user":{
		MenuForUsers menuUser = new MenuForUsers();
		menuUser.createMenuForUsers();
			break;
		}
		case "admin":{
			Menu menu = new Menu();
			menu.createMenu();
			break;
		}
		default:
			LOGGER.error("Incorrectly entered person");
			break;
		}
		
		
		 


		
		
	}

}
