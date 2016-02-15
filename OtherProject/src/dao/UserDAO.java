package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import tables.Request;
import tables.User;

public interface UserDAO {
	public void addUser(User user) throws SQLException;
	public void updateUser(User user) throws SQLException;
	public void deleteUser(User user) throws SQLException;
	public void deleteHistory(User user) throws SQLException;
	public ArrayList<Request> getHistory(User user) throws SQLException;
	public User getUserById(Long id) throws SQLException;
	public User getUserByEmail(String email) throws SQLException;
	public User getUserByLogin(String login) throws SQLException;
	public ArrayList<User> getAllUsers() throws SQLException;

}
