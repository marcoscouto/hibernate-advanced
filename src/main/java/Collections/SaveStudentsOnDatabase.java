package Collections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Map;
import java.util.logging.Logger;

public class SaveStudentsOnDatabase {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger("log4j");

        Student tempStudent = new Student();
        Map<String, String> images = tempStudent.getImages();

        tempStudent.setFirstName("Paul");
        tempStudent.setLastName("Wall");
        tempStudent.setEmail("paul@luv2code.com");

        images.put("photo1.jpeg", "photo 1");
        images.put("photo5.jpeg", "photo 5");
        images.put("photo2.jpeg", "photo 2");
        images.put("photo3.jpeg", "photo 3");
        images.put("photo4.jpeg", "photo 4");

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        logger.info("Begin the transaction...");
        session.beginTransaction();

        logger.info("Persist the data...");
        session.persist(tempStudent);

        logger.info("Commit...");
        session.getTransaction().commit();

        logger.info("Ending the session...");
        session.close();
        factory.close();

    }
}

