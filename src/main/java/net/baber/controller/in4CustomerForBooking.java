package net.baber.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.baber.dao.DichVuDAO;
import net.baber.dao.ThanhPhoDAO;
import net.baber.model.Cuahang;
import net.baber.model.DichVu;

/**
 * Servlet implementation class in4CustomerForBooking
 */
@WebServlet("/in4CustomerForBooking")
public class in4CustomerForBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ThanhPhoDAO thanhphoDAO = new ThanhPhoDAO();
	 DichVuDAO dichvuDAO = new DichVuDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public in4CustomerForBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			int idCH = Integer.parseInt(request.getParameter("Sid"));
			HttpSession session = request.getSession();
			Cuahang cuahang = thanhphoDAO.Get_CuaHang_By_ID(idCH);
			List<DichVu> listDichVu = dichvuDAO.getAll_DichVu();
			session.setAttribute("SiD", idCH);
			session.setAttribute("listDichVu", listDichVu);
			session.setAttribute("Saddress", cuahang.getAddress());
			session.setAttribute("Sname", cuahang.getName());
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
