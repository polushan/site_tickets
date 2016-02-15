package dao.impl;

import dao.RequestDAO;
import dao.SiteDAO;
import dao.CityDAO;
import dao.UserDAO;

public class Factory {
	
	private static Factory instance = null;
	private static RequestDAO requestDAO = null;
	private static SiteDAO siteDAO = null;
	private static CityDAO cityDAO = null;
	private static UserDAO userDAO = null;
    
    
    public static synchronized Factory getInstance(){
        if (instance == null){
          instance = new Factory();
        }
        return instance;
    }

    public static synchronized RequestDAO getRequestDAO(){
          if (requestDAO == null){
        	  requestDAO = new RequestDAOImpl();
          }
          return requestDAO;
    }

    
    public static synchronized SiteDAO getSiteDAO(){
        if (siteDAO == null){
        	siteDAO = new SiteDAOImpl();
        }
        return siteDAO;
  }
    
    public static synchronized CityDAO getCityDAO(){
        if (cityDAO == null){
        	cityDAO = new CityDAOImpl();
        }
        return cityDAO;
  }
    
    public static synchronized UserDAO getUserDAO(){
        if (userDAO == null){
        	userDAO = new UserDAOImpl();
        }
        return userDAO;
  }
    
}
