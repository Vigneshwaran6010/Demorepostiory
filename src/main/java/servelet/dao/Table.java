package servelet.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/table")
public class Table extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("u_id"));
		String name=req.getParameter("u_name");
		String email=req.getParameter("u_email");
		long contact= Long.parseLong(req.getParameter("u_contact"));
		
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school?user=root&password=root");
				PreparedStatement pst=con.prepareStatement("insert into student values(?,?,?,?)");
				pst.setInt(1, id);
				pst.setString(2, name);
				pst.setString(3, email);
				pst.setLong(4, contact);
				int a=pst.executeUpdate();
				con.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
	}

}
