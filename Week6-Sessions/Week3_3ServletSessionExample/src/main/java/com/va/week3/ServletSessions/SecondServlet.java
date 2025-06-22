package com.va.week3.ServletSessions;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SecondServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			HttpSession session = request.getSession(false);
			if (session == null) {
			    out.println("Session was invalidated.<br>");
			} else {
			    out.println("Session is still active.<br>");

			    String n = (String) session.getAttribute("userName");
			    String email = (String) session.getAttribute("emailAttribute");
			    String age = (String) session.getAttribute("age");

			    out.println("userName: " + (n != null ? n : "not found") + "<br>");
			    out.println("emailAttribute: " + (email != null ? email : "not found") + "<br>");
			    out.println("age: " + (age != null ? age : "not found") + "<br>");

			    session.removeAttribute("age");
			    out.println("age attribute removed from session.<br>");
			}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
