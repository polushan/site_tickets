package dao;

import java.sql.SQLException;
import java.util.List;

import tables.City;


public interface CityDAO {
	public void addCity(City station) throws SQLException;
	public void updateCity(City station) throws SQLException;
	public void deleteCity(City station) throws SQLException;
	public City getCityByName(String name) throws SQLException;
	public City getCityById(String id) throws SQLException;
	public List<City> getAllCities() throws SQLException;
}
