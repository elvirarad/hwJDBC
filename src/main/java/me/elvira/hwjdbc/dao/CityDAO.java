package me.elvira.hwjdbc.dao;

import me.elvira.hwjdbc.model.City;

public interface CityDAO {
    City findById(Integer id);

    void create(City city);

    void deleteById(Integer id);
}
