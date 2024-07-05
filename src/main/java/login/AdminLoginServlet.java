package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection con;

    public void init(ServletConfig config) throws ServletException {
        ServletContext scont = config.getServletContext();
        String dbUrl = scont.getInitParameter("databaseUrl");
        String userName = scont.getInitParameter("aName");
        String password = scont.getInitParameter("password");
        String driver = scont.getInitParameter("driver");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(dbUrl, userName, password);
            System.out.println("Database connection established");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new ServletException("Database connection initialization failed", e);
        }
    }

    public void destroy() {
        try {
            
                con.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String adminName = request.getParameter("aName");
    	String password = request.getParameter("password");

        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM admin WHERE adminName = ? AND password = ?")) {
            ps.setString(1, adminName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            
            if (rs.next()) {
//            	pw.print("hello");
            	HttpSession hs = request.getSession();
//                hs.setMaxInactiveInterval();
                
                // Add logging to check session state
                System.out.println("Session ID: " + hs.getId());
                System.out.println("Session Creation Time: " + hs.getCreationTime());
                System.out.println("Session Last Accessed Time: " + hs.getLastAccessedTime());

                
                request.setAttribute("adminName", adminName);
                String encodedURL = response.encodeURL("/Dashboard.jsp");
                request.getRequestDispatcher(encodedURL).forward(request, response);
//            	 response.sendRedirect("Dashboard.jsp");
            } else {
                pw.print("<html><body>");
                pw.print("<h1>Invalid UserId And Password Combination</h1>");
                pw.print("<a href='index.html'>Home</a>");
                pw.print("</body></html>");
            }
            pw.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database query failed", e);
        }
    }
}
