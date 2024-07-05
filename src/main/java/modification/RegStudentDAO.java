package modification;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;

public class RegStudentDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private String jdbcDriver;

    public RegStudentDAO(ServletContext context) {
        this.jdbcURL = context.getInitParameter("databaseUrl");
        this.jdbcUsername = context.getInitParameter("aName");
        this.jdbcPassword = context.getInitParameter("password");
        this.jdbcDriver = context.getInitParameter("driver");
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    int k=0;
    public int insertStudent(StudentBean student) throws SQLException {
        String sql = "INSERT INTO Students (RegistrationNumber, AdharCardNumber, StudentId, StudentFirstName, " +
                     "StudentLastName, StudentFatherName, StudentMotherName, Religion, Cast, CastCategory, " +
                     "PlaceOfBirth, Taluka, District, State, DateOfBirth, DateOfBirthWords, LastSchoolNameAttended, " +
                     "LastSchoolAttendedClass, DateOfAdmission, ClassOfAdmission) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";
        try 
        {
        	Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
        	ps.setString(1, student.getRegistrationNumber());
            ps.setString(2, student.getAdharCardNumber());
            ps.setString(3, student.getStudentId());
            ps.setString(4, student.getFirstName());
            ps.setString(5, student.getLastName());
            ps.setString(6, student.getFatherName());
            ps.setString(7, student.getMotherName());
            ps.setString(8, student.getReligion());
            ps.setString(9, student.getCast());
            ps.setString(10, student.getCastCategory());
            ps.setString(11, student.getPlaceOfBirth());
            ps.setString(12, student.getTaluka());
            ps.setString(13, student.getDistrict());
            ps.setString(14, student.getState());
            ps.setString(15, student.getDateOfBirth());
            ps.setString(16, student.getDateOfBirthWords());
            ps.setString(17, student.getLastSchoolNameAttended());
            ps.setString(18, student.getLastSchoolAttendedClass());
            ps.setString(19, student.getDateOfAdmission());
            ps.setString(20, student.getClassOfAdmission());

            k=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return k;
    }

    
}
