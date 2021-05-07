package java_camp_day5;

import java.util.Scanner;

import java_camp_day5.business.abstracts.AuthService;
import java_camp_day5.business.abstracts.UserService;
import java_camp_day5.core.adapters.googleRegisterAdapter;
import java_camp_day5.entities.concrete.User;
import java_camp_day5.dataAccess.abstracts.UserDao;
import java_camp_day5.dataAccess.concrete.HibernateUserDao;
import java_camp_day5.business.concrete.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		//UserService userService=new UserManager(new InMemoryUserDao(),new AuthManager(),new EmailManager());
		AuthService googleManager=new googleRegisterAdapter();
	
		User user=new User();
		user.setId(1);
		user.setFirstName("Selimaa");
		user.setLastName("Baþkaya");
		user.setEmail("selimbaskaya34@gmail.com");
    	user.setPassword("yapma1991");
		User user2=new User();
		user2.setId(2);
		user2.setFirstName("Selimaaaaaaaaaa");
	    user2.setLastName("Baþkaya");
		user2.setEmail("selimbaskaya34@gmail.com");
    	user2.setPassword("yapma1991");
		
		
		

		UserService userService=new UserManager(new HibernateUserDao(),new AuthManager(),new EmailManager());
		userService.getAll();
	
		userService.add(user);
		
		int verificationCode=scan.nextInt();
		userService.userVerify(user, verificationCode);



		userService.add(user2);

	}

}
