package util;

import java.util.Locale;

import org.hibernate.Session;

public class App {
	public static void main(String[] args) {

		System.out.println("Hibernate many to many (Annotation)\"");
		Locale.setDefault(Locale.US);
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
			
		}
		System.out.println("Done");
	}
}
