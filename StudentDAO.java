import java.sql.*;
import java.util.*;

public class StudentDAO {

    public void addStudent(Student s) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO students (name,email,course) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.executeUpdate();
            System.out.println("Student Added Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM students";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email") + " | " +
                        rs.getString("course")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
              }
