package cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie1")
public class Cookie1 extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mail=req.getParameter("email");
		String pass=req.getParameter("password");
			
		Cookie c1=new Cookie("K1", mail);
		Cookie c2=new Cookie("K2", pass);
		
		resp.addCookie(c1);
		resp.addCookie(c2);
		req.getRequestDispatcher("cookie2").forward(req, resp);
		
		
	}
	
}
