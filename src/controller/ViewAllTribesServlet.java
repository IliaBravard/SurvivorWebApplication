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
 * Servlet implementation class ViewAllSeasonsServlet. This servlet class
 * displays all records from the "mtribes" table, if any.
 */
@WebServlet("/viewAllTribesServlet")
public class ViewAllTribesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This is the default, no argument constructor.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAllTribesServlet() {
		super();
	}

	/**
	 * This method retrieves all records from the "seasons" table and stores them in
	 * the specified attribute.
	 * 
	 * @param request  - the HTTP request
	 * @param response - the HTTP response
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MergeTribesDAO mth = new MergeTribesDAO();
		request.setAttribute("allTribes", mth.showAllTribes());

		// Forwarding the request to the appropriate page
		getServletContext().getRequestDispatcher("/tribesList.jsp").forward(request, response);
	}

	/**
	 * This method calls the doGet() method when the request has been received.
	 * 
	 * @param request  - the HTTP request
	 * @param response - the HTTP response
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}