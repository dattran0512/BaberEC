package net.baber.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.baber.dao.AdminDAO;

/**
 * Servlet implementation class AdminDeleteOrder
 */
@WebServlet("/AdminDeleteOrder")
public class AdminDeleteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdminDAO adminDAO = new AdminDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idOrder");
		try {
		adminDAO.Delete_OrderDetail_By_IdOrder(id);
		adminDAO.Delete_Order_By_IdOrder(id);
	    
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.getRequestDispatcher("AdminOrder").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
