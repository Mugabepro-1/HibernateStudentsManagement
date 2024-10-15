package people;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


public class CsvReader {
    private static final String url = "jdbc:postgresql://localhost:5432/students";
    private static final String user = "postgres";
    private static final String password = "mupro";


    public static void main(String[] args){
        Connection connection = null;
        String sql = "INSERT INTO student (firstName, lastName, dateOfBirth, school, combination, level) VALUES(?,?,?,?,?,?)";
        System.out.print("Enter file path: ");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.next();

        try(CSVReader csvReaderBuilder = new CSVReaderBuilder(new FileReader(filePath)).withSkipLines(1).build();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            connection = DriverManager.getConnection(url, user, password);
            String[] nextLine;
            while ((nextLine = csvReaderBuilder.readNext()) != null){
                String firstName = nextLine[0];
                String lastName = nextLine[1];
                String dateOfBirth = nextLine[2];
                String school = nextLine[3];
                String combination = nextLine[4];
                String level = nextLine[5];

                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, dateOfBirth);
                preparedStatement.setString(4, school);
                preparedStatement.setString(5, combination);
                preparedStatement.setString(6, level);
                preparedStatement.executeUpdate();
            }
            csvReaderBuilder.close();
            System.out.println("Your file's data was recorded successfully!!");
        } catch (SQLException e) {
            System.out.println("There was an sql error" + e.getMessage());
        }catch (FileNotFoundException e) {
            System.out.println("The file you are looking for may not be found" + e.getMessage());
        } catch (CsvValidationException e) {
            System.out.println("Data not valid" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Invalid input" + e.getMessage());
        }
    }
}