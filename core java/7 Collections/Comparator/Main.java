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

        // Sorting using a custom comparator
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.studentId, s2.studentId);  // Compare by name
            }
        });

        // Print sorted students
        for (Student student : studentList) {
            logger.info(student);
        }
	}
}
