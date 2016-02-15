package dao;

import java.sql.SQLException;
import java.util.List;

import tables.Site;

public interface SiteDAO {
	public void addSite(Site site) throws SQLException;
	public void updateSite(Site site) throws SQLException;
	public void deleteSite(Site site) throws SQLException;
	public List<Site> getAllSites() throws SQLException;
	public Site getSiteByName(String name) throws SQLException;
	public Site getSiteByDomain(String domain) throws SQLException;
	
}
