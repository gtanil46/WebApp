package cardealer.login;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{

	LoginService loginService = new LoginService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/cardealer.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		
		if(loginService.isUserValid(user, password, type))
		{
			request.getSession().setAttribute("username", user);
			response.sendRedirect("/homepage");
		}
		else
		{
			request.setAttribute("alert", "Credentials do not match! Please try again");
			System.out.println("user validation failed");
			request.getRequestDispatcher("/WEB-INF/views/cardealer.jsp").forward(request, response);
		}
		
//		Enumeration<String> e = request.getParameterNames();
//		while(e.hasMoreElements())
//		{
//			System.out.println(e.nextElement());
//		}
	}
}
