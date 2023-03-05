package lk.ijse.hybernate;

import lk.ijse.hybernate.embaded.CustName;
import lk.ijse.hybernate.entity.Customer;
import lk.ijse.hybernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DetachState {
    public static void main(String[] args) {
        Session session= SessionFactoryConfiguration.getInstance().getSession();

        Transaction transaction=session.beginTransaction();

        Customer customer = new Customer();
        customer.setId(1);
        customer.setAddress("Nawadagala");
        customer.setAge(21);
        customer.setSalary(60000);

        session.save(customer);
        transaction.commit();

        CustName custName = new CustName();
        custName.setFirstName("Gayani");
        custName.setMiddleName("Dewindi");
        custName.setLastName("Vitharana");
        customer.setName(custName);

        System.out.println(customer);// Detaclaed state
        session.close();

       // session.save(customer);
        Session session1=SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction1=session1.beginTransaction();

        session1.merge(customer);
        transaction1.commit();
        session1.close();

    }
}
