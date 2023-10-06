package hwjdbc.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import hwjdbc.utils.HibernateSessionFactoryUtil;
import hwjdbc.model.Employee;

import javax.persistence.Query;


import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public Employee findById(Integer id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }

        @Override
    public void create(Employee employee) {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            try (session) {
                Transaction transaction = session.beginTransaction();
                session.save(employee);
//                session.persist(employee);
                transaction.commit();
            }
        }

    @Override
    public List<Employee> findAllEmployee(){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Employee").list();
        }
    }


    @Override
    public void deleteById(Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session){
            Transaction transaction = session.beginTransaction();
            Query query = session.createNativeQuery("DELETE FROM Employee WHERE id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        }
    }

    @Override
    public void update(Employee employee) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session){
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }

    }
}
