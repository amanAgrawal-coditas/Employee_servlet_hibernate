package controller;

import Dao.EmployeeDaoImpl;
import com.EmployeeDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/Display")
    public class DisplayServlet extends HttpServlet {
    private HttpServletRequest req;
    private HttpServletResponse resp;

    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        this.req = req;
        this.resp = resp;
        resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();

            List<EmployeeDetails> employeeList = new EmployeeDaoImpl().showAllEmployees();

            out.println("USER DATA : ");

            out.println("<table border=4 px >" +
                    "  <tr>" +
                    "    <th>Id</th><th>Employee Name</th><th>Employee Number </th>\n" +
                    "  </tr>");


            for (int i = 0 ; i < employeeList.size();i++)
            {
                EmployeeDetails employee = employeeList.get(i);
                out.println("<tr><td>" + employee.getId()+ "</td>" +
                        "<td>" + employee.getEname() + "</td>" +
                        "<td>" + employee.getEnumber() + "</td>" +
                        "</tr>"
                );



            }
            out.println("</table>");
            out.println("<a href='EmployeeAdd.jsp'><input type='button' value ='Back To Home'></a>");
        }


    }
