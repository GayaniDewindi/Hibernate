package lk.ijse.hybernate;

import jdk.internal.org.objectweb.asm.util.TraceAnnotationVisitor;
import lk.ijse.hybernate.embaded.CustName;
import lk.ijse.hybernate.embaded.MobilNumber;
import lk.ijse.hybernate.entity.Customer;
import lk.ijse.hybernate.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AppInitializer {
    public static void main(String[] args) {
        Customer customer=new Customer();
        customer.setId(1);
        /*customer.setName("Gayani");
        customer.setAddress("Elpitiya");
        customer.setSalary(30000.00);
*/
        CustName custName=new CustName();

        custName.setLastName("Janith");
        custName.setMiddleName("Iduwara");
        custName.setLastName("Nanayakakkara");

        customer.setName(custName);
        customer.setAddress("galle");
        customer.setSalary(40000.00);

        List<MobilNumber>phoneNumbers =new ArrayList<>();
        phoneNumbers.add(new MobilNumber("MOBITEL","0714563234"));
        phoneNumbers.add(new MobilNumber("DIOLOG","0760904402"));
        customer.setPhoneNo(phoneNumbers);

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        session.save(customer);
        transaction.commit();
        // thani table ekata transaction gahann on save unam commit karnn on session close krnn on.


        session.close();
    }
}
