package solvd.hotel.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.apache.log4j.Logger;


public class ReadingFromFile {
	private final static Logger LOGGER = Logger.getLogger(ReadingFromFile.class);
	
	public String  readFromFile(String path) {
		
			
			File file = new File(path);
			
			Scanner scanner = null;

			try {

				scanner = new Scanner(file);
				LOGGER.info("Read from file, finished!");
				return scanner.nextLine();
				

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} finally {
				scanner.close();
			}
			
			return "default";
			
		}
}
