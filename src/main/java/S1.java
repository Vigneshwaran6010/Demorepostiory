import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/s1")
public class S1 extends GenericServlet

{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		long contact=Long.parseLong(req.getParameter("con"));
		req.setAttribute("num", contact);
		String email=req.getParameter("mail");
		req.setAttribute("mail", email);
		RequestDispatcher rd=req.getRequestDispatcher("s2");
		rd.forward(req, res);
		
		
		
	}

}
