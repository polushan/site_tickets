package dao;

import java.sql.SQLException;
import java.util.List;
import tables.Request;


public interface RequestDAO {
	public void addRequest(Request request) throws SQLException;
	public void updateRequest(Request request) throws SQLException;
	public void deleteStation(Request request) throws SQLException;		
	public Request getRequestById(Long id) throws SQLException;
	public List<Request> getAllRequest() throws SQLException;

}
