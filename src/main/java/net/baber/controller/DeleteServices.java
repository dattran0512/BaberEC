package net.baber.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.baber.dao.DichVuDAO;
import net.baber.dao.UserDAO;
import net.baber.model.OrderDetail;
import net.baber.model.OrderUser;
import net.baber.model.account;

/**
 * Servlet implementation class DeleteServices
 */
@WebServlet("/DeleteServices")
public class DeleteServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DichVuDAO dichvuDAO = new DichVuDAO();   
	UserDAO userDAO = new UserDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServices() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
		HttpSession session = request.getSession();
		int idServices= Integer.parseInt(request.getParameter("idServices"));
		Object obj = session.getAttribute("services");
				
		@SuppressWarnings("unchecked")
		Map<Integer, OrderDetail> map = (Map<Integer, OrderDetail>) obj;
		map.remove(idServices);
		String idOrder =(String) session.getAttribute("idOrder");
		dichvuDAO.Delete_OrderDetail_By_OrderID(idOrder);
		dichvuDAO.Delete_Order_By_ID(idOrder);
		
		
		
		request.getRequestDispatcher("in4Customer.jsp").forward(request, response);
		
		} catch (Exception e) {
			// TODO: handle exception
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
