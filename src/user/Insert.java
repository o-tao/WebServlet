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
		
		
//		Map<String, String> userMap = new HashMap<String, String>();
//		userMap.put("name", name);
//		userMap.put("email", email);
//		userMap.put("pwd", pwd);
//		userMap.put("gender", gender);
		
		DbTable data = new DbTable();
		data.setName(request.getParameter("name"));
		data.setEmail(request.getParameter("email"));
		data.setPwd(request.getParameter("pwd"));
		data.setGender(request.getParameter("gender"));
		
		SqlSession sql = DbConn.getFac().openSession();
		int status = sql.insert("user.add", data);
//		System.out.println("상태값: " + status);
		if(status == 1) {
			int no = sql.selectOne("user.getNo");
//			System.out.println("no= " + no);
			sql.commit();
			
//			response.sendRedirect("Select?no=" + no); // get방식 호출: 생성된 사용자 번호 전달
			response.sendRedirect("List");
		
		} else {
			sql.rollback();
			
		}
		
		System.out.println("name: " + data.getName() + "\n" + "email: " + data.getEmail() + "\n" + "pwd: " + data.getPwd() + "\n" + "gender: " + data.getGender());
		
				
		
	}
}
