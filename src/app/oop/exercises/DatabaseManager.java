package app.oop.exercises;

import java.sql.*;

public class DatabaseManager {
    private final String url = "jdbc:postgresql://localhost:5432/your_database";
    private final String user = "your_username";
    private final String password = "your_password";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    public void insertStudent(Student student){
        String sql = "INSERT INTO students (firstName, lastName, dateofbirth) VALUES(?,?,?)";

        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setDate(3, new Date(student.getAge().getTime()));
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
