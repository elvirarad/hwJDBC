package hwjdbc.dao;

import hwjdbc.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee findById(Integer id);

    void create(Employee employee);

    void deleteById(int id);

    void getAllEmployee();

}
