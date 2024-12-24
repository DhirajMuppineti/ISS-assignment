package main;

import javax.xml.bind.*;
import java.io.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		try {
			// Create a new student object
	        Student student = new Student();
	        student.setStudentId(1);
	        student.setStudentName("John");

	        // Marshal: Convert Java object to XML
	        JAXBContext context = JAXBContext.newInstance(Student.class);
	        Marshaller marshaller = context.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	        // Write to a file
	        marshaller.marshal(student, new File("./src/main/student.xml"));

	        // Unmarshal: Convert XML back to Java object
	        Unmarshaller unmarshaller = context.createUnmarshaller();
	        Student deserializedStudent = (Student) unmarshaller.unmarshal(new File("./src/main/student.xml"));
	        logger.info("\nDeserialized Student: " + deserializedStudent.getStudentName());
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
