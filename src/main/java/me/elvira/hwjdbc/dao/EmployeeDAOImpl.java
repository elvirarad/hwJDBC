package me.elvira.hwjdbc.dao;

import me.elvira.hwjdbc.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final Connection connection;

    public EmployeeDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public Employee findById(Integer id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee  WHERE id = (?)")) {
            preparedStatement.setInt(1, id);
            preparedStatement.setMaxRows(1);

            // ResultSet превращаем в Employee
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            return Employee.create(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        @Override
    public void create(Employee employee) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)")) {
            //(id, first_name, last_name, age, gender, city_id)

            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getFirst_name());
            preparedStatement.setString(3, employee.getLast_name());
            preparedStatement.setString(4, employee.getGender());
            preparedStatement.setInt(5, employee.getAge());
            preparedStatement.setInt(6, employee.getCity_id());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }

    @Override
    public void deleteById(Integer id) {

    }
}
