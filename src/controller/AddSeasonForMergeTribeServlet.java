package controller; // The package where this servlet class is located at

/**
 * @author Max Chance
 * CIS175 - Fall 2022
 * Oct 5, 2022
 */

// Including the needed imports for this servlet class
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddParksForPlanServlet. This servlet class
 * gathers all items from the database and puts them on a travel plan.
 */
@WebServlet("/addSeasonForMergeTribeServlet")
public class AddSeasonForMergeTribeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This is the default, no argument constructor.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSeasonForMergeTribeServlet() {
		super();
	}

	/**
	 * This method persists the 'MTRIBESe' entity and sends the found records to
	 * an attribute to be later used in a JSP page.
	 * 
	 * @param request  - the HTTP request
	 * @param response - the HTTP response
	 * @throws ServletException, IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SeasonsDAO sh = new SeasonsDAO();

		request.setAttribute("allSeasons", sh.showAllSeasons());

		if (sh.showAllSeasons().isEmpty()) { // If the access object is empty, the 'allParks' attribute is set to
												// an empty string
			request.setAttribute("allSeasons", "");
		}

		// Forwarding the request to the appropriate page
		getServletContext().getRequestDispatcher("/addMergeTribe.jsp").forward(request, response);
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