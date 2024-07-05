package modification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

public class DeleteStudentDAO 
{
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private String jdbcDriver;

    public DeleteStudentDAO(ServletContext context) {
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

	public int deleteStudent(HttpServletRequest req) {
		int k = 0;		
        try {
        	Connection con = getConnection();
        	String regNo = req.getParameter("regNo");
            if (regNo == null || regNo.isEmpty()) {
                throw new IllegalArgumentException("Registration number is required");
            }

            StringBuilder query = new StringBuilder("DELETE FROM students ");
            List<String> parameters = new ArrayList<>();
            
            query.append(" WHERE RegistrationNumber = ?");
            parameters.add(regNo);
            
            String adharNo = req.getParameter("adharNo");
            if (adharNo != null && !adharNo.isEmpty()) {
                query.append("AND AdharCardNumber = ?");
                parameters.add(adharNo);
            }
        	
//        	PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE AdharCardNumber = ? AND RegistrationNumber = ?");
//			ps.setString(1, req.getParameter("adharNo"));
//			ps.setString(2, req.getParameter("regNo"));
            
            PreparedStatement ps = con.prepareStatement(query.toString());

            for (int i = 0; i < parameters.size(); i++) {
                ps.setString(i + 1, parameters.get(i));
            }
			k = ps.executeUpdate();
        	
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
        return k;
	}

}
