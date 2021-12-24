package net.baber.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.baber.dao.ThanhPhoDAO;

/**
 * Servlet implementation class AdminAddStore
 */
@WebServlet("/AdminAddStore")
public class AdminAddStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ThanhPhoDAO thanhphoDAO = new ThanhPhoDAO();              
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddStore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idQH = Integer.parseInt(request.getParameter("idQuanHuyen"));
		String sName = request.getParameter("storeName");
		String detailAddString = request.getParameter("detailAdd");
		try {
			thanhphoDAO.insert_Store(sName, detailAddString, idQH);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("AdminStore").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
