package solvd.hotel.functional;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import solvd.hotel.room.Receive;
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
					+" date CheckIn: "+room.getReceive().getDataCheckIn()
					+" date CheckOut: "+room.getReceive().getDataCheckOut());
			index++;
		}
		
	}
	public void printInfoForUser() {
		
		for(Room room: content) {
			
			System.out.println (" Title Hotel: "+room.getTitle()
					+" numberRoom: "+room.getNumberRoom()
					+" countBed: "+room.getCountBed()
					+" typeRoom: "+room.getTypeRoom().getTypeRoom()
					+" price: "+room.getPrice());
			
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
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchRoom(int numberRoom) {
		
		for(Room room: content) {
			if(numberRoom == room.getNumberRoom()) {
				System.out.println("Title Hotel: "+room.getTitle()
				+" numberRoom: "+room.getNumberRoom()
				+" countBed: "+room.getCountBed()
				+" typeRoom: "+room.getTypeRoom().getTypeRoom()
				+" price: "+room.getPrice()
				+" receive: "+room.getReceive().getReceive()
				+" date CheckIn: "+room.getReceive().getDataCheckIn()
				+" date CheckOut: "+room.getReceive().getDataCheckOut());
				
			}
		}
	}
	public void cancelReceivedRoom(int numberRoom, Date dateCheckIn, Date dateCheckOut) {
		Receive receive = new Receive();
		for(Room room: content) {
			if(numberRoom == room.getNumberRoom()
					&dateCheckIn.equals(room.getReceive().getDataCheckIn())&
					dateCheckOut.equals(room.getReceive().getDataCheckOut())) {
				receive.setDataCheckIn(room.getReceive().getDataCheckIn());
				receive.setDataCheckOut(room.getReceive().getDataCheckOut());
				receive.setReceive(false);
				room.setReceive(receive);
				LOGGER.info("Reservation canceled ");
			}
			
		}
	}
	public void receivedRoomDateCheck(int numberRoom, Date dateCheckIn, Date dateCheckOut ) {
		boolean a1=false;
		boolean a2=false;
		int check = 0;
		Room roomNew = new Room();
		Receive receive = new Receive();
		for(Room room: content) {
			if(numberRoom == room.getNumberRoom()) {
//				roomNew=room;
				roomNew.setCountBed(room.getCountBed());
				roomNew.setNumberRoom(room.getNumberRoom());
				roomNew.setPrice(room.getPrice());
				roomNew.setTypeRoom(room.getTypeRoom());
				check=1;
				break;
			}else {
				check=2;
			}
		}
		
		switch (check) {
		case 1:
			for(Room room: content) {	
				if((numberRoom == room.getNumberRoom())&(room.getReceive().getReceive())) {
					
					if(dateCheckIn.before(room.getReceive().getDataCheckIn())|
							(dateCheckIn.after(room.getReceive().getDataCheckOut()))) {
						a1=false;
					}else{
						LOGGER.error("You cannot book on this date(CheckIn)");
						a1=true;
						break;
						}
				}
				
			}
			
			for(Room room: content) {		
				if((numberRoom == room.getNumberRoom())&(room.getReceive().getReceive())) {
					roomNew=room;
					if(dateCheckOut.after(room.getReceive().getDataCheckOut())|
							(dateCheckOut.before(room.getReceive().getDataCheckIn()))) {
						a2=false;
					}else {
						LOGGER.error("You cannot book on this date(CheckOut)");
						a2=true;
						break;}
				}
				
			}
			
			if(a1|a2) {
				LOGGER.error("You cannot book on this date");
				LOGGER.error("Select other dates");
			}else {
				
				receive.setDataCheckIn(dateCheckIn);
				receive.setDataCheckOut(dateCheckOut);
				receive.setReceive(true);
				roomNew.setReceive(receive);
//				content.add(roomNew);
				addRoom(roomNew);
				LOGGER.info("You have reserved");
			}		
			
			break;

		default:
			LOGGER.error("This room does not exist");
			break;
		}

		
	}
	
}
