package solvd.hotel.utils;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonConverter {
	private final static Logger LOGGER = Logger.getLogger(JsonConverter.class);
	public void convertJavaToJsonFile(Object obj, String pathToFile) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(Paths.get(pathToFile).toFile(), obj);
			LOGGER.info("write to file, finished!");

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
