package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter; 
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    
    public static void main(String[] args) {
    	// Accept a string  
        String str = "File Handling in Java using " + " FileWriter and FileReader"; 
  
        try {
        	// attach a file to FileWriter  
        	FileWriter fw = new FileWriter("./src/main/output.txt"); 
        	// read character wise from string and write into FileWriter  
            for (int i = 0; i < str.length(); i++) 
                fw.write(str.charAt(i)); 
            //close the file  
            fw.close();
            logger.info("Writing successful"); 
             
        }catch (IOException e) {
        	e.printStackTrace();
        }
        
        int ch; 
  
        // check if File exists or not 
        FileReader fr=null; 
        try
        { 
            fr = new FileReader("./src/main/output.txt"); 
        } 
        catch (FileNotFoundException fe) 
        { 
            logger.error("File not found"); 
        } 
        
        try {
	        // read from FileReader till the end of file 
        	String res = "";
	        while ((ch=fr.read())!=-1) 
	            res += ((char)ch); 
	        logger.info(res);
	        fr.close(); 
        }catch(IOException e) {
        	e.printStackTrace();
        }
    }
}
