package modification;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Certificate")
public class CertificateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String button = request.getParameter("button");
		System.out.println(button);
		String regNo = request.getParameter("registerNo");
		System.out.println(regNo);

		if (button == null) {
			response.getWriter().println("Button parameter is null");
			return;
		}

		CertificateDAO certificateDAO = new CertificateDAO(getServletContext());
		ArrayList<StudentBean> studentDetails = certificateDAO.getUserDetails(request);

		if (!studentDetails.isEmpty()) 
		{
			StudentBean student = studentDetails.get(0); // Assuming you only have one student per registration number
			request.setAttribute("registerNo", student.getRegistrationNumber());
//			String adhar = student.getAdharCardNumber();
//			String formatAdhar = formatAdharCard(adhar);
			
			request.setAttribute("name", student.getFirstName()+student.getLastName());
			request.setAttribute("adharCardNo", student.getAdharCardNumber());
			request.setAttribute("studentId", student.getStudentId());
			request.setAttribute("studentFullName", student.getFirstName() + " (Father's Name) "+ student.getFatherName() + " (Surname) " + student.getLastName());
			request.setAttribute("motherName", student.getMotherName());
			request.setAttribute("religion", student.getReligion());
			request.setAttribute("caste", student.getCast());
			request.setAttribute("casteCategory", student.getCastCategory());
			request.setAttribute("placeOfBirth", student.getPlaceOfBirth());
			request.setAttribute("taluka", student.getTaluka());
			request.setAttribute("district", student.getDistrict());
			request.setAttribute("state", student.getState());
			 String dob = student.getDateOfBirth();
	            String formattedDob = formatDate(dob);
	            request.setAttribute("dobFigures", formattedDob);
//			request.setAttribute("dobFigures", student.getDateOfBirth());
			request.setAttribute("dobWords", student.getDateOfBirthWords());
			request.setAttribute("lastSchoolName", student.getLastSchoolNameAttended());
			request.setAttribute("lastSchoolClass", student.getLastSchoolAttendedClass());
			request.setAttribute("dateOfAdmission", student.getDateOfAdmission());
			request.setAttribute("classOfAdmission", student.getClassOfAdmission());

			if ("Bonafide".equals(button)) 
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/displayBonafide.jsp");
				dispatcher.forward(request, response);
			} else if ("Leaving".equals(button)) 
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/displayLeaving.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			// Handle case where no student details are found
			request.setAttribute("error", "No student found with the provided registration number.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/errorPage.jsp");
			dispatcher.forward(request, response);
		}
	}

//	private String formatAdharCard(String adhar) {
//		if (adhar != null && adhar.length() == 12) {
//			return adhar.replaceAll("(\\d{4})(\\d{4})(\\d{4})", "$1 $2 $3");
//		} else {
//			// Handle the case where the AdharCardNumber is not exactly 12 digits
//			return adhar;
//
//		}
//	}
	private String formatDate(String dateStr) {
        if (dateStr == null) {
            return "";
        }
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = originalFormat.parse(dateStr);
            return targetFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return dateStr; // Return original if parsing fails
        }
    }
}
