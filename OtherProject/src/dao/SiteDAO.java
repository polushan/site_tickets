package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import tables.Site;
import util.HibernateUtil;

public class SiteDAO {

	private MainDAO instance = MainDAO.INSTANCE;
	
	
	public void addSite(Site site) throws SQLException {
		instance.add(site);
	}

	
	public void updateSite(Site site) throws SQLException {
		instance.update(site);
	}

	
	public void deleteSite(Site site) throws SQLException {
		instance.delete(site);
	}

	
	@SuppressWarnings(value = "unchecked")
	public List<Site> getAllSites() throws SQLException {
		Session session = null;
        List<Site> sites = new ArrayList<Site>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            sites.addAll(session.createCriteria(Site.class).list());
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return sites;
	}

	
	public Site getSiteByName(String name) throws SQLException {
		Session session = null;
        Site site = null;
        try {
			session = HibernateUtil.getSessionFactory().openSession();
			site = (Site)session.createCriteria(Site.class)
					.add(Restrictions.eq("name", name)).uniqueResult();
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        if (site == null) {
        	return new Site();
        } else {
        	return site;
        }
	}


	public Site getSiteByDomain(String domain) throws SQLException {
		Session session = null;
        Site site = null;
        try {
			session = HibernateUtil.getSessionFactory().openSession();
			site = (Site) session.load(Site.class, domain);
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        if (site == null) {
        	return new Site();
        } else {
        	return site;
        }
	}

}
