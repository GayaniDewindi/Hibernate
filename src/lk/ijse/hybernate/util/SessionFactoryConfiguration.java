package lk.ijse.hybernate.util;

import lk.ijse.hybernate.entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfiguration {

    private static SessionFactoryConfiguration factoryConfiguration;
    private  final SessionFactory sessionFactory;
    public static SessionFactoryConfiguration getInstance() {
        return (null == factoryConfiguration)
                ? factoryConfiguration = new SessionFactoryConfiguration() : factoryConfiguration;
    }

    public SessionFactoryConfiguration() {
       /* sessionFactory = new MetadataSources( new StandardServiceRegistryBuilder()
                .configure()
                .build()).addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build().getSessionFactoryBuilder()
                .build();*/
        /*Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class);
        sessionFactory = configuration.buildSessionFactory();*/
        // Configuration ek simplifil kr gtt.
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Customer.class)
                 .buildSessionFactory();


    }

    public Session getSession() throws HibernateException {
        //creating the service register
      /* StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();*/

        // creating the metadata object
        /*Metadata metadata = new MetadataSources( new StandardServiceRegistryBuilder()
                .configure()
                .build()).addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();*/

       /* sessionFactory = new MetadataSources( new StandardServiceRegistryBuilder()
                .configure()
                .build()).addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build().getSessionFactoryBuilder()
                .build();*/

        Session session = sessionFactory.openSession();

        return session;
    }
}
