package lk.ijse.hybernate.repository;

import lk.ijse.hybernate.entity.Customer;
import lk.ijse.hybernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

public class CustomerRepository {
    private final Session session;
    
    public CustomerRepository() {
        session= SessionFactoryConfiguration.getInstance().getSession();
    }
    public  Long saveCustomer(Customer customer){
        Transaction transaction=session.beginTransaction();
       /* Integer id = (Integer)session.save(customer);
        transaction.commit()*/;
        try{
            Long id = (Long)session.save(customer);
            transaction.commit();
            session.close();
            return id;
        }catch (Exception ex){
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return -1l;
        }


    }
    public boolean updateCustomer(Customer customer){
        Transaction transaction=session.beginTransaction();
        try{
            session.update(customer);
            transaction.commit();
            session.close();
            return  true;
        }catch (Exception ex){
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return false;
        }
    }
    public Customer getCustomer(long id){
        try {
            Customer customer= session.get(Customer.class, id);
            session.close();
            return customer;

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }
    public boolean deleteCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(customer);
            transaction.commit();
            return true;

        }catch (Exception ex){
            transaction.rollback();
            ex.printStackTrace();
            return false;
        }

    }
}
