package people;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CsvReader {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the csv file: ");
        String csvFilePath = scanner.next();

        String url = "jdbc:postgresql://localhost:5432/students";
        String user = "postgres";
        String password = "mupro";

        try (Connection conn = DriverManager.getConnection(url, user, password);
        FileReader reader = new FileReader(csvFilePath);
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)){
            String sql = "INSERT INTO student(firstName, lastName, dateOfBirth, school, combination, level) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            for(CSVRecord csvRecord : csvParser){
                String firstName = csvRecord.get("firstName");
                String lastName = csvRecord.get("lastName");
                String dateOfBirth = csvRecord.get("dateOfBirth");
                String school = csvRecord.get("school");
                String combination = csvRecord.get("combination");
                String level = csvRecord.get("level");

                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, dateOfBirth);
                preparedStatement.setString(4, school);
                preparedStatement.setString(5, combination);
                preparedStatement.setString(6, level);

                preparedStatement.executeUpdate();
                System.out.println("Entered data successfully");
            }


        }catch (IOException e){
            System.out.println("Error reading the csv file: " + e.getMessage());
        }catch (SQLException e){
            System.out.println("Failed to enter data to the database: " + e.getMessage());
        }
    }
}
