package controller; // The package where this servlet is located at

// Including the needed imports
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllPlayersServlet. THis servlet class
 * displays all records within the "players" entity, if any.
 */
@WebServlet("/viewAllPlayersServlet")
public class ViewAllPlayersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This is the default, no argument construcrtor.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAllPlayersServlet() {
		super();
	}

	/**
	 * This method retrieves all records from the "players" table and stores them in
	 * a specified attribute.
	 * 
	 * @param request  - the HTTP request
	 * @param response - the HTTP response
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PlayersDAO ph = new PlayersDAO();
		request.setAttribute("allPlayers", ph.showAllPlayers());

		String path = "/playersList.jsp";

		// If no records exist in the "seasons" table, asks the user to add some
		if (ph.showAllPlayers().isEmpty()) {
			path = "/addPlayer.html";
		}

		// Forwarding the request to the appropriate page
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * This method calls the doGet() method when the request has been received.
	 * 
	 * @param request  - the HTTP request
	 * @param repsonse - the HTTP response
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}