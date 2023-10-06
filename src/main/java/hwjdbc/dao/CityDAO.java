package hwjdbc.dao;

import hwjdbc.model.City;

import java.util.List;

public interface CityDAO {
    City findById(Integer id);

    void create(City city);

    void deleteById(Integer id);

    void delete(City city);

    List<City> findAll();

    void update(City city);
}
