package hwjdbc.dao;

import hwjdbc.model.City;

public interface CityDAO {
    City findById(Integer id);

    void create(City city);

    void deleteById(Integer id);
}
