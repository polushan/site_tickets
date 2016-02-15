package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dao.SiteDAO;
import tables.Site;
import util.HibernateUtil;

class SiteDAOImpl implements SiteDAO {

	private MainDAOImpl instance = MainDAOImpl.INSTANCE;
	
	@Override
	public void addSite(Site site) throws SQLException {
		instance.add(site);
	}

	@Override
	public void updateSite(Site site) throws SQLException {
		instance.update(site);
	}

	@Override
	public void deleteSite(Site site) throws SQLException {
		instance.delete(site);
	}

	@Override
	@SuppressWarnings(value = "unchecked")
	public List<Site> getAllSites() throws SQLException {
		Session session = null;
        List<Site> sites = new ArrayList<Site>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            sites = session.createCriteria(Site.class).list();
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return sites;
	}

	@Override
	public Site getSiteByName(String name) throws SQLException {
		Session session = null;
        Site site = null;
        try {
			session = HibernateUtil.getSessionFactory().openSession();
			site = (Site)session.createCriteria(Site.class)
					.add(Restrictions.eq("NAME", name)).uniqueResult();
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return site;
	}


	@Override
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
        return site;
	}

}
