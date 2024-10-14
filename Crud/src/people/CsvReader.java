package people;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CsvReader {
    Scanner scanner = new Scanner(System.in);
    String filePath = scanner.next();
    private static final String URL = "jdbc:postgresql://localhost:5432/students";
    private static final String USER = "postgres";
    private static final String PASSWORD = "mupro";

    public Connection connect() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD );
    }
    public void insertDataFromCsv(String filePath){
        String sql = "INSERT INTO student(firstName, lastName, dateOfBirth, school, combination, level) VALUES(?, ?, ?, ?, ?, ?)";
    }

}