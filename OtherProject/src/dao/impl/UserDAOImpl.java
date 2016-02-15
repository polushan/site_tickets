package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dao.UserDAO;
import tables.Request;
import tables.User;
import util.HibernateUtil;

class UserDAOImpl implements UserDAO {

	private MainDAOImpl instance = MainDAOImpl.INSTANCE;
	
	@Override
	public void addUser(User user) throws SQLException {
		instance.add(user);	
	}

	@Override
	public void updateUser(User user) throws SQLException {
		instance.update(user);
	}

	@Override
	public void deleteUser(User user) throws SQLException {
		deleteHistory(user);
		instance.delete(user);
	}

	@Override
	public User getUserById(Long id) throws SQLException {
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			user = (User)session.load(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		
		return user;
	}

	@Override
	@SuppressWarnings(value = "unchecked")
	public ArrayList<User> getAllUsers() throws SQLException {
		Session session = null;
		ArrayList<User> users = new ArrayList<User>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            users.addAll(session.createCriteria(User.class).list());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
	}
	

	@Override
	public void deleteHistory(User user) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			for (Request req: user.getHistory()) {
				session.delete(req);
			}
			user.setHistory(null);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
       }
		
	}

	@Override
	public ArrayList<Request> getHistory(User user) throws SQLException {
		return user.getHistory();
	}

	@Override
	public User getUserByEmail(String email) throws SQLException {
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			user = (User)session.createCriteria(User.class)
					.add(Restrictions.eq("EMAIL", email))
					.uniqueResult();
							
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;
	}

	@Override
	public User getUserByLogin(String login) throws SQLException {
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			user = (User)session.createCriteria(User.class)
					.add(Restrictions.eq("LOGIN", login))
					.uniqueResult();
							
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;
	}
}
