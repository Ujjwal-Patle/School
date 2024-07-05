package modification;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class RegStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
 
        StudentBean student = new StudentBean();
        student.setRegistrationNumber(request.getParameter("regNo"));
        student.setAdharCardNumber(request.getParameter("adharNo"));
        student.setStudentId(request.getParameter("studentId"));
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));
        student.setFatherName(request.getParameter("fatherName"));
        student.setMotherName(request.getParameter("motherName"));
        student.setReligion(request.getParameter("religion"));
        student.setCast(request.getParameter("cast"));
        student.setCastCategory(request.getParameter("castCategory"));
        student.setPlaceOfBirth(request.getParameter("placeOfBirth"));
        student.setTaluka(request.getParameter("taluka"));
        student.setDistrict(request.getParameter("district"));
        student.setState(request.getParameter("state"));
        student.setDateOfBirth(request.getParameter("dob"));
        student.setDateOfBirthWords(request.getParameter("dobWords"));
        student.setLastSchoolNameAttended(request.getParameter("lastSchool"));
        student.setLastSchoolAttendedClass(request.getParameter("lastClass"));
        student.setDateOfAdmission(request.getParameter("admissionDate"));
        student.setClassOfAdmission(request.getParameter("admissionClass"));

        try {
            int k = new RegStudentDAO(getServletContext()).insertStudent(student);
            PrintWriter pw = response.getWriter();
            if(k>0)
            {
//            	response.setContentType("text/html");
            	pw.print("<br><br><br><br><font color = blueviolet>Student registration data successfully inserted.</font>");
            	request.getRequestDispatcher("Dashboard.jsp").include(request, response);
				
            }
            else {
            	pw.print("Not registered");
            	request.getRequestDispatcher("Dashboard.jsp").include(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}