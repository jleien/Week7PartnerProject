package Controller;
/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Mar 2, 2022
**/
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.LegoSet;

@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		SetHelper dbo = new SetHelper();
		String action = request.getParameter("doThisToSet");

		String path = "/viewAllSetsServlet";

		if (action.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("ID"));
				LegoSet setToDelete = dbo.searchForLegoSetById(tempId);
				dbo.deleteLegoSet(setToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an set");
			}

		} else if (action.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("ID"));
				LegoSet setToEdit = dbo.searchForLegoSetById(tempId);
				request.setAttribute("setToEdit", setToEdit);
				path = "/edit-set.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a set");
			}

		} else if (action.equals("add")) {
			path = "/index.html";

		}

		getServletContext().getRequestDispatcher(path).forward(request, response);

	}

}