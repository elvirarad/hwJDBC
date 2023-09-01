package hwjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class City {
    private Integer city_id;
    private String city_name;

    public static City create(ResultSet resultSet) throws SQLException {
        City city = new City();
        city.setCity_id(resultSet.getInt("city_id"));
        city.setCity_name(resultSet.getString("city_name"));
        return city;
    }
}
