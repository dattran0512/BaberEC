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
 * Servlet implementation class AdminUpdateServices2
 */
@WebServlet("/AdminUpdateServices2")
public class AdminUpdateServices2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DichVuDAO dichVuDAO = new DichVuDAO();     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateServices2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int price =Integer.parseInt( request.getParameter("price"));
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			dichVuDAO.Update_DichVu_By_ID(name, price, id);
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
