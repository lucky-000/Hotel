package solvd.hotel.functional;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import solvd.hotel.room.Room;
import solvd.hotel.utils.JsonConverter;



	public class Creator {
		private final static Logger LOGGER = Logger.getLogger(Creator.class);
		
	List<Room> content;
	public Creator() {
		content = new ArrayList<Room>();	
		
	}
	public void addRoom(Room room) {
		content.add(room);
	}
	public void printInfo() {
		int index=0;
		LOGGER.info(content);
		for(Room room: content) {
			
			System.out.println(index + ". Title Hotel: "+room.getTitle()
					+" numberRoom: "+room.getNumberRoom()
					+" countBed: "+room.getCountBed()
					+" typeRoom: "+room.getTypeRoom().getTypeRoom()
					+" price: "+room.getPrice()
					+" receive: "+room.getReceive().getReceive()
					+" date receive: "+room.getReceive().getData());
			index++;
		}
		
	}
	public void delRoom(int index) {
		content.remove(index);
		LOGGER.info("Deleted Room with ArrayList");
	}
	public void addListToJson() {
		JsonConverter jsonAction = new JsonConverter();
		jsonAction.convertJavaToJsonFile(content, "room.json");
	}
	
	public void readFileAndConvertToPOJO() {
		 ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			content = objectMapper.readValue(
			        new File("room.json"), 
			        new TypeReference<List<Room>>(){});	
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
