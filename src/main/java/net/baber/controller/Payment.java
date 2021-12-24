package net.baber.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.baber.dao.DichVuDAO;
import net.baber.model.account;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DichVuDAO dichvuDAO = new DichVuDAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Payment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
		HttpSession session = request.getSession();
		request.setAttribute("Payment", "Đã thanh toán");
		
		Object object = session.getAttribute("accountUser");
		if(object==null) {
		String idOrder =  request.getParameter("idOrder");
		dichvuDAO.Update_Payment_Order_By_ID(idOrder);	
		
		}else {
			account accUserAccount = (account) object;
			dichvuDAO.Update_Payment_Order_By_IDAcc(accUserAccount.getId());
			
		}
		request.getRequestDispatcher("DisplayUserCart").forward(request, response);
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
