package Embedded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Logger;

public class EmbeddedMain {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger("log4j");

        Employee employee = new Employee();
        employee.setFirstName("Marcos");
        employee.setLastName("Couto");
        employee.setEmail("marcos@couto.com");

        Company company = new Company();
        company.setCnpj("1238217312");
        company.setName("Coca Cola Company");

        Address address = new Address();
        address.setCity("São Paulo");
        address.setStreet("Rua de São Paulo");
        address.setZipcode("99999-999");

        employee.setAddress(address);
        company.setAddress(address);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        logger.info("Begin the transaction...");
        session.beginTransaction();

        logger.info("Saving employee...");
        session.persist(employee);
        session.persist(company);

        logger.info("Commit...");
        session.getTransaction().commit();

        logger.info("Ending the session...");
        session.close();
        factory.close();

    }
}
