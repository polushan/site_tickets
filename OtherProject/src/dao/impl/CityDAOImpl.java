package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import dao.CityDAO;
import tables.City;
import util.HibernateUtil;

class CityDAOImpl implements CityDAO {
	
	private MainDAOImpl instance = MainDAOImpl.INSTANCE;

	@Override
	public void addCity(City station) throws SQLException {
		instance.add(station);
	}
	
	@Override
	public void updateCity(City station) throws SQLException {
		instance.update(station);
		
	}

	@Override
	public void deleteCity(City station) throws SQLException {
		instance.delete(station);
		
	}

	@Override
	public City getCityById(String id) throws SQLException {
		Session session = null;
		City station = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			station = (City)session.load(City.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return station;
	}

	@Override
	@SuppressWarnings(value = "unchecked")
	public List<City> getAllCities() throws SQLException {
		Session session = null;
        List<City> stations = new ArrayList<City>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            stations = session.createCriteria(City.class).list();
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
		return stations;
	}

	@Override
	public City getCityByName(String name) throws SQLException {
		Session session = null;
		City city = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			city = (City)session.createCriteria(City.class)
					.add(Restrictions.eq("NAME", name))
					.uniqueResult();
							
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return city;
	}
}
