package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;

/**
 * Servlet implementation class editPlayerServlet
 */
@WebServlet("/editPlayerServlet")
public class editPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act = request.getParameter("doThisToPlayer");
		System.out.println("in editPlayerServlet: " + act);
		PlayerHelper ph = new PlayerHelper();

		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
//		} else if (act.equals("Edit Selected Artwork")) {
//			Integer tempId = Integer.parseInt(request.getParameter("id"));
//			Artwork artworkToEdit = dao.searchForItemById(tempId);
//			// System.out.println("artworkToEdit: " + artworkToEdit);
//			request.setAttribute("artworkToEdit", artworkToEdit);
//			getServletContext().getRequestDispatcher("/edit-artwork.jsp").forward(request, response);
		} else if (act.equals("Delete Selected Player")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Player playerToDelete = ph.searchForPlayerById(tempId);

			ph.deletePlayer(playerToDelete);

			getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);

		} else if (act.equals("Add New Player")) {
			getServletContext().getRequestDispatcher("/addPlayer.html").forward(request, response);
		}
	}

}
