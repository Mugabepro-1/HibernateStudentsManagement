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

    public static void main(String[] args) {
        // Prompt the user to enter the file path at runtime
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the CSV file: ");
        String csvFilePath = scanner.next();

        // Database connection parameters
        String url = "jdbc:postgresql://localhost:5432/students";
        String user = "postgres";
        String password = "mupro";


        try (Connection conn = DriverManager.getConnection(url, user, password);
             FileReader fileReader = new FileReader(csvFilePath);
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT)) {

            String sql = "INSERT INTO student (firstName, lastName, dateOfBirth, school, combination, level) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            // Step 3: Iterate through each record in the CSV file and insert into the database
            for (CSVRecord record : csvParser) {
                String firstName = record.get("firstName");
                String lastName = record.get("lastName");
                String dateOfBirth = record.get("dateOfBirth");
                String school = record.get("school");
                String combination = record.get("combination");
                String level = record.get("level");

                // Set parameters for the prepared statement
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, dateOfBirth);
                preparedStatement.setString(4, school);
                preparedStatement.setString(5, combination);
                preparedStatement.setString(6, level);

                preparedStatement.executeUpdate();
            }

            System.out.println("Data inserted successfully from CSV to database!");

        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error connecting to the database or inserting data: " + e.getMessage());
        }
    }
}
