package cardealer.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet{
	
	RegisterService registerService = new RegisterService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("regsiter servlet -- doGet");
		request.getRequestDispatcher("/WEB-INF/views/cardealer.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("regsiter servlet -- doPost");
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		registerService.registerUser(user, password, type);
		request.setAttribute("alert", "User registered! Please login");
		request.getRequestDispatcher("/WEB-INF/views/cardealer.jsp").forward(request, response);
	}
}
