package sessiontracking;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionone")
public class SessionOne extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		if (email.equals("abc@gmail.com")&& password.equals("abc123")) {
			HttpSession sess=req.getSession();
			sess.setAttribute("k1", email);
			resp.sendRedirect("sessiontwo");
		} else {
			resp.getWriter().print("Invalid Credntials");
		}
		
	}

}
