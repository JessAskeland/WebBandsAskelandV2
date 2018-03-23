package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.pepBand;

/**
 * Servlet implementation class EditPepBandServlet
 */
@WebServlet("/editPepBandServlet")
public class editPepBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPepBandServlet() {
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
		pepBandHelper dao = new pepBandHelper();
		
		String bandName = request.getParameter("name of band"); 
		String locationOfBand = request.getParameter("location of band");  
		Integer levelOfBand = Integer.parseInt(request.getParameter("level of band"));
		String eventIdStr = request.getParameter("Event Id");
		Integer tempId = Integer.parseInt(request.getParameter("bandId"));
		Integer eventId = Integer.parseInt(eventIdStr);		
		Integer numberOfMembers = Integer.parseInt(request.getParameter("number of members"));
		
		pepBand itemToUpdate = dao.searchForBandById(tempId);
		itemToUpdate.setNameOfBand(bandName);
		itemToUpdate.setLocationOfBand(locationOfBand);
		itemToUpdate.setEventId(eventId);
		itemToUpdate.setLocationOfBand(locationOfBand);
		itemToUpdate.setNumberOfMembers(numberOfMembers);
		itemToUpdate.setLevelBandId(levelOfBand);
		itemToUpdate.setCostOfParticipation(numberOfMembers, levelOfBand);
		dao.updateBands(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPepBandsServlet").forward(request, response);
	}
	
}