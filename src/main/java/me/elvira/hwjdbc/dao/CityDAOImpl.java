package me.elvira.hwjdbc.dao;

import me.elvira.hwjdbc.model.City;
import me.elvira.hwjdbc.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAOImpl implements CityDAO {

    private final Connection connection;

    public CityDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public City findById(Integer id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM city WHERE city_id = (?)")) {
            preparedStatement.setInt(1, id);
            preparedStatement.setMaxRows(1);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            return City.create(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(City city) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
