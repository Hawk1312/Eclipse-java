package a20;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jaymin","root","admin");
			
			PreparedStatement pst = con.prepareStatement("INSERT INTO users(fname,lname,uname,upass,umail) VALUES(?,?,?,?,?)");
			pst.setString(1,request.getParameter("fname"));
			pst.setString(2,request.getParameter("lname"));
			pst.setString(3,request.getParameter("uname"));
			pst.setString(4,request.getParameter("upass"));
			pst.setString(5,request.getParameter("umail"));
			
			pst.executeUpdate();
			
			out.println("<html><body>");
			out.println("<h3>Signup Successful</h3>");
			out.println("<a href='login.jsp'>Back to Login</a>");
			out.println("</body></html>");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
