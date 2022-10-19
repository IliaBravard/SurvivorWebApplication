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

// Allows access to the specified entity
import model.Players;

/**
 * Servlet implementation class AddPlayerServlet. This servlet class adds a
 * player record in the "players" table.
 */
@WebServlet("/addPlayerServlet")
public class AddPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This is the default, no argument constructor.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPlayerServlet() {
		super();
	}

	/**
	 * This method adds a new player record to the "players" table.
	 * 
	 * @param request  - the HTTP request
	 * @param response - the HTTP response
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Getting the input from the user
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");

		// Parsing the age to an integer
		int castingAge = Integer.parseInt(request.getParameter("castAge"));

		// Actually adding the new player
		Players toAdd = new Players(fName, lName, castingAge);
		PlayersDAO ph = new PlayersDAO();
		ph.insertPlayer(toAdd);

		// Forwarding the request to the appropriate page
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}
}