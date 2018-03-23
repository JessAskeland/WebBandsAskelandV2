package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Band;

/**
 * Servlet implementation class EditBandServlet
 */
@WebServlet("/alterBandServlet")
public class alterBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public alterBandServlet() {
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
		bandsHelper dao = new bandsHelper();

		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllBandsServlet").forward(request, response);
		} else if (act.equals("Edit Concert Band")) {
			Integer tempId = Integer.parseInt(request.getParameter("bandId"));
			System.out.println("temp id " + tempId);
			Band bandToEdit = dao.searchForItemById(tempId);
			request.setAttribute("bandToEdit", bandToEdit);
			getServletContext().getRequestDispatcher("/editBands.jsp").forward(request, response);
			
		} else if (act.equals("Delete Concert Band")) {
			Integer tempId = Integer.parseInt(request.getParameter("bandId"));
			Band bandToDelete = dao.searchForItemById(tempId);
			dao.delete(bandToDelete);
			getServletContext().getRequestDispatcher("/viewAllBandsServlet").forward(request, response);

		} else if (act.equals("Add Concert Band")) {
			getServletContext().getRequestDispatcher("/addBand.html").forward(request, response);
		}
	}

}