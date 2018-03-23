package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewCompetitionListServlet
 */
@WebServlet("/viewCompetitionListServlet")
public class viewCompetitionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewCompetitionListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		competitionHelper dao = new competitionHelper();
		request.setAttribute("allItems", dao.showAllCompetitions());
		if (dao.showAllCompetitions().isEmpty()) {
			request.setAttribute("allItems", " ");
		}
		
		bandsHelper bh = new bandsHelper();
		request.setAttribute("allMarchingBands", bh.showAllBands());
						
		getServletContext().getRequestDispatcher("/competitionList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}