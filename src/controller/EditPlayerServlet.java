package controller; // The package where this servlet is located at

// Including the needed imports
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Provides access to the "Players" entity
import model.Players;

/**
 * Servlet implementation class EditPlayerServlet. This class performs the edit
 * database transactions over each player record in the "players" table.
 */
@WebServlet("/editPlayerServlet")
public class EditPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This is the default, no argument constructor.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public EditPlayerServlet() {
		super();
	}

	/**
	 * This method updates a season record from the "seasons" table.
	 * 
	 * @param request  - the HTTP request
	 * @param response - the HTTP response
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PlayersDAO ph = new PlayersDAO();

		// Storing the user's input in the appropriate variables
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		int castAge = Integer.parseInt(request.getParameter("castAge"));
		int playerId = Integer.parseInt(request.getParameter("id"));

		// Finding the record to be edited by its ID number
		Players playerToEdit = ph.findPlayer(playerId);

		// Using the mutators to set the newly entered information
		playerToEdit.setFirstName(fName);
		playerToEdit.setLastName(lName);
		playerToEdit.setAge(castAge);

		// Actually updating the season record
		ph.updatePlayer(playerToEdit);

		// Forwarding the request to the appropriate page
		getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
	}
}