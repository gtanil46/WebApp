package cardealer.inventory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/homepage")
public class ListCarServlet extends HttpServlet{
	
	private ListCarService listCarService = new ListCarService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inventory - doGet");
		listCarService.getCars();
		request.setAttribute("cars", listCarService.retrieveCars());
		request.getRequestDispatcher("/WEB-INF/views/homepage.jsp").forward(
				request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inventory - doPost");
	}
}
