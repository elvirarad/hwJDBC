package hwjdbc.model;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;

@ToString(of = {"id", "first_name"})
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "employee")

public class Employee {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String first_name;
    private String last_name;
    private String gender;
    private Integer age;
    //private Integer city_id;


    public static Employee create (ResultSet resultSet) throws SQLException{
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setFirst_name(resultSet.getString("first_name"));
        employee.setLast_name(resultSet.getString("last_name"));
        employee.setGender(resultSet.getString("gender"));
        employee.setAge(resultSet.getInt("age"));
        return employee;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private City city;

}
