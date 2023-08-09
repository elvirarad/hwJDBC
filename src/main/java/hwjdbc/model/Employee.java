package hwjdbc.model;

import lombok.*;

import javax.persistence.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employee")
@EqualsAndHashCode(exclude = {"id"})

public class Employee {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   //@Column(name = "first_name") //если совпадают имя переменной и название столбца, @Column не указывается
    private String first_name;
   //@Column(name = "last_name")
    private String last_name;
    private String gender;
    private int age;
    //@Column(name = "city_id")
    private int city_id;  // не забыть????????????

    public static Employee create(ResultSet resultSet) throws SQLException{
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setFirst_name(resultSet.getString("first_name"));
        employee.setLast_name(resultSet.getString("last_name"));
        employee.setGender(resultSet.getString("gender"));
        employee.setAge(resultSet.getInt("age"));
        employee.setCity_id(resultSet.getInt("id"));
        return employee;
    }
}
