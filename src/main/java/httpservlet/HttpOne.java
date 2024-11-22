package httpservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/httpone")
public class HttpOne extends HttpServlet
{
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long contact = Long.parseLong(req.getParameter("con"));
		String mail=req.getParameter("mail");
		resp.getWriter().print(contact+"   "+mail);
		
		
		
	}
	
}
