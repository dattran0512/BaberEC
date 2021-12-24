package net.baber.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.baber.dao.DichVuDAO;
import net.baber.dao.UserDAO;
import net.baber.model.OrderUser;
import net.baber.model.account;

/**
 * Servlet implementation class DeleteOrder
 */
@WebServlet("/DeleteOrder")
public class DeleteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDAO userDAO = new UserDAO();
       DichVuDAO dichvuDAO = new DichVuDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				
			
					HttpSession session = request.getSession();
					Object obj = session.getAttribute("accountUser");
					
					if(obj!=null) {
						account accUserAccount= (account) obj;
						OrderUser orderUser = userDAO.Get_Order_By_ID_ACC(accUserAccount.getId());
						dichvuDAO.Delete_OrderDetail_By_OrderID(orderUser.getIdString());
						dichvuDAO.Delete_Order_By_ID(orderUser.getIdString());
					
						}
						else {
					
					session.removeAttribute("Order");
					session.removeAttribute("services");
					
						}
					response.sendRedirect("Cart.jsp");
					
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
