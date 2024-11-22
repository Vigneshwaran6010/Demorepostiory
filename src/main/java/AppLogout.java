import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/logout")
public class AppLogout implements Servlet
{

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.getWriter().print("Logout Success");
		
	}

	@Override
	public String getServletInfo() {
		
		return null;
	}

	@Override
	public void destroy() {
		
		
	}
	
	
	

}
