package hwjdbc.dao;

import hwjdbc.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee findById(Integer id);

    void create(Employee employee);

     List<Employee> findAllEmployee();

    void deleteById(Integer id);

    void update (Employee employee);

}
