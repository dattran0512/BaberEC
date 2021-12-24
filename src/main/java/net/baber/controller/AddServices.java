package net.baber.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.baber.dao.DichVuDAO;
import net.baber.dao.ThanhPhoDAO;
import net.baber.model.DichVu;
import net.baber.model.OrderDetail;

/**
 * Servlet implementation class AddServices
 */
@WebServlet("/AddServices")
public class AddServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  ThanhPhoDAO thanhphoDAO = new ThanhPhoDAO();
	  DichVuDAO dichvuDAO = new DichVuDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServices() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int idDV=Integer.parseInt(request.getParameter("idDV"));
		try {
			DichVu dichvu = dichvuDAO.Get_DichVu_By_ID(idDV);
			Object obj = session.getAttribute("services");
			if(obj==null) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setDichvu(dichvu);
				orderDetail.setUnitPrice(dichvu.getPrice());
				Map<Integer, OrderDetail> map = new HashMap<>();
				map.put(idDV, orderDetail);
				session.setAttribute("services", map);
			}else {
				@SuppressWarnings("unchecked")
				Map<Integer, OrderDetail> map = (Map<Integer, OrderDetail>) obj;
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setDichvu(dichvu);
				orderDetail.setUnitPrice(dichvu.getPrice());
				map.put(idDV, orderDetail);
				session.setAttribute("services", map);
			}
			
				
			
				request.getRequestDispatcher("in4Customer.jsp").forward(request, response);
	
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
