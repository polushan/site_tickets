package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import dao.RequestDAO;
import tables.Request;
import util.HibernateUtil;

class RequestDAOImpl implements RequestDAO {
	
	private MainDAOImpl instance = MainDAOImpl.INSTANCE;

	@Override
	public void addRequest(Request request) throws SQLException {
		instance.add(request);
	}

	@Override
	public void updateRequest(Request request) throws SQLException {
		instance.update(request);
	}
	
	@Override
	public void deleteStation(Request request) throws SQLException {
		instance.delete(request);
	}

	@Override
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
		return request;
	}

	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Request> getAllRequest() throws SQLException {
		Session session = null;
		List<Request> requests = new ArrayList<Request>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			requests = session.createCriteria(Request.class).list();
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
