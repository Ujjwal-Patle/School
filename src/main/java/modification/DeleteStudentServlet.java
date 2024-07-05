package modification;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int k = new DeleteStudentDAO(getServletContext()).deleteStudent(request);
			PrintWriter pw = response.getWriter();

			if (k > 0) {
				response.setContentType("text/html");
				request.getRequestDispatcher("Dashboard.jsp").include(request, response);
				pw.print("<font color =red><br><br><br><br>Deletetion sucessfull</font>");
			} else {
				pw.print("<br><br><br><br><font color =red>NO such student exists</font>");
				request.getRequestDispatcher("Dashboard.jsp").include(request, response);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
