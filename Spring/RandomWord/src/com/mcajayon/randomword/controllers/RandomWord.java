package com.mcajayon.randomword.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RandomWord
 */
@WebServlet("/RandomWord")
public class RandomWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomWord() {
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
			session.setAttribute("count", 0);
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/random.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Random random = new Random();
		String[] characters = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		List<String> list = Arrays.asList(characters);
		String word = "";
		
		for(int i=0; i<10; i++) {
			Integer x = random.nextInt(36);
			word += list.get(x);
		}
		
		Integer count = (Integer)session.getAttribute("count");
		session.setAttribute("count", count+1);
		session.setAttribute("words", word);
		session.setAttribute("timestamp", new SimpleDateFormat("MMMM dd, yyyy - hh:mm a").format(new Date()));
		String words = request.getParameter("word");
		System.out.println(words);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/random.jsp");
		view.forward(request, response);
	}
}
