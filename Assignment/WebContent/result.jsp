<%@page import="com.test.Employee"%> 
<%@page import="java.util.ArrayList"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
  <head> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
   <title>Employee</title> 
  </head> 
  <body> 
      <h1>Displaying Employee List</h1> 
      <table border ="1" align="center"> 
         <tr > 
          <th><b>Employee ID</b></th> 
          <th><b>Employee Name</b></th> 
          <th><b>Employee Salary</b></th> 
          <th><b>Employee Desg</b></th> 
         </tr> 
 <%ArrayList<Employee> std =  
            (ArrayList<Employee>)request.getAttribute("list"); 
        for(Employee e: std){%> 
            <tr> 
                <td><%=e.getEid()%></td> 
                <td><%=e.getEname()%></td> 
                <td><%=e.getSalary()%></td> 
                <td><%=e.getDesg()%></td> 
                <td><a href = "deleterow?eid='"+<%=e.getEid()%>+"'">Delete</a></td>
                
            </tr> 
            <%}%>
        </table>  
        <hr/> 
    </body> 
</html>