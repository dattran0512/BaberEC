package net.baber.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.baber.dao.DichVuDAO;
import net.baber.dao.ThanhPhoDAO;
import net.baber.model.Cuahang;
import net.baber.model.Order;
import net.baber.model.OrderDetail;
import net.baber.model.account;

/**
 * Servlet implementation class AcceptOrder
 */
@WebServlet("/AcceptOrder")
public class AcceptOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ThanhPhoDAO thanhphoDAO = new ThanhPhoDAO();
	DichVuDAO dichvuDAO = new DichVuDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String Cname = request.getParameter("Cname");
		String Cphone = request.getParameter("Cphone");
		String Date =  request.getParameter("Cdate");
		String Time =  request.getParameter("Ctime");
		String DateTime = Date+" "+Time;
		int idCH = (int) session.getAttribute("SiD");
		try {
			Cuahang cuahang = thanhphoDAO.Get_CuaHang_By_ID(idCH);
			long unitPrice = (long) session.getAttribute("totalOrder");
			// Create new order
			Order order =  new Order();
			order.setCuahang(cuahang);
			order.setCustomerName(Cname);
			order.setCustomerPhone(Cphone);
			order.setorderDate(DateTime);
			order.setPriceTotal(unitPrice);
		
			Map<Integer, OrderDetail> services = (Map<Integer, OrderDetail>) session.getAttribute("services");
			if(services == null || services.isEmpty()) {
				request.setAttribute("Alert", "Vui lòng thêm dịch vụ");
				request.getRequestDispatcher("in4Customer.jsp").forward(request, response);
			}
			
			else {
			
			final String IdOrder = UUID.randomUUID().toString();
			
			Object object = session.getAttribute("accountUser");
			if(object==null) {
			dichvuDAO.insert_Orderr(IdOrder, idCH, 2 , Cname, Cphone, DateTime, unitPrice);
			
			}else {
				account account =  (account) session.getAttribute("accountUser");
				
				dichvuDAO.insert_Orderr(IdOrder, idCH, account.getId() , Cname, Cphone, DateTime, unitPrice);
			}
			 for (Map.Entry<Integer, OrderDetail> entry : services.entrySet()) {
				 dichvuDAO.insert_OrderDetail(entry.getKey(), entry.getValue().getDichvu().getId(), IdOrder);
			 }
			 
			 session.setAttribute("idOrder", IdOrder);
			 session.setAttribute("Order", order);
			 request.getRequestDispatcher("DisplayUserCart").forward(request, response);
			}
			
		} catch (SQLException e) {	
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
