package Collections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Logger;

public class GetStudentsOnDatabase {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger("log4j");

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        logger.info("Begin the transaction...");
        session.beginTransaction();

        logger.info("Get the data...");

        logger.info("Student details: " + session.get(Student.class, 1).toString());

        logger.info("Commit...");
        session.getTransaction().commit();

        logger.info("Ending the session...");
        session.close();
        factory.close();


    }

}
