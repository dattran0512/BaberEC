package net.baber.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import net.baber.dao.ThanhPhoDAO;
import net.baber.model.Cuahang;
import net.baber.model.QuanHuyen;
import net.baber.model.ThanhPho;

/**
 * Servlet implementation class SelectTP
 */
@WebServlet("/SelectTP")
public class SelectTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ThanhPhoDAO thanhphoDAO = new ThanhPhoDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectTP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int idTP = Integer.parseInt(request.getParameter("idTP"));
		session.setAttribute("ssIDTP", idTP);
		
		List<ThanhPho> listThanhPho = thanhphoDAO.getAll_ThanhPho();
		request.setAttribute("listThanhPho", listThanhPho);
		
		
		
		List<QuanHuyen> listQH = thanhphoDAO.getAll_QuanHuyenBy_ThanhPhoID(idTP);
		request.setAttribute("listQH", listQH);
		
		List<Cuahang> listCH = thanhphoDAO.getAll_CuaHang_By_ThanhPhoID(idTP);
		request.setAttribute("listCH", listCH);
			request.getRequestDispatcher("Booking.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
