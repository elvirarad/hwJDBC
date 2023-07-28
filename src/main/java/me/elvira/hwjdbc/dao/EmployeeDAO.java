package me.elvira.hwjdbc.dao;

import me.elvira.hwjdbc.model.Employee;

public interface EmployeeDAO {
    Employee findById(Integer id);

    void create(Employee employee);

    void deleteById(Integer id);
}
