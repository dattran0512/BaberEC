package net.baber.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.baber.dao.DichVuDAO;
import net.baber.model.DichVu;

/**
 * Servlet implementation class AdminUpdateServices
 */
@WebServlet("/AdminUpdateServices")
public class AdminUpdateServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DichVuDAO dichVuDAO =  new DichVuDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateServices() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(	request.getParameter("idService"));
			
		try {
			DichVu dichvu =  dichVuDAO.Get_DichVu_By_ID(id);
			request.setAttribute("id", dichvu.getId());
			request.setAttribute("name", dichvu.getName());
			request.setAttribute("price", dichvu.getPrice());
			request.getRequestDispatcher("AdminUpdateServices.jsp").forward(request, response);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
