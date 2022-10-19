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

// Allows access to the specified entity
import model.Seasons;

/**
 * Servlet implementation class NavigationServlet. This servlet class navigates
 * the user to the appropriate page based on the operation chosen to be
 * performed for each season record.
 */
@WebServlet("/seasonsNavigationServlet")
public class SeasonsNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This is the default, no argument constructor.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public SeasonsNavigationServlet() {
		super();
	}

	/**
	 * This method determines what should be done when the user either presses the
	 * "delete" or "edit" buttons.
	 * 
	 * @param request  - the HTTP request
	 * @param response - the HTTP response
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SeasonsDAO sh = new SeasonsDAO();
		String perform = request.getParameter("doThisToSeason");
		String path = "/viewAllSeasonsServlet";

		// If the user chose to delete a season, ...
		if (perform.equals("delete")) {

			// Parse the string to an integer
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Seasons seasonToDelete = sh.findSeason(tempId);
			sh.deleteSeason(seasonToDelete); // Delete the record
		}

		// Else if the user chose to edit a season, ...
		else if (perform.equals("edit")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Seasons seasonToEdit = sh.findSeason(tempId);
			request.setAttribute("seasonToEdit", seasonToEdit);
			path = "/addPlayersForEdit";
		}

		// Else if the user chose to exit the app, ...
		else if (perform.equals("exit")) {
			sh.cleanUp(); // Clean up, if needed
			path = "/exit.html";
		}

		// Forwarding the request to the appropriate page
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}