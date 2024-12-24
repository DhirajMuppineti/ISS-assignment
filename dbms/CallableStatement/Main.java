package main;

import java.sql.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    
    public static void main(String[] args) {
        // Database connection string
        String url = "jdbc:sqlserver://LAPTOP-KRSQ446S;databaseName=mydb;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        
        try {

            logger.info("Connecting to database...");
            connection = DriverManager.getConnection(url);
            logger.debug("About to execute the stored procedure...");
            
            // CallableStatement
            String sql = "{CALL GetAverageDepartmentSalaries}";
            callableStatement = connection.prepareCall(sql);
            logger.info("Executing stored procedure...");
            
            //Executing the stored procedure
            resultSet = callableStatement.executeQuery();
            logger.info("Stored procedure executed.");
            
            int rowsReturned = 0;
            while (resultSet.next()) {
                int departmentID = resultSet.getInt("DepartmentID");
                String departmentName = resultSet.getString("DepartmentName");
                double averageSalary = resultSet.getDouble("AverageSalary");
                
                // Log the results
                logger.info("Department ID: {}", departmentID);
                logger.info("Department Name: {}", departmentName);
                logger.info("Average Salary: {}", averageSalary);
                logger.info("-----------------------------");
                rowsReturned++;
            }
            
            
        } catch (SQLException e) {
            logger.error("SQLException occurred.", e);
        } finally {
            try {
                resultSet.close();
                callableStatement.close();
                connection.close();
            } catch (SQLException e) {
                logger.error("Error closing resources", e);
            }
        }
    }
}
