package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.marchingBand;

/**
 * Servlet implementation class EditMarchingBandServlet
 */
@WebServlet("/editMarchingBandServlet")
public class editMarchingBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editMarchingBandServlet() {
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
		marchingBandHelper dao = new marchingBandHelper();
		
		String bandName = request.getParameter("name of band"); 
		String numberOfMembersStr = request.getParameter("number of members"); 
		String locationOfBand = request.getParameter("location of band"); 
		String levelBandIdStr = request.getParameter("level of band"); 
		String typesOfProps = request.getParameter("Type of Props");
		String hasColorGuardStr = request.getParameter("Has colorguard"); 		
		int numberOfMembers = Integer.valueOf(numberOfMembersStr);
		int levelBandId = Integer.valueOf(levelBandIdStr);
		boolean hasColorGuard = hasColorGuardStr.equalsIgnoreCase("yes");
		Integer tempId = Integer.parseInt(request.getParameter("bandId"));
		System.out.println(typesOfProps);
		
		marchingBand itemToUpdate = dao.searchForBandById(tempId);
		itemToUpdate.setNameOfBand(bandName);
		itemToUpdate.setNumberOfMembers(numberOfMembers);
		itemToUpdate.setLocationOfBand(locationOfBand);
		itemToUpdate.setLevelBandId(levelBandId);
		itemToUpdate.setTypesOfProps(typesOfProps);
		itemToUpdate.setHasColorGuard(hasColorGuard);
		itemToUpdate.setCostOfParticipation(numberOfMembers, levelBandId);
		dao.updateBands(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllMarchingBandsServlet").forward(request, response);
	}

}