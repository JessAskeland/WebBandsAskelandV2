package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.marchingBand;

/**
 * Servlet implementation class AddMarchingBandServlet
 */
@WebServlet("/addMarchingBandServlet")
public class addMarchingBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addMarchingBandServlet() {
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
		String typesOfProps = request.getParameter("Type of Props"); 
		String hasColorGuardStr = request.getParameter("Has colorguard"); 
		
		int numberOfMembers = Integer.valueOf(numberOfMembersStr);
		int levelBandId = Integer.valueOf(levelBandIdStr);
		boolean hasColorGuard = hasColorGuardStr.equalsIgnoreCase("yes");
		 
		marchingBand li = new marchingBand(numberOfMembers, nameOfBand, locationOfBand, levelBandId, typesOfProps, hasColorGuard);
		marchingBandHelper dao = new marchingBandHelper();
		dao.insertMarchingBand(li);

		getServletContext().getRequestDispatcher("/addMarchingBand.html").forward(request, response);
	}
}