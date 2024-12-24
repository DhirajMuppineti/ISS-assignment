package main;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(2, "Alice"));
        studentList.add(new Student(1, "John"));
        studentList.add(new Student(3, "Bob"));
        
        // Print unsorted students
        for (Student student : studentList) {
            logger.info(student);
        }

        // Sorting using the natural ordering defined by compareTo()
        Collections.sort(studentList);

        // Print sorted students
        for (Student student : studentList) {
            logger.info(student);
        }
	}
}
