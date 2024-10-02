package app.oop.exercises;

import java.sql.*;

public class DatabaseManager {

    public Connection connect() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/students";
        String user = "postgres";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
    public void insertStudent(Student student){
        String sql = "INSERT INTO students (firstName, lastName, dateOfBirth, school, combination, level) VALUES(?,?,?,?,?,?)";

        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setDate(3, new Date(student.getDateOfBirth().getTime()));
            pstmt.setString(4, student.getSchool());
            pstmt.setString(5, student.getCombination());
            pstmt.setString(6, student.getLevel());
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
