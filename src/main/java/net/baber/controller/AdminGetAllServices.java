package net.baber.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.baber.dao.DichVuDAO;
import net.baber.model.DichVu;

/**
 * Servlet implementation class AdminGetAllServices
 */
@WebServlet("/AdminGetAllServices")
public class AdminGetAllServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DichVuDAO dichVuDAO = new DichVuDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminGetAllServices() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<DichVu> listServices = dichVuDAO.getAll_DichVu();
		request.setAttribute("listServices", listServices);
		request.getRequestDispatcher("adminServices.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
