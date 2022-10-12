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
 * Servlet implementation class AddSeasonServlet. This servlet class adds a
 * season record to the "seasons" table in the database.
 */
@WebServlet("/addSeasonServlet")
public class AddSeasonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This is the default, no argument constructor.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSeasonServlet() {
		super();
	}

	/**
	 * This method adds a new season record to the "seasons" table.
	 * @param request - the HTTP request
	 * @param response - the HTTP response
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Getting the input from the user
		String seasonStringNum = request.getParameter("number");
		String seasonName = request.getParameter("name");
		String seasonWinner = request.getParameter("winner");
		String dateString = request.getParameter("date");
		
		// Parsing some of it to be acceptable for the constructor
		int seasonNum = Integer.parseInt(seasonStringNum);
		LocalDate firstAired = LocalDate.parse(dateString);
		
		// Actually adding the new season
		Seasons toAdd = new Seasons(seasonNum, seasonName, seasonWinner, firstAired);
		SeasonsDAO sh = new SeasonsDAO();
		sh.insertSeason(toAdd);
		
		// Forwarding the request to the appropriate page
		getServletContext().getRequestDispatcher("/addSeason.html").forward(request, response);
	}

}
