package sessiontracking;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessiontwo")
public class Sessiontwo extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess=req.getSession();
		String mail=(String)sess.getAttribute("k1");
		if (mail!=null) {
			resp.getWriter().print("Valid user");
			
		} else {
			resp.getWriter().print("Invalid User");
			
			

		}
	}

}
