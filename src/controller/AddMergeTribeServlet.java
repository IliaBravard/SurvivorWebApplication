package controller; // The package where this servlet is located at

/**
 * @author Ilia Bravard - igbravard
 * CIS175 - Fall 2022
 * Oct 20, 2022
 */

// Including the needed imports
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Allows access to the specified entities
import model.MergeTribes;
import model.Seasons;

/**
 * Servlet implementation class AddSeasonServlet. This servlet class adds a
 * season record to the "seasons" table in the database.
 */
@WebServlet("/addMergeTribeServlet")
public class AddMergeTribeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This is the default, no argument constructor.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMergeTribeServlet() {
		super();
	}

	/**
	 * This method adds a new season record to the "seasons" table.
	 * 
	 * @param request  - the HTTP request
	 * @param response - the HTTP response
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SeasonsDAO sh = new SeasonsDAO();

		// Getting the input from the user
		String tribeName = request.getParameter("name");
		String nameMeaning = request.getParameter("meaning");
		int numOfPlayers = Integer.parseInt(request.getParameter("players"));

		String selectedSeason = request.getParameter("seasonToAdd");
		Seasons s = sh.findSeason(Integer.parseInt(selectedSeason));

		// Actually adding the new season
		MergeTribes toAdd = new MergeTribes(tribeName, nameMeaning, numOfPlayers, s);

		MergeTribesDAO mth = new MergeTribesDAO();
		mth.insertMergeTribe(toAdd);

		System.out.println(toAdd.toString()); /* Diagnostic */

		// Forwarding the request to the appropriate page
		getServletContext().getRequestDispatcher("/viewAllTribesServlet").forward(request, response);
	}
}