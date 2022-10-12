package controller; // The package where this servlet is located at

// Including the needed imports
import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Seasons;

/**
 * Servlet implementation class EditSeasonServlet. This class performs the edit
 * database transactions over each season record in the "seasons" table.
 */
@WebServlet("/editSeasonServlet")
public class EditSeasonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This is the default, no argument constructor.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public EditSeasonServlet() {
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
		SeasonsDAO sh = new SeasonsDAO();

		// Storing the user's input in the appropriate variables
		int seasonsNum = Integer.parseInt(request.getParameter("number"));
		String seasonName = request.getParameter("name");
		String seasonWinner = request.getParameter("winner");
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		int seasonId = Integer.parseInt(request.getParameter("id"));

		// Finding the record to be edited by its ID number
		Seasons seasonToEdit = sh.findSeason(seasonId);

		// Using the mutators to set the newly entered information
		seasonToEdit.setSeasonNum(seasonsNum);
		seasonToEdit.setSeasonName(seasonName);
		seasonToEdit.setSeasonWinner(seasonWinner);
		seasonToEdit.setFirstAired(date);

		// Actually updating the season record
		sh.updateSeason(seasonToEdit);

		// Forwarding the request to the appropriate page
		getServletContext().getRequestDispatcher("/viewAllSeasonsServlet").forward(request, response);
	}
}