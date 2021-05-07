package java_camp_day5.business.concrete;

import java.util.ArrayList;
import java.util.List;

import java_camp_day5.business.abstracts.EmailService;
import java_camp_day5.business.abstracts.UserService;
import java_camp_day5.business.abstracts.AuthService;
import java_camp_day5.dataAccess.abstracts.UserDao;
import java_camp_day5.entities.concrete.User;

public class UserManager implements UserService{

	//Github selim-baskaya-22 'den al�nm��t�r
	
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
			System.out.println("Do�rulama Kodunuz Mail Olarak G�nderildi! Do�rulama Kodunuz: "+emailService.mailSend());
			System.out.print("Do�rulama Kodunu Giriniz: ");
			return;			
		}
		System.out.println("Kullan�c� Bilgilerini Kontrol Ediniz!");
		
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
			
			System.out.println("Kullan�c� do�ruland�. �yeli�iniz Tamamland�!!! "+user.getFirstName());
		}
		else {
			System.out.println("Do�rulama kodunuz yanl��!");
		}
		
	}

	public boolean userCheck(String mail) {
		if (userDao.getEmail(mail)!=null) {
			System.out.println("Kullan�c� mevcut!");
			return false;
		}
	
	

		
		return true;
	
	}

}
