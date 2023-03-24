package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Classes;
import entity.Student;
import entity.Subject;
import entity.Teacher;

public class HibernateUtil {
	public static SessionFactory buildSessionFactory() {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		return sessionFactory;

	}
}
