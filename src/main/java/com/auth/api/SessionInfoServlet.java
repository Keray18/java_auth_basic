package com.auth.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Date;
/**
 * Servlet implementation class SessionInfoServlet
 */
@WebServlet("/SessionInfoServlet")
public class SessionInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess = request.getSession();
		long creationTime = sess.getCreationTime();
		long lastAccessedTime = sess.getLastAccessedTime();
		
		response.setContentType("text/html");
		response.getWriter().println("<h1>Session Information</h1>");
		response.getWriter().println("<p>Session ID: " + sess.getId() + "</p>");
		response.getWriter().println("<p> Creation Time: " + new Date(creationTime) + "</p>");
		response.getWriter().println("<p> Last Accessed Time: " + new Date(lastAccessedTime) + "</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
