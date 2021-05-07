package java_camp_day5.dataAccess.abstracts;

import java.util.List;

import java_camp_day5.entities.concrete.User;

public interface UserDao {

	void add(User user);
	void delete(User user);
	User get(int id);
	List<User> getAll();
	void update(User user);
	User getEmail(String mail);
}
