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

@WebServlet("/addSetServlet")
public class AddSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddSetServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//int ID, String setName, int numPieces, double price, String theme
		
		String name = request.getParameter("name");
		String numPiecesRaw = request.getParameter("numPieces");
		String priceRaw = request.getParameter("price");
		String theme = request.getParameter("theme");
		
		int numPieces = Integer.parseInt(numPiecesRaw);
		int price = Integer.parseInt(priceRaw);
		
		LegoSet ls = new LegoSet(name, numPieces, price, theme);
		SetHelper dbo = new SetHelper();
		dbo.insertLegoSet(ls);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
