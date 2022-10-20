package Dao;

import java.util.ArrayList;
import java.util.List;
import com.EmployeeDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void saveEmployee(EmployeeDetails employee) {
        Session session = HibernateUtil.getFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }

    @Override
    public List<EmployeeDetails> showAllEmployees() {
        List<EmployeeDetails> employeeList = new ArrayList();
        Session session = HibernateUtil.getFactory().openSession();
        Query query = session.createQuery("From EmployeeDetails");
        employeeList = query.list();
        return employeeList;
    }

    @Override
    public void updateEmployee(int id, String ename, String enumber) {
        Session session = HibernateUtil.getFactory().openSession();
        Transaction transaction = session.beginTransaction();
        EmployeeDetails empdetails = (EmployeeDetails)session.load(EmployeeDetails.class, id);
        empdetails.setEname(ename);
        empdetails.setEnumber(enumber);
        session.update(empdetails);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = HibernateUtil.getFactory().openSession();
        Transaction transaction = session.beginTransaction();
        EmployeeDetails employee=session.get(EmployeeDetails.class,id);
        session.delete(employee);
        transaction.commit();
        session.close();
    }

}