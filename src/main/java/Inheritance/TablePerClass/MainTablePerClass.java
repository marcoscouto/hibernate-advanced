package Inheritance.TablePerClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Logger;

public class MainTablePerClass {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger("log4j");

        StudentUser student = new StudentUser();
        student.setFirstName("Marcos");
        student.setLastName("Couto");
        student.setEmail("marcos@couto.com.br");
        student.setCourse("Sistemas de Informação");

        InstructorUser instructor = new InstructorUser();
        instructor.setFirstName("Vinicius");
        instructor.setLastName("Couto");
        instructor.setEmail("vinicius@couto.com.br");
        instructor.setSalary(2000.00);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(StudentUser.class)
                .addAnnotatedClass(InstructorUser.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        logger.info("Begin the transaction...");
        session.beginTransaction();

        logger.info("Saving...");
        session.persist(student);
        session.persist(instructor);

        logger.info("Commit...");
        session.getTransaction().commit();

        logger.info("Ending the session...");
        session.close();
        factory.close();
    }
}
