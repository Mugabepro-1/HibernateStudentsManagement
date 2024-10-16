package people;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CsvImporter {

    public void importCSVToDatabase(String csvFilePath) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/students"; // Update with your DB details
        String username = "postgres";
        String password = "mupro";

        String insertSQL = "INSERT INTO student (firstName, lastName, dateOfBirth, school, combination, level) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
             CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {

            String[] line;
            csvReader.readNext(); // Skip header
            while ((line = csvReader.readNext()) != null) {
                preparedStatement.setString(1, line[0].trim()); // firstName
                preparedStatement.setString(2, line[1].trim()); // lastName
                preparedStatement.setDate(3, java.sql.Date.valueOf(line[2].trim())); // dateOfBirth (format: YYYY-MM-DD)
                preparedStatement.setString(4, line[3].trim()); // school
                preparedStatement.setString(5, line[4].trim()); // combination
                preparedStatement.setString(6, line[5].trim()); // level
                preparedStatement.executeUpdate();
            }

            System.out.println("Data successfully imported into the database.");
        } catch (Exception e) {
            System.out.println("Data was not entered successfully: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the CSV file path:");
        String csvFilePath = scanner.nextLine();  // Ask for the file path at runtime

        new CsvImporter().importCSVToDatabase(csvFilePath);  // Pass the input file path to importCSVToDatabase
    }
}
