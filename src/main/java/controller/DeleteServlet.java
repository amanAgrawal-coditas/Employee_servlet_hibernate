package controller;

import Dao.EmployeeDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        int employeeId = Integer.parseInt(req.getParameter("id"));


        new EmployeeDaoImpl().deleteEmployee(employeeId);

        out.println("<h2>Employee Deleted Successfully <h2>");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("EmployeeAdd.jsp");
        requestDispatcher.include(req, resp);
    }
}