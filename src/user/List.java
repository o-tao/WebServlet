package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import org.apache.ibatis.session.SqlSession;

import com.servlet.Utils;

import db.DbConn;
import db.DbTable;

@WebServlet("/List")
public class List extends HttpServlet {
	
	private final String page = "user/List.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("List get 접속");
		
		SqlSession sql = DbConn.getFac().openSession();
		java.util.List<DbTable> list = sql.selectList("user.findAll");
		
		request.setAttribute("list", list);
		
		Utils.print(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utils.print(request, response, page);
	}

}
