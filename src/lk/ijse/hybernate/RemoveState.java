package lk.ijse.hybernate;

import lk.ijse.hybernate.entity.Customer;
import lk.ijse.hybernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RemoveState {
    public static void main(String[] args) {
        Session session= SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();


        Customer customer= session.get(Customer.class,1l);
        session.delete(customer);//Remove state

        transaction.commit();
        session.close();
    }
}
