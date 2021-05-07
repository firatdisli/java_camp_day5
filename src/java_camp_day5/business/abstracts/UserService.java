package java_camp_day5.business.abstracts;

import java.util.List;

import java_camp_day5.entities.concrete.User;

public interface UserService {

	void add(User user);
	void delete(User user);
	void update(User user);
	User getById(int id);
	List<User> getAll();
	void userVerify(User user,int verificationCode);
	
}
