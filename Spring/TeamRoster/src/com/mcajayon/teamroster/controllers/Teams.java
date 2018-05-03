package com.mcajayon.teamroster.controllers;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mcajayon.teamroster.models.Team;
import com.mcajayon.teamroster.models.Roster;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getParameter("id") == null) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/NewTeam");
			view.forward(request, response);
		}
		else {
			int id = Integer.parseInt(request.getParameter("id"));
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("team", (Roster)session.getAttribute("roster")).getTeam(id));
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/TeamInfo");
			view.forward(request, response);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
	
