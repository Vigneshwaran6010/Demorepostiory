import java.sql.SQLException;

import servelet.dao.Database;
import servelet.dto.Employee;

public class MainObject {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Employee emp=new Employee(1,"ABC","ABC@gmail.com");
		Database d=new Database();
		d.insert(emp);
//		d.getAll();
//		d.delete(1);
		
	}

}
