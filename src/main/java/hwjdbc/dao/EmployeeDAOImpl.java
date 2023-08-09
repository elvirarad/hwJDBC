package hwjdbc.dao;

import hwjdbc.HibernateSessionFactoryUtil;
import hwjdbc.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final Connection connection;

    public EmployeeDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public Employee findById(Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }

        @Override
    public void create(Employee employee) {
        Integer id;
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                id = (Integer) session.save(employee);
                transaction.commit();
            }
        }


    @Override
    public void deleteById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.remove(Employee.class);
        }
    }

    @Override
    public List<Employee> getAllEmployee(){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Employee").list();
        }
    };

}
