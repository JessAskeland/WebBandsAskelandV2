package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Band;

/**
 * Servlet implementation class AddBandServlet
 */
@WebServlet("/addBandServlet")
public class addBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nameOfBand = request.getParameter("name of band");
		String numberOfMembersStr = request.getParameter("number of members"); 
		String locationOfBand = request.getParameter("location of band");
		String levelBandIdStr = request.getParameter("level of band"); 
		
		int numberOfMembers = Integer.valueOf(numberOfMembersStr);
		int levelBandId = Integer.valueOf(levelBandIdStr);
 
		Band li = new Band(numberOfMembers, nameOfBand, locationOfBand, levelBandId);
		bandsHelper dao = new bandsHelper();
		dao.insertBands(li);

		getServletContext().getRequestDispatcher("/addBand.html").forward(request, response);
	}

}