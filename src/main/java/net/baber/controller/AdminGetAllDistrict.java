package net.baber.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.baber.dao.ThanhPhoDAO;
import net.baber.model.QuanHuyen;
import net.baber.model.ThanhPho;

/**
 * Servlet implementation class AdminGetAllDistrict
 */
@WebServlet("/AdminGetAllDistrict")
public class AdminGetAllDistrict extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ThanhPhoDAO thanhphoDAO = new ThanhPhoDAO();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGetAllDistrict() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ThanhPho> listThanhPho = thanhphoDAO.getAll_ThanhPho();
		request.setAttribute("listThanhPho", listThanhPho);
		
		List<QuanHuyen> listQuanHuyen = thanhphoDAO.getAll_QuanHuyen();
		request.setAttribute("listQuanHuyen", listQuanHuyen);
		
		
		
		request.getRequestDispatcher("AdminDistrict.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
