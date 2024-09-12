package a20;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class resetPassword
 */
@WebServlet("/resetPassword")
public class resetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resetPassword() {
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
			
			
			PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE uname=? AND upass=?");
			pst.setString(1,request.getParameter("uname"));
			pst.setString(2,request.getParameter("upassold"));
			
			ResultSet rs = pst.executeQuery();
			out.println("<html><body>");
			if(rs.next()) {
				PreparedStatement pst2 = con.prepareStatement("UPDATE users SET upass=? WHERE uname=? AND upass=?");
				pst2.setString(1,request.getParameter("upassnew"));
				pst2.setString(2,request.getParameter("uname"));
				pst2.setString(3,request.getParameter("upassold"));
				
				pst2.executeUpdate();
				out.println("<h3>Password Reset Successful!</h3>");
				out.println("<a href='login.jsp'>Back To Login</a><br><br>");
			}
			else {
				out.println("<h3>Username Or Password Incorrect</h3>");
				out.println("<a href='resetPassword.jsp'>Back to Reset</a><br><br>");
				out.println("<a href='login.jsp'>Login Again</a><br><br>");
				out.println("<a href='signup.jsp'>Create New account</a>");
			}
			out.println("</body></html>");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
