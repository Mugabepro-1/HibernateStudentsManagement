//package people;
//
//import com.opencsv.CSVReader;
//
//import java.io.FileReader;
//import java.sql.PreparedStatement;
//
//public class ReadCsv {
//    try {
//                        String CSVFilePath = "/home/humura/Documents/DB_Interaction--File_handle/src/ReadFile.csv";
//                        String insertQuery = "INSE6gyggRT INTO student(firstName, lastName, age, school, combination, level) VALUES (?, ?, ?, ?, ?, ?)";
//
//                        CSVReader reader = new CSVReader(new FileReader(CSVFilePath));
//                        PreparedStatement statement = conn.prepareStatement(insertQuery);
//                        String[] nextLine;
//
//                        while ((nextLine = reader.readNext()) != null) {
//
//                            if (nextLine.length < 6) {
//                                System.out.println("Skipping malformed CSV line: " + Arrays.toString(nextLine));
//                                continue;
//                            }
//
//                            String firstName = nextLine[0].trim();
//                            String lastName = nextLine[1].trim();
//                            String dob = nextLine[2].trim();
//                            String school = nextLine[3].trim();
//                            String combination = nextLine[4].trim();
//                            String levelStr = nextLine[5].trim();
//
//                            int age;
//                            try {
//                                age = getAge(dob);
//                            } catch (Exception e) {
//                                System.out.println("Invalid date format for student: " + firstName + " " + lastName + ", skipping...");
//                                continue;
//                            }
//
//                            int level;
//                            try {
//                                level = Integer.parseInt(levelStr);
//                            } catch (NumberFormatException e) {
//                                System.out.println("Invalid level for student: " + firstName + " " + lastName + ", skipping...");
//                                continue;
//                            }
//
//                            statement.setString(1, firstName);
//                            statement.setString(2, lastName);
//                            statement.setInt(3, age);
//                            statement.setString(4, school);
//                            statement.setString(5, combination);
//                            statement.setInt(6, level);
//
//                            statement.addBatch();
//                        }
//
//                        statement.executeBatch();
//                        System.out.println("Data from the CSV file has been added successfully");
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//}
