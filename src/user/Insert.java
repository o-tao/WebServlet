package user;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.Utils;

@WebServlet("/Insert")
public class Insert extends HttpServlet {
	
	private final String page = "user/Insert.jsp";
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Insert post 접속");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		System.out.println("name: " + name + "\n" + "email: " + email + "\n" + "pwd: " + pwd + "\n" + "gender: " + gender);
		
		request.setAttribute("name", name);
		request.setAttribute("email", email);
		request.setAttribute("pwd", pwd);
		request.setAttribute("gender", gender);
		
		Utils.print(request, response, page);
		System.out.println("post");
		
		  Connection conn=null;

		  try{
			 String jdbcUrl = "jdbc:mariadb://localhost:23306/edu";
		     String dbId = "root"; // 설정된 id
		     String dbPass = "1234"; // 설정된 password
			
			 Class.forName("org.mariadb.jdbc.Driver");
			 conn = DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
		  }catch(Exception e){ 
			 e.printStackTrace();
		  }
	}
}
