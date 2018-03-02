package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewAllTeamsServlet
 */
@WebServlet("/viewAllTeamsServlet")
public class viewAllTeamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllTeamsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TeamHelper th = new TeamHelper();
		request.setAttribute("allTeams", th.showAllTeams());
		System.out.println("viewallTeamsServlet - allTeams 1");
		if(th.showAllTeams().isEmpty()) {
			getServletContext().getRequestDispatcher("/addTeam.html").forward(request, response);
			System.out.println("viewallTeamsServlet - allTeams - empty");
		}
		System.out.println("viewallTeamsServlet - allTeams 2" + th.showAllTeams());
		getServletContext().getRequestDispatcher("/viewAllTeams.jsp").forward(request, response);
		System.out.println("viewallTeamsServlet - after");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
