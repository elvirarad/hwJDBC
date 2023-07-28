package me.elvira.hwjdbc;

import me.elvira.hwjdbc.dao.CityDAOImpl;
import me.elvira.hwjdbc.dao.EmployeeDAOImpl;
import me.elvira.hwjdbc.model.City;
import me.elvira.hwjdbc.model.Employee;

import java.sql.*;

public class HwJdbcApplication {

    public static void main(String[] args) throws SQLException {

// Создаем переменные с данными для подключения к базе
        final String user = "postgres";
        final String password = "*2gether!";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        // Создаем соединение с базой с помощью Connection
        // Формируем запрос к базе с помощью PreparedStatement
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             //PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")
             Statement statement = connection.createStatement()
        ) {

            ResultSet resultSet = statement.executeQuery("SELECT id, first_name, last_name, age, gender, city_name FROM employee LEFT JOIN city ON  employee.city_id = city.city_id;");
            // Подставляем значение вместо wildcard
            //statement.setInt(1, 4);

            // Делаем запрос к базе и результат кладем в ResultSet
            //final ResultSet resultSet = statement.executeQuery();

            // Методом next проверяем есть ли следующий элемент в resultSet
            // и одновременно переходим к нему, если таковой есть
            while (resultSet.next()) {

                // С помощью методов getInt и getString получаем данные из resultSet
                String first_name = " first_name: " + resultSet.getString("first_name");
                String last_name = " last_name: " + resultSet.getString("last_name");
                String gender = " gender: " + resultSet.getString("gender");
                String city = " city: " + resultSet.getString("city_name");
                int age = resultSet.getInt(4);

                // Выводим данные в консоль
                System.out.println("id: " + resultSet.getInt("id") + first_name + last_name + " Age: " + age + gender + city);

            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        Connection connection = DriverManager.getConnection(url, user, password);

        CityDAOImpl cityDAO = new CityDAOImpl(connection);
        System.out.println(cityDAO.findById(2));

//        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(connection);
//        System.out.println(employeeDAO.findById(10));

        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl(connection);
        employeeDAO.create(new Employee(11, "Tom", "Ford", "men", 24, 4));
        System.out.println(employeeDAO.findById(11));
    }
}
