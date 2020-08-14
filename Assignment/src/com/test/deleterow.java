package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Servlet implementation class deleterow
 */
@WebServlet("/deleterow")
public class deleterow extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SessionFactory sfact = null;
		Session sess;
		sfact = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();

		sess = sfact.openSession();
		
//		String id=req.getParameter("eid");
		
		  int eid=Integer.parseInt(req.getParameter("eid"));
		  
		  Employee e =(Employee) sess.load(Employee.class, eid);
		  sess.delete(e);
		  sess.beginTransaction().commit();
			 System.out.println(eid);
		 req.setAttribute("a", eid);

		RequestDispatcher rs=req.getRequestDispatcher("succ.jsp");
		rs.include(req,resp);
//		resp.sendRedirect("http://localhost:8989/Assignment/succ.jsp");
	
	}

}
