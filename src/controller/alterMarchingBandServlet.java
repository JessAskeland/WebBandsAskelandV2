package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.marchingBand;

/**
 * Servlet implementation class AlterMarchingBandServlet
 */
@WebServlet("/alterMarchingBandServlet")
public class alterMarchingBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public alterMarchingBandServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act = request.getParameter("doThisToBand");
		marchingBandHelper dao = new marchingBandHelper();

		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllMarchingBandsServlet").forward(request, response);
			
		} else if (act.equals("Edit Marching Band")) {
			Integer tempId = Integer.parseInt(request.getParameter("bandId"));
			System.out.println("temp id " + tempId);
			marchingBand bandToEdit = dao.searchForBandById(tempId);
			request.setAttribute("bandToEdit", bandToEdit);
			getServletContext().getRequestDispatcher("/editMarchingBands.jsp").forward(request, response);
			
		} else if (act.equals("Delete Marching Band")) {			
			Integer tempId = Integer.parseInt(request.getParameter("bandId"));
			marchingBand bandToDelete = dao.searchForBandById(tempId);
			dao.delete(bandToDelete);
			getServletContext().getRequestDispatcher("/viewAllMarchingBandsServlet").forward(request, response);
			
		} else if (act.equals("Add Marching Band")) {
			getServletContext().getRequestDispatcher("/addMarchingBand.html").forward(request, response);
		}
	}

}