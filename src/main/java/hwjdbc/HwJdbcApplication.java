package hwjdbc;

import hwjdbc.dao.CityDAO;
import hwjdbc.dao.CityDAOImpl;
import hwjdbc.dao.EmployeeDAO;
import hwjdbc.dao.EmployeeDAOImpl;
import hwjdbc.model.City;
import hwjdbc.model.Employee;

import java.sql.*;
import java.util.List;

public class HwJdbcApplication {

    public static void main(String[] args) {

        CityDAO cityDAO = new CityDAOImpl();

        City byId = cityDAO.findById(10);
        System.out.println(byId);
        cityDAO.delete(byId);

        City city = new City();
        city.setCity_name("Tokio");

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee = new Employee();
        employee.setFirst_name("Fil");
        employee.setLast_name("Collins");
        employee.setGender("men");
        employee.setAge(45);

        // как добавить сотрудника с существующим городом?

        employee.setCity(city);

        employeeDAO.create(employee);

        employeeDAO.deleteById (6);

        Employee employee2 = new Employee (null, "Den", "Braun", "men", 55, new City("London"));
        employeeDAO.create(employee2);
        System.out.println(employee);

        System.out.println(employeeDAO.findById(12));

        employeeDAO.findAllEmployee().forEach(System.out::println);

        Employee byId2 = employeeDAO.findById(4);
        byId2.setAge(21);
        employeeDAO.update(byId2);
        System.out.println(byId);
        System.out.println(employeeDAO.findById(4));

        city = new City("Oslo");
        cityDAO.create(city);

        System.out.println(cityDAO.findById(3));

        List<City> cityList = cityDAO.findAll();
        cityList.forEach(System.out::println);

        cityDAO.deleteById(3);

    }
}
