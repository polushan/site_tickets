

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;



public class CityDAO {
	
	private MainDAO instance = MainDAO.INSTANCE;

	
	public void addCity(City station) throws SQLException {
		instance.add(station);
	}
	
	
	public void updateCity(City station) throws SQLException {
		instance.update(station);
		
	}

	
	public void deleteCity(City station) throws SQLException {
		instance.delete(station);
		
	}

	
	public City getCityById(String id) throws SQLException {
		Session session = null;
		City city = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			city = (City)session.load(City.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		if (city == null) {
			return new City();
		} else {
			return city;
		}
	}

	
	@SuppressWarnings(value = "unchecked")
	public List<City> getAllCities() throws SQLException {
		Session session = null;
        List<City> cities = new ArrayList<City>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            cities.addAll(session.createCriteria(City.class).list());
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
		return cities;
	}

	
	public City getCityByName(String name) throws SQLException {
		Session session = null;
		City city = null; 
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			city = (City)session.createCriteria(City.class)
					.add(Restrictions.eq("name", name))
					.uniqueResult();
							
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		if (city == null) {
			return new City();
		} else {
			return city;
		}
	}
}
