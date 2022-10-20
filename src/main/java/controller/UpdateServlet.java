package controller;

import Dao.EmployeeDaoImpl;
import com.EmployeeDetails;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        int employeeId = Integer.parseInt(req.getParameter("id"));
        String employeeName = req.getParameter("name");
        String number =req.getParameter("number");

        EmployeeDetails employee = new EmployeeDetails(employeeId,employeeName,number);

        new EmployeeDaoImpl().updateEmployee(employeeId,employeeName,number);
        out.println("<h2>Employee Updated Successfully <h2>");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("EmployeeAdd.jsp");
        requestDispatcher.include(req,resp);


    }
}
