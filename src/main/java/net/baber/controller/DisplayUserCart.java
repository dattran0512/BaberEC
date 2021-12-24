package net.baber.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.baber.dao.DichVuDAO;
import net.baber.dao.UserDAO;
import net.baber.model.Cuahang;
import net.baber.model.DichVu;
import net.baber.model.OrderUser;
import net.baber.model.account;

/**
 * Servlet implementation class DisplayUserCart
 */
@WebServlet("/DisplayUserCart")
public class DisplayUserCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DichVuDAO dichvuDAO = new DichVuDAO();
	UserDAO userDAO = new UserDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayUserCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		
		HttpSession session = request.getSession();
		account accUserAccount= (account) session.getAttribute("accountUser");
		OrderUser orderUser = userDAO.Get_Order_By_ID_ACC(accUserAccount.getId());
		Cuahang cuahang = dichvuDAO.Get_CuaHang_By_ID(orderUser.getIdCuaHang());
		List<DichVu> listDichVu = dichvuDAO.getAll_DichVu_By_IdOrder(orderUser.getIdString());
		
		request.setAttribute("orderUser", orderUser);
		request.setAttribute("listDichVu", listDichVu);
		request.setAttribute("Cuahang", cuahang);
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
		
		} catch (Exception e) {
			// TODO: handle exception
			request.getRequestDispatcher("Cart.jsp").forward(request, response);
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
