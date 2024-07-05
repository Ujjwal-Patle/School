package modification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

public class CertificateDAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private String jdbcDriver;

	public CertificateDAO(ServletContext context) {
		this.jdbcURL = context.getInitParameter("databaseUrl");
		this.jdbcUsername = context.getInitParameter("aName");
		this.jdbcPassword = context.getInitParameter("password");
		this.jdbcDriver = context.getInitParameter("driver");
	}

	private Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	public StudentBean std = null;
	public ArrayList<StudentBean> getUserDetails(HttpServletRequest req) {
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();
		try {
System.out.println(req.getParameter("registerNo"));
			Connection con = getConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE REGISTRATIONNUMBER = ?");
			ps.setString(1,req.getParameter("registerNo"));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				std = new StudentBean();
				std.setRegistrationNumber(rs.getString(1));
                std.setAdharCardNumber(rs.getString(2));
                std.setStudentId(rs.getString(3));
                std.setFirstName(rs.getString(4));
                std.setLastName(rs.getString(5));
                std.setFatherName(rs.getString(6));
                std.setMotherName(rs.getString(7));
                std.setReligion(rs.getString(8));
                std.setCast(rs.getString(9));
                std.setCastCategory(rs.getString(10));
                std.setPlaceOfBirth(rs.getString(11));
                std.setTaluka(rs.getString(12));
                std.setDistrict(rs.getString(13));
                std.setState(rs.getString(14));
                std.setDateOfBirth(rs.getString(15));
                std.setDateOfBirthWords(rs.getString(16));
                std.setLastSchoolNameAttended(rs.getString(17));
                std.setLastSchoolAttendedClass(rs.getString(18));
                std.setDateOfAdmission(rs.getString(19));
                std.setClassOfAdmission(rs.getString(20));
                list.add(std);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
