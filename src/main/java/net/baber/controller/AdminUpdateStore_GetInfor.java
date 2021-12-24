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

import org.eclipse.jdt.internal.compiler.lookup.ImplicitNullAnnotationVerifier;

import net.baber.dao.ThanhPhoDAO;
import net.baber.model.Cuahang;
import net.baber.model.ThanhPho;

/**
 * Servlet implementation class AdminUpdateStore_GetInfor
 */
@WebServlet("/AdminUpdateStore_GetInfor")
public class AdminUpdateStore_GetInfor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ThanhPhoDAO thanhphoDAO = new ThanhPhoDAO();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateStore_GetInfor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("Sid"));
		try {
			HttpSession session = request.getSession();
			Cuahang cuahang = thanhphoDAO.Get_CuaHang_By_ID(id);
			 session.setAttribute("cuahang",cuahang);
			List<ThanhPho> listThanhPho = thanhphoDAO.getAll_ThanhPho();
			request.setAttribute("listThanhPho", listThanhPho);
			
			request.getRequestDispatcher("AdminUpdateStore.jsp").forward(request, response);
			
			
			
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
