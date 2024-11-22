package servelet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import servelet.dto.Employee;

public class Database 
{

	public int insert(Employee emp) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school?user=root&password=root");
		PreparedStatement pst=con.prepareStatement("insert into employee values(?,?,?)");
		pst.setInt(1, emp.getId());
		pst.setString(2, emp.getName());
		pst.setString(3, emp.getEmail());
		return pst.executeUpdate();
		
	}
	
	public int delete (int id) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school?user=root&password=root");
		PreparedStatement pst=con.prepareStatement("delete from employee where id=?");
		pst.setInt(1, id);
		return pst.executeUpdate();
	}
	public List<Employee> getAll() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school?user=root&password=root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select*from employee");
		List<Employee> li=new ArrayList<Employee>();
		while(rs.next())
		{
			Employee  e=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3));
			li.add(e);	
		}
		return li;
	}
	public ResultSet findbyId(int id) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school?user=root&password=root");
		PreparedStatement pst=con.prepareStatement("select * from employee where id=?");
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		rs.next();
		
		int Id=rs.getInt(1);
		String Name=rs.getString(2);
		String Email=rs.getString(3);
		return rs;
	}
	
	
}
