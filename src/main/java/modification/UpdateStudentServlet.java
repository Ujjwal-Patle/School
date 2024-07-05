package modification;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int k = new UpdateStudentDAO(getServletContext()).updateStudent(request);
			PrintWriter pw = response.getWriter();
			if (k > 0) {
				response.setContentType("text/html");
            	pw.print("<br><br><br><br><font color = blueviolet>Student details updated successfully.</font>");
            	request.getRequestDispatcher("Dashboard.jsp").include(request, response);
//				pw.print("Student details updated successfully.");
//				request.getRequestDispatcher("Dashboard.jsp").include(request, response);
			} else {
				pw.println("Failed to update student details.");
				request.getRequestDispatcher("Dashboard.jsp").include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
