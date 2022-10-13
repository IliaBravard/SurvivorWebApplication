package controller; // The package where this servet is located at

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
 * Servlet implementation class PlayersNavigationServlet. This servlet navigates
 * the user to the appropriate page based on the operation chosen to be
 * performed for each player record.
 */
@WebServlet("/playersNavigationServlet")
public class PlayersNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This is the default, no argument constructor.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public PlayersNavigationServlet() {
		super();
	}

	/**
	 * This method determines what should be done when the user either presses the
	 * "delete" or "edit" button.
	 * 
	 * @param request  - the HTTP request
	 * @param response - the HTTP response
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PlayersDAO ph = new PlayersDAO();
		String perform = request.getParameter("doThisToPlayer");
		String path = "/viewAllPlayersServlet";

		// If the user chose to delete a season, ...
		if (perform.equals("delete")) {

			// Parse the string to an integer
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Players playerToDelete = ph.findPlayer(tempId);
			ph.deletePlayer(playerToDelete); // Delete the record
		} else if (perform.equals("edit")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Players playerToEdit = ph.findPlayer(tempId);
			request.setAttribute("playerToEdit", playerToEdit);
			path = "/editPlayer.jsp";
		}

		// Forwarding the request to the appropriate page
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
