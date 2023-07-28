package me.elvira.hwjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String first_name;
    private String last_name;
    private String gender;
    private Integer age;
    private Integer city_id;  // не забыть????????????

    public static Employee create(ResultSet resultSet) throws SQLException{
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setFirst_name(resultSet.getString("first_name"));
        employee.setLast_name(resultSet.getString("last_name"));
        employee.setAge(resultSet.getInt("age"));
        employee.setGender(resultSet.getString("gender"));
        employee.setCity_id(resultSet.getInt("id"));
        return employee;
    }
}
