

import java.sql.SQLException;

import org.hibernate.Session;

/**
 * 
 * Тут реализованны основные методы работы с таблицей
 *
 */


enum MainDAO {
	INSTANCE;
	
	public <T>void add(T instance) throws SQLException {
		 Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(instance);
            session.getTransaction().commit();
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
		
	}

	
	public <T>void update(T instance) throws SQLException {
		Session session = null;
       try {
           session = HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.update(instance);
           session.getTransaction().commit();
       } catch (Exception e) {
    	   e.printStackTrace();
       } finally {
           if (session != null && session.isOpen()) {
               session.close();
           }
       }
		
	}

	
	public <T>void delete(T instance) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(instance);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
       }
		
	}
}
