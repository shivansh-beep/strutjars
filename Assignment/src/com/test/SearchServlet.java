package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

	
			SessionFactory sfact = null;
			Session sess;
			sfact = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();

			sess = sfact.openSession();
			int id = Integer.parseInt(req.getParameter("searchId"));
			Employee e = (Employee) sess.load(Employee.class, id);
			
		ArrayList<Employee> al=new ArrayList<Employee>();
		al.add(e);
				req.setAttribute("list",al);
if(al.isEmpty()) {
	RequestDispatcher rs=req.getRequestDispatcher("noResult.jsp");
	rs.include(req,resp);
}else {
	pw.print(" <h1>Displaying Employee List</h1> \r\n" + 
			"      <table border =\"1\" align=\"center\"> \r\n" + 
			"         <tr > \r\n" + 
			"          <th><b>Employee ID</b></th> \r\n" + 
			"          <th><b>Employee Name</b></th> \r\n" + 
			"          <th><b>Employee Salary</b></th> \r\n" + 
			"          <th><b>Employee Desg</b></th> \r\n" + 
			"         </tr> ");
	
	for (Employee employee : al) {
		pw.print(" <tr> \r\n" + 
				"                <td>"+e.getEid()+"</td> \r\n" + 
				"                <td>"+e.getEname()+"</td> \r\n" + 
				"                <td>"+e.getSalary()+"</td> \r\n" + 
				"                <td>"+e.getDesg()+"</td> \r\n" + 
				"                <td><a href ='deleterow?eid="+e.getEid()+"'>Delete</a></td>\r\n" + 
				"            </tr> \r\n" + 
				"        </table>  ");
	}
	
	
	
//				RequestDispatcher rs=req.getRequestDispatcher("succ.jsp");
//				rs.include(req,resp);

		
}
	

	}

}
