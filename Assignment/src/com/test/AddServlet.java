package com.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int eid = Integer.parseInt(req.getParameter("eid"));
		String ename = req.getParameter("ename");
		String desg = req.getParameter("desg");
		String Salary = req.getParameter("Salary");

		try {
			SessionFactory sfact = null;
			Session sess;
			sfact = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();

			sess = sfact.openSession();

		Transaction tx=sess.beginTransaction();

			Employee e = new Employee();

			e.setEid(eid);
			e.setEname(ename);
			e.setDesg(desg);
			e.setSalary(Salary);
			
			
		sess.saveOrUpdate(e);


		sess.beginTransaction().commit();
		boolean b=sess.beginTransaction().wasCommitted();
if(b) {
			resp.sendRedirect("http://localhost:8989/Assignment/succ.jsp");
}else {
	resp.sendRedirect("http://localhost:8989/Assignment/fail.jsp");
}
		} catch (Exception er) {
			System.out.println("Problem:" + er.getMessage());
			er.printStackTrace();
			resp.sendRedirect("http://localhost:8989/Assignment/fail.jsp");
		}

//	Configuration cfg=new Configuration();
//	cfg.configure("hibernate.cfg.xml");
//	SessionFactory sf=cfg.buildSessionFactory();
//	Session ss=sf.openSession();

//	Employee e=new Employee();
//	e.setEid(eid);
//	e.setEname(ename);
//	e.setEsal(esal);
//	e.setDesg(desg);
//	
//	ss.save(e);
//	ss.beginTransaction().commit();

	}

}
