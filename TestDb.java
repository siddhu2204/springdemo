package com.luv2code.sprindB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDb
 */
@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname="SYSTEM";
		String pwd = "admin";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		PrintWriter out = response.getWriter();
		
		out.println("helloo");
		
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, uname, pwd);
			
			out.println("Success!!!!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
