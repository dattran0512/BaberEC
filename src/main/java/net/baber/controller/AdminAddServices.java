package net.baber.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.baber.dao.DichVuDAO;

/**
 * Servlet implementation class AdminAddServices
 */
@WebServlet("/AdminAddServices")
public class AdminAddServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DichVuDAO dichVuDAO = new DichVuDAO();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddServices() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("service");
		int price =Integer.parseInt( request.getParameter("price"));
		try {
			dichVuDAO.insert_DichVu(name, price);
			request.getRequestDispatcher("AdminGetAllServices").forward(request, response);
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
