package com.mcajayon.greatnumbergame.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Games
 */
@WebServlet("/Games")
public class Games extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Games() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session == null) {
			session = request.getSession();
			Random random = new Random();
			Integer x = random.nextInt(99)+1;
			session.setAttribute("x", x);
			session.setAttribute("results", null);
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/number.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Boolean restart = Boolean.valueOf(request.getParameter("restart"));
		if (restart) {
			session.invalidate();
			doGet(request, response);
		}
		else {
			if (request.getParameter("guess") == "") {
				session.setAttribute("guess", 0);
			}
			else {
				Integer y = Integer.valueOf(request.getParameter("guess"));
				session .setAttribute("guess", y);
			}
			if (session.getAttribute("x") == session.getAttribute("guess")) {
				session.setAttribute("results", true);
			}
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/number.jsp");
			view.forward(request, response);
		}
	}
}
