package java_camp_day5.core.adapters;

import java_camp_day5.business.abstracts.AuthService;
import java_camp_day5.core.utilities.BusinessRules;
import java_camp_day5.entities.concrete.User;
import java_camp_day5.googleAuth.GoogleAutManager;

public class googleRegisterAdapter implements AuthService{

	GoogleAutManager googleAuthManager=new GoogleAutManager();
	@Override
	public boolean validate(User user) {
		boolean result = false;

		result = googleAuthManager.googleAuth(user.getEmail(),user.getPassword());
		if (result != true) {
			return false;
		}
		System.out.println("Google ile kayýt olundu!");
		return true;
	}

	@Override
	public boolean login(User user) {
		boolean result=BusinessRules.Run(isFirstandLastNameEmpty(user));
		return result;
	}
	private boolean isFirstandLastNameEmpty(User user) {
		if (user.getEmail()==null || user.getPassword()==null) {
			System.out.println("Kullanýcý adý veya parola eksik!");
			return false;
		}
		System.out.println("Sisteme giriþ yapýldý!");
		return true;
	}

}
