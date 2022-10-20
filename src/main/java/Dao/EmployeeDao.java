package Dao;


import com.EmployeeDetails;

import java.util.List;

public interface EmployeeDao {

    public void saveEmployee (EmployeeDetails employee);
    public List<EmployeeDetails> showAllEmployees();
    public void updateEmployee (int id, String ename, String enumber);
    public void deleteEmployee (int id);


}
