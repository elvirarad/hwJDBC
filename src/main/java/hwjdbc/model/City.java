package hwjdbc.model;

import lombok.*;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

//@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "city")

public class City {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer city_id;
    private String city_name;

    public City(Integer city_id, String city_name) {
        this.city_id = city_id;
        this.city_name = city_name;
    }

    public City(String city_name) {
        this.city_name = city_name;
    }

    public City() {
    }

    public static City create(ResultSet resultSet) throws SQLException {
        City city = new City();
        city.setCity_id(resultSet.getInt("city_id"));
        city.setCity_name(resultSet.getString("city_name"));
        return city;
    }

    @OneToMany(mappedBy = "city", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Employee> employees;

}
