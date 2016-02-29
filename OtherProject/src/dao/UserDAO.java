package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import tables.Request;
import tables.User;
import util.HibernateUtil;

public class UserDAO {

	private MainDAO instance = MainDAO.INSTANCE;

	public void addUser(User user) throws SQLException {
		instance.add(user);
	}

	public void updateUser(User user) throws SQLException {
		instance.update(user);
	}

	public void deleteUser(User user) throws SQLException {
		deleteHistory(user);
		instance.delete(user);
	}

	public User getUserById(Long id) throws SQLException {
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			user = (User) session.load(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;
	}

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

	public void deleteHistory(User user) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			for (Request req : user.getHistory()) {
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

	public List<Request> getHistory(User user) throws SQLException {
		return user.getHistory();
	}

	public User getUserByEmail(String email) throws SQLException {
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			user = (User) session.createCriteria(User.class).add(Restrictions.eq("email", email)).uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;
	}

	public User getUserByLogin(String login) throws SQLException {
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			user = (User) session.createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();

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
