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
import model.MergeTribes;

/**
 * Servlet implementation class NavigationServlet. This servlet class navigates
 * the user to the appropriate page based on the operation chosen to be
 * performed for each merge tribe record.
 */
@WebServlet("/tribesNavigationServlet")
public class TribesNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This is the default, no argument constructor.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public TribesNavigationServlet() {
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
		MergeTribesDAO mth = new MergeTribesDAO();
		String perform = request.getParameter("doThisToTribe");
		String path = "/viewAllTribesServlet";

		// If the user chose to delete a tribe, ...
		if (perform.equals("delete")) {
			// Parse the string to an integer
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			MergeTribes tribeToDelete = mth.findTribe(tempId);
			mth.deleteMergeTribe(tribeToDelete); // Delete the record
		}

		// Else if the user chose to exit the app, ...
		else if (perform.equals("exit")) {
			mth.cleanUp(); // Clean up, if needed
			path = "/exit.html";
		}

		// Forwarding the request to the appropriate page
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}