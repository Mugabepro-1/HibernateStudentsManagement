package people;
import java.sql.*;
import people.Student;

public class ReadDatabase {
    private static final String url = "jdbc:postgresql://localhost:5432/students";
    private static final String user = "postgres";
    private static final String password = "mupro";

    Connection conn;
    public static void main(String[] args) throws SQLException {
        ReadDatabase readDatabase = new ReadDatabase();
        readDatabase.getAllStudents();
    }

    {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database" + e.getMessage());
        }
    }

    public void getAllStudents() throws SQLException{
        String sql = "SELECT * FROM student";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(! resultSet.isBeforeFirst()){
            System.out.println("Failed to get students from the database");
        }else{
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                String school = resultSet.getString("school");
                String combination = resultSet.getString("combination");
                String level = resultSet.getString("level");

                Student student = new Student(id, firstName, lastName,dateOfBirth, school, combination, level);
                System.out.println(student.toString());
            }
        }

    }
}
