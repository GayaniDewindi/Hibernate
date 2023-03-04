package lk.ijse.hybernate.util;

import lk.ijse.hybernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransientState {
    public static void main(String[] args) {
       Session session= SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        //Transient state
        Customer customer=new Customer();
        customer.setAddress("Elpitiya");
        customer.setAge(22);

        //persistent state

        session.save(customer);

        transaction.commit();
        session.close();

    }
}
