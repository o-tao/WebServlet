package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.Utils;

@WebServlet("/List")
public class List extends HttpServlet {
	
	private final String page = "user/List.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utils.print(request, response, page);
		System.out.println("get");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	}

}
