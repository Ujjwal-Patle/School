package modification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

public class UpdateStudentDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private String jdbcDriver;

    public UpdateStudentDAO(ServletContext context) {
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

	int k = 0;
    public int updateStudent(HttpServletRequest req) {
        try {
            Connection con = getConnection();
            
            
            if (con != null) {
                String regNo = req.getParameter("regNo");
                if (regNo == null || regNo.isEmpty()) {
                    throw new IllegalArgumentException("Registration number is required");
                }

                StringBuilder query = new StringBuilder("UPDATE Students SET ");
                List<String> parameters = new ArrayList<>();

                String adharNo = req.getParameter("adharNo");
                if (adharNo != null && !adharNo.isEmpty()) {
                    query.append("AdharCardNumber = ?, ");
                    parameters.add(adharNo);
                }

                String studentIdStr = req.getParameter("studentId");
                if (studentIdStr != null && !studentIdStr.isEmpty()) {
                    query.append("StudentId = ?, ");
                    parameters.add(studentIdStr);
                }

                // Add other fields similarly...
                String firstName = req.getParameter("firstName");
                if (firstName != null && !firstName.isEmpty()) {
                    query.append("StudentFirstName = ?, ");
                    parameters.add(firstName);
                }

                String lastName = req.getParameter("lastName");
                if (lastName != null && !lastName.isEmpty()) {
                    query.append("StudentLastName = ?, ");
                    parameters.add(lastName);
                }

                String fatherName = req.getParameter("fatherName");
                if (fatherName != null && !fatherName.isEmpty()) {
                    query.append("StudentFatherName = ?, ");
                    parameters.add(fatherName);
                }

                String motherName = req.getParameter("motherName");
                if (motherName != null && !motherName.isEmpty()) {
                    query.append("StudentMotherName = ?, ");
                    parameters.add(motherName);
                }

                String religion = req.getParameter("religion");
                if (religion != null && !religion.isEmpty()) {
                    query.append("Religion = ?, ");
                    parameters.add(religion);
                }

                String cast = req.getParameter("cast");
                if (cast != null && !cast.isEmpty()) {
                    query.append("Cast = ?, ");
                    parameters.add(cast);
                }

                String castCategory = req.getParameter("castCategory");
                if (castCategory != null && !castCategory.isEmpty()) {
                    query.append("CastCategory = ?, ");
                    parameters.add(castCategory);
                }

                String placeOfBirth = req.getParameter("placeOfBirth");
                if (placeOfBirth != null && !placeOfBirth.isEmpty()) {
                    query.append("PlaceOfBirth = ?, ");
                    parameters.add(placeOfBirth);
                }

                String taluka = req.getParameter("taluka");
                if (taluka != null && !taluka.isEmpty()) {
                    query.append("Taluka = ?, ");
                    parameters.add(taluka);
                }

                String district = req.getParameter("district");
                if (district != null && !district.isEmpty()) {
                    query.append("District = ?, ");
                    parameters.add(district);
                }

                String state = req.getParameter("state");
                if (state != null && !state.isEmpty()) {
                    query.append("State = ?, ");
                    parameters.add(state);
                }

                String dob = req.getParameter("dob");
                if (dob != null && !dob.isEmpty()) {
                    query.append("DateOfBirth = TO_DATE(?, 'YYYY-MM-DD'), ");
                    parameters.add(dob);
                }

                String dobWords = req.getParameter("dobWords");
                if (dobWords != null && !dobWords.isEmpty()) {
                    query.append("DateOfBirthWords = ?, ");
                    parameters.add(dobWords);
                }

                String lastSchool = req.getParameter("lastSchool");
                if (lastSchool != null && !lastSchool.isEmpty()) {
                    query.append("LastSchoolNameAttended = ?, ");
                    parameters.add(lastSchool);
                }

                String lastClass = req.getParameter("lastClass");
                if (lastClass != null && !lastClass.isEmpty()) {
                    query.append("LastSchoolAttendedClass = ?, ");
                    parameters.add(lastClass);
                }

                String admissionDate = req.getParameter("admissionDate");
                if (admissionDate != null && !admissionDate.isEmpty()) {
                    query.append("DateOfAdmission = TO_DATE(?, 'YYYY-MM-DD'), ");
                    parameters.add(admissionDate);
                }

                String admissionClass = req.getParameter("admissionClass");
                if (admissionClass != null && !admissionClass.isEmpty()) {
                    query.append("ClassOfAdmission = ?, ");
                    parameters.add(admissionClass);
                }

                // Remove the last comma and space
                if (parameters.size() > 0) {
                    query.setLength(query.length() - 2);
                }

                query.append(" WHERE RegistrationNumber = ?");
                parameters.add(regNo);

                PreparedStatement ps = con.prepareStatement(query.toString());

                for (int i = 0; i < parameters.size(); i++) {
                    ps.setString(i + 1, parameters.get(i));
                }

                k = ps.executeUpdate();

            }
            
            
//            PreparedStatement ps = con.prepareStatement("UPDATE students SET AdharCardNumber=?, StudentId=?, StudentFirstName=?,StudentLastName=?, StudentFatherName=?, StudentMotherName=?, Religion=?, Cast=?, CastCategory=?,PlaceOfBirth=?, Taluka=?, District=?, State=?, DateOfBirth=?, DateOfBirthWords=?, LastSchoolNameAttended=?,LastSchoolAttendedClass=?, DateOfAdmission=?, ClassOfAdmission=? where RegistrationNumber=?");
//
//            
//            ps.setString(1, req.getParameter("adharNo"));
//            ps.setString(2, req.getParameter("studentId"));
//            ps.setString(3, req.getParameter("firstName"));
//            ps.setString(4,req.getParameter("lastName"));
//            ps.setString(5, req.getParameter("fatherName"));
//            ps.setString(6, req.getParameter("motherName"));
//            ps.setString(7, req.getParameter("religion"));
//            ps.setString(8, req.getParameter("cast"));
//            ps.setString(9, req.getParameter("castCategory"));
//            ps.setString(10, req.getParameter("placeOfBirth"));
//            ps.setString(11, req.getParameter("taluka"));
//            ps.setString(12, req.getParameter("district"));
//            ps.setString(13, req.getParameter("state"));
//            ps.setString(14, req.getParameter("dob"));
//            ps.setString(15, req.getParameter("dobWords"));
//            ps.setString(16, req.getParameter("lastSchool"));
//            ps.setString(17, req.getParameter("lastClass"));
//            ps.setString(18, req.getParameter("admissionDate"));
//            ps.setString(19, req.getParameter("admissionClass"));
//            ps.setString(20, req.getParameter("regNo"));
//
//                k = ps.executeUpdate();
//            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return k;
    }
}

