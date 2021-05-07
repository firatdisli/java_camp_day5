package java_camp_day5.business.concrete;

import java.util.ArrayList;
import java.util.List;

import java_camp_day5.business.abstracts.EmailService;
import java_camp_day5.business.abstracts.UserService;
import java_camp_day5.business.abstracts.AuthService;
import java_camp_day5.dataAccess.abstracts.UserDao;
import java_camp_day5.entities.concrete.User;

public class UserManager implements UserService{

	//Github selim-baskaya-22 'den alýnmýþtýr
	
	private UserDao userDao;
	private java_camp_day5.business.abstracts.AuthService authService;
	private EmailService emailService;
	
	public UserManager(UserDao userDao, AuthService authService, EmailService emailService) {
		super();
		this.userDao = userDao;
		this.authService = authService;
		this.emailService = emailService;
	}
	
	List<User> users=new ArrayList<User>();
	public UserManager() {
		users.add((User) this.getAll());
	}

	@Override
	public void add(User user) {
		if (userCheck(user.getEmail()) &&authService.validate(user)) {
			userDao.add(user);
			System.out.println("Doðrulama Kodunuz Mail Olarak Gönderildi! Doðrulama Kodunuz: "+emailService.mailSend());
			System.out.print("Doðrulama Kodunu Giriniz: ");
			return;			
		}
		System.out.println("Kullanýcý Bilgilerini Kontrol Ediniz!");
		
	}

	@Override
	public void delete(User user) {
		this.userDao.delete(user);
		
	}

	@Override
	public void update(User user) {
		this.userDao.update(user);
		
	}

	@Override
	public User getById(int id) {
		User result=this.userDao.get(id);
		return result;
	}

	@Override
	public List<User> getAll() {
		List<User> result=this.userDao.getAll();
		return result;
	}

	@Override
	public void userVerify(User user, int verificationCode) {
		int result=emailService.mailSend();
		if (result==verificationCode) {
			
			System.out.println("Kullanýcý doðrulandý. Üyeliðiniz Tamamlandý!!! "+user.getFirstName());
		}
		else {
			System.out.println("Doðrulama kodunuz yanlýþ!");
		}
		
	}

	public boolean userCheck(String mail) {
		if (userDao.getEmail(mail)!=null) {
			System.out.println("Kullanýcý mevcut!");
			return false;
		}
	
	

		
		return true;
	
	}

}
