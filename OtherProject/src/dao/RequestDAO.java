package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import tables.Request;
import util.HibernateUtil;


public class RequestDAO {
	
	private MainDAO instance = MainDAO.INSTANCE;

	
	public void addRequest(Request request) throws SQLException {
		instance.add(request);
	}

	
	public void updateRequest(Request request) throws SQLException {
		instance.update(request);
	}
	
	
	public void deleteStation(Request request) throws SQLException {
		instance.delete(request);
	}

	
	public Request getRequestById(Long id) throws SQLException {
		Session session = null;
		Request request = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			request = (Request)session.load(Request.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		if (request == null) {
        	return new Request();
        } else {
        	return request;
        }
	}

	
	@SuppressWarnings(value = "unchecked")
	public List<Request> getAllRequest() throws SQLException {
		Session session = null;
		List<Request> requests = new ArrayList<Request>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			requests.addAll(session.createCriteria(Request.class).list());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return requests;
	}
}

