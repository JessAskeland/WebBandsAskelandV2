package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.pepBand;

/**
 * Servlet implementation class AddPepBandServlet
 */
@WebServlet("/addPepBandServlet")
public class addPepBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPepBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nameOfBand = request.getParameter("name of band");
		String numberOfMembersStr = request.getParameter("number of members"); 
		String locationOfBand = request.getParameter("location of band");
		String levelBandIdStr = request.getParameter("level of band"); 
		String eventIdStr = request.getParameter("Event Id");  
		
		int numberOfMembers = Integer.valueOf(numberOfMembersStr);
		int levelBandId = Integer.valueOf(levelBandIdStr);
		int eventId = Integer.valueOf(eventIdStr); 
		
		System.out.println("#Members " + numberOfMembers);
		System.out.println("EventId " + eventId);
		
 		pepBand li = new pepBand(numberOfMembers, nameOfBand, locationOfBand, levelBandId, eventId);
		pepBandHelper dao = new pepBandHelper();
		dao.insertPepBand(li);

		getServletContext().getRequestDispatcher("/addPepBand.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}