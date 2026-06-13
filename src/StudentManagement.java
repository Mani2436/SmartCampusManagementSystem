import java.sql.*;
import java.util.Scanner;

public class StudentManagement {

    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Year: ");
            int year = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            String query = "INSERT INTO students(student_id, student_name, course, year, email) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, course);
            pst.setInt(4, year);
            pst.setString(5, email);

            pst.executeUpdate();

            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\n===== STUDENTS LIST =====");
            while (rs.next()) {
                System.out.println("Student ID: " + rs.getInt("student_id"));
                System.out.println("Name: " + rs.getString("student_name"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("Year: " + rs.getInt("year"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("------------------------");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteStudent() {
        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Student ID to Delete: ");
            int id = sc.nextInt();
            sc.nextLine();

            String query = "DELETE FROM students WHERE student_id = ?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully");
            } else {
                System.out.println("Student ID not found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
