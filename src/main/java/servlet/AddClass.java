package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Classes;
import util.HibernateUtil;

/**
 * Servlet implementation class AddClass
 */
public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Step 1: Get details , user has entered
		String name = request.getParameter("class");

		// Step 2 : Create Session 

		SessionFactory sf  = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();

		// Step 3: Begin Transaction
		Transaction tx = session.beginTransaction();

		// Create Persistent class 

		Classes classes = new Classes();
		classes.setName(name);

		session.save(classes);

		// Step:5: Commit transaction and close Sessoin
		tx.commit();
		session.close();

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewClass.jsp");
		dispatcher.forward(request, response); 


	}

}
