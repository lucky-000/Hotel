package solvd.hotel;

import java.util.Scanner;
import org.apache.log4j.Logger;
import solvd.hotel.functional.Menu;




public class Executor {

	public static void main(String[] args)  {
		final Logger LOGGER = Logger.getLogger(Executor.class);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Are you a user or admin?(user/admin)");
		String answer = scanner.nextLine();
		if ("user".equals(answer)) {
			
		}else {
			
		 if("admin".equals(answer)) {
			Menu menu = new Menu();
			menu.createMenu();
			
		}else{
			LOGGER.error("Incorect value");
		}}
		 


		
		
	}

}
