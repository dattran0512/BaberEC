package net.baber.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.baber.dao.ThanhPhoDAO;
import net.baber.model.Cuahang;
import net.baber.model.QuanHuyen;
import net.baber.model.ThanhPho;

/**
 * Servlet implementation class AdminStoreSelectQH
 */
@WebServlet("/AdminStoreSelectQH")
public class AdminStoreSelectQH extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ThanhPhoDAO thanhphoDAO = new ThanhPhoDAO();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminStoreSelectQH() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ThanhPho> listThanhPho = thanhphoDAO.getAll_ThanhPho();
		request.setAttribute("listThanhPho", listThanhPho);
		int idTP = 1;
		HttpSession session = request.getSession();
		Object obj=   session.getAttribute("adIDTP");
		if(obj!=null) {
		 idTP = (int) obj;
		}
		List<QuanHuyen> listQH = thanhphoDAO.getAll_QuanHuyenBy_ThanhPhoID(idTP);
		request.setAttribute("listQH", listQH);
		
		int idQH = Integer.parseInt(request.getParameter("idQH"));
		List<Cuahang> listCH = thanhphoDAO.getAll_CuaHang_By_QuanHuyenID(idQH);
		
		request.setAttribute("listCH", listCH);
			request.getRequestDispatcher("AdminStore.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
