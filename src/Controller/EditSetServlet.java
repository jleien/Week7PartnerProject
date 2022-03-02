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

@WebServlet("/editSetServlet")
public class EditSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SetHelper dbo = new SetHelper();
		
		//int ID, String setName, int numPieces, double price, String theme
		
		String name = request.getParameter("name");
		String numPiecesRaw = request.getParameter("numPieces");
		String priceRaw = request.getParameter("price");
		String theme = request.getParameter("theme");
		
		int numPieces = Integer.parseInt(numPiecesRaw);
		int price = Integer.parseInt(priceRaw);
		
		Integer tempId = Integer.parseInt(request.getParameter("ID"));
		
		LegoSet setToUpdate = dbo.searchForLegoSetById(tempId);
		setToUpdate.setSetName(name);
		setToUpdate.setNumPieces(numPieces);
		setToUpdate.setPrice(price);
		setToUpdate.setTheme(theme);
		
		
		
		dbo.updateLegoSet(setToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllLegoSetsServlet").forward(request, response);
	}

}
