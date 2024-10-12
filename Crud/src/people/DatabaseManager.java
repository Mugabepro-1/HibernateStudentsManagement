package people;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:postgresql://localhost:5432/students";
    private static final String USER = "postgres";
    private static final String PASSWORD = "mupro";

    public DatabaseManager() {
    }


    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void insertStudent(Student student) {
        String sql = "INSERT INTO student (firstName, lastName, dateOfBirth, school, combination, level) VALUES(?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            // Set parameters
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setDate(3, new Date(student.getDateOfBirth().getTime()));
            preparedStatement.setString(4, student.getSchool());
            preparedStatement.setString(5, student.getCombination());
            preparedStatement.setString(6, student.getLevel());

            // Execute the update
            preparedStatement.executeUpdate();
            System.out.println("Entered student data successfully!!");

        } catch (SQLException e) {
            System.out.println("Error while inserting data: " + e.getMessage());
        }
    }
}
