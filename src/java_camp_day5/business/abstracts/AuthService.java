package java_camp_day5.business.abstracts;

import java_camp_day5.entities.concrete.User;

public interface AuthService {

	boolean validate(User user);
	boolean login(User user);
}
