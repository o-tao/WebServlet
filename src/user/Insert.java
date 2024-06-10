package user;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.servlet.Utils;

import db.DbConn;
import db.DbTable;

@WebServlet("/Insert")
public class Insert extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Insert post 접속");
		
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String pwd = request.getParameter("pwd");
//		String gender = request.getParameter("gender");
		
		DbTable data = new DbTable();
		data.setName(request.getParameter("name"));
		data.setEmail(request.getParameter("email"));
		data.setPwd(request.getParameter("pwd"));
		data.setGender(request.getParameter("gender"));
		
//		Map<String, String> userMap = new HashMap<String, String>();
//		userMap.put("name", data.getName());
//		userMap.put("email", data.getEmail());
//		userMap.put("pwd", data.getPwd());
//		userMap.put("gender", data.getGender());		
		
		SqlSession sql = DbConn.getFac().openSession();
		int status = sql.insert("user.add", data);
		sql.commit();
		System.out.println("상태값: " + status);
		
//		System.out.println("name: " + data.getName() + "\n" + "email: " + data.getEmail() + "\n" + "pwd: " + data.getPwd() + "\n" + "gender: " + data.getGender());
		
		
		
	}
}
