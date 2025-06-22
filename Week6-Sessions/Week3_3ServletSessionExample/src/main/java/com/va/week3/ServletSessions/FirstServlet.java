package com.va.week3.ServletSessions;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/* Author - Vivek
 * Date - Sept 25- 2021
 * Desc - First Servlet that handles the sessions ..
 * Provides a way to identify a user across more than one pagerequest or visit to a Web site and to store information about that user. 
 */

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public FirstServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
//			String n = request.getParameter("userName");
//			out.print("Welcome " + n);
			String email = request.getParameter("email");
			out.print("Welcome " + email);
	/*
	 * for sessions...		
	 */
			
			HttpSession session = request.getSession();
//			session.setAttribute("userName", n);
			session.invalidate();
			out.print("<a href='Session invalidated'</a>");

			session.setAttribute("emailAttribute", email);
	        session.invalidate();
	        out.println("added email");

			out.print("<a href='SecondServlet'>visit</a>");
			 out.println("<br><a href=\"SecondServlet\">Go to SecondServlet</a>");
			out.close();

		} catch (Exception e) {
			System.out.println("Unable to set emailattribute " 
	                    + e.getMessage() + "<br>");
//			System.out.println(e);
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
