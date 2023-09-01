package hwjdbc;

import hwjdbc.dao.EmployeeDAO;
import hwjdbc.dao.EmployeeDAOImpl;
import hwjdbc.model.Employee;

import java.sql.*;

public class HwJdbcApplication {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee = new Employee (null, "Ted", "Li", "men", 45, 2);

        employeeDAO.create(employee);
        System.out.println(employee);

        employeeDAO.deleteById (13);

        System.out.println(employeeDAO.findById(12));

        employeeDAO.findAllEmployee().forEach(System.out::println);

        Employee byId = employeeDAO.findById(4);
        byId.setAge(21);
        employeeDAO.update(byId);
        System.out.println(byId);
        System.out.println(employeeDAO.findById(4));

    }
}
