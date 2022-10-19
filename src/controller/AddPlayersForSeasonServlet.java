package controller; // The package where this servlet class is located at

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

/**
 * Servlet implementation class AddParksForPlanServlet. This servlet class
 * gathers all players from the database and puts them on the add seasons page.
 */
@WebServlet("/addPlayersForSeasonServlet")
public class AddPlayersForSeasonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This is the default, no argument constructor.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPlayersForSeasonServlet() {
		super();
	}

	/**
	 * This method persists the 'Players' entity and sends the found records to an
	 * attribute to be later used in a JSP page.
	 * 
	 * @param request  - the HTTP request
	 * @param response - the HTTP response
	 * @throws ServletException, IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PlayersDAO ph = new PlayersDAO();

		request.setAttribute("allPlayers", ph.showAllPlayers());

		if (ph.showAllPlayers().isEmpty()) { // If the access object is empty, the 'allPlayers' attribute is set to
												// an empty string
			request.setAttribute("allPlayers", "");
		}

		// Forwarding the request to the appropriate page
		getServletContext().getRequestDispatcher("/addSeason.jsp").forward(request, response);
	}

	/**
	 * This method sends the user request to the doGet() method.
	 * 
	 * @param request  - the HTTP request
	 * @param response - the HTTP response
	 * @throws ServletException, IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}