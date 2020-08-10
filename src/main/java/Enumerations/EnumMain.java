package Enumerations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Logger;

public class EnumMain {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger("log4j");

        Shop shop = new Shop();
        shop.setName("Loja 1");
        shop.setStatus(Status.ACTIVE);

        Shop shop2 = new Shop();
        shop2.setName("Loja 2");
        shop2.setStatus(Status.INACTIVE);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Shop.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        logger.info("Begin the transaction...");
        session.beginTransaction();

        logger.info("Saving...");
        session.persist(shop);
        session.persist(shop2);

        logger.info("Commit...");
        session.getTransaction().commit();

        logger.info("Ending the session...");
        session.close();
        factory.close();

    }
}
