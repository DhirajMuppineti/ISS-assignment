package main;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
        Student student1 = new Student(1, "John");
        Student student2 = new Student(2, "Alice");
        Student student3 = new Student(3, "Jack");
        
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);  
        studentList.add(student1); // Duplicates allowed in the list
        logger.info("Student List : ");
        // Print all students in the list
        for (Student student : studentList) {
            logger.info(student);
        }
		
		Set<Student> studentSet = new HashSet<>();
		        
	    studentSet.add(student1);
	    studentSet.add(student2);
	    studentSet.add(student3);
	    studentSet.add(student1);// Duplicate not allowed in a set
	    
	    logger.info("Student Set : ");
	    for (Student student : studentSet) {
	        logger.info(student);
	    }
	    
	    
	    Map<Integer, Student> studentMap = new HashMap<>();
        
        studentMap.put(1, student1);
        studentMap.put(2, student1);
        studentMap.put(1, student1);  // Duplicate key, will overwrite
        
        logger.info("Student Map : ");
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            logger.info("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
	}
}
