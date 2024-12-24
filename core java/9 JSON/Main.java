package main;

import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		List<Student> studentList = Arrays.asList(
                new Student(1, "John"),
                new Student(2, "Alice"),
                new Student(3, "Bob")
        );
		//Using google's GSON for JSON serialization and deserialization
        Gson gson = new Gson();

        // Serialize List to JSON
        String jsonString = gson.toJson(studentList);
        logger.info("Serialized List JSON: " + jsonString);

        // Deserialize JSON back to List of Students
        List<Student> deserializedList = gson.fromJson(jsonString, new TypeToken<List<Student>>(){}.getType());
        logger.info("Deserialized List: " + deserializedList);
	}
}
