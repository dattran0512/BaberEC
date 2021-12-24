package net.baber.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import net.baber.dao.UserDAO;
import net.baber.model.account;

/**
 * Servlet implementation class CheckLoginUser
 */
@WebServlet("/CheckLoginUser")
public class CheckLoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDAO userDAO = new UserDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLoginUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			try {
				HttpSession session = request.getSession();
				
			String  taikhoan = request.getParameter("username");
			String  matkhau = request.getParameter("password");					
		    account account = userDAO.loginUser(taikhoan, matkhau);
				if(account==null) {
					response.sendRedirect("userlogin.jsp");
				}
					
				account accountUser = userDAO.Get_Account_By_Taikhoan(taikhoan);
				session.setAttribute("accountUser", accountUser);
				response.sendRedirect("index.jsp");
									
			} catch (Exception e) {
				// TODO: handle exception
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
