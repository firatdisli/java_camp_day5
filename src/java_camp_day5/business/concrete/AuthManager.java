package java_camp_day5.business.concrete;

import java.util.regex.Pattern;

import java_camp_day5.business.abstracts.AuthService;
import java_camp_day5.core.utilities.BusinessRules;
import java_camp_day5.entities.concrete.User;

public class AuthManager implements AuthService {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public AuthManager() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean validate(User user) {
		boolean result=BusinessRules.Run(ifPasswordCheckLength(user),
				ifFirstNameCheckLength(user),
				ifLastNameCheckLength(user),
				ifEmailFormatCheckValid(user));
		return result;
	}
	private boolean ifPasswordCheckLength(User user) {
		if (user.getPassword().length()<6) {
			System.out.println("Parola en az 6 karakter olmalýdýr!");
			return false;
		}
		return true;
	}

	private boolean ifFirstNameCheckLength(User user) {
		if (user.getFirstName().length()<2) {
			System.out.println("Ýsim en az 2 karakter olmalýdýr!");
			return false;
		}
		return true;
	}
	private boolean ifLastNameCheckLength(User user) {
		if (user.getLastName().length()<2) {
			System.out.println("Soyad en az 2 karakter olmalýdýr!");
			return false;
		}
		return true;
	}
	private boolean ifEmailFormatCheckValid(User email) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(email.getEmail()).find();
	}
	@Override
	public boolean login(User user) {
		boolean result=BusinessRules.Run(isFirstandLastNameEmpty(user));
		return result;
	}
	
	private boolean isFirstandLastNameEmpty(User user) {
		if (user.getEmail()==null || user.getPassword()==null) {
			System.out.println("Kullanıcı adı veya parola eksik!");
			return false;
		}
		System.out.println("Sisteme giriş yapıldı!");
		return true;
	}

}
