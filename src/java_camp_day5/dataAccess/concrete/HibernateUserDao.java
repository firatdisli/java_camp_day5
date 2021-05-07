package java_camp_day5.dataAccess.concrete;

import java.util.ArrayList;
import java.util.List;

import java_camp_day5.dataAccess.abstracts.UserDao;
import java_camp_day5.entities.concrete.User;

public class HibernateUserDao implements UserDao{

	List<User> userList;
	public HibernateUserDao() {
		userList=new ArrayList<User>();
	}
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		this.userList.add(user);
		System.out.println("Hibernate ile eklendi "+user.getEmail());
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		this.userList.remove(user);
		System.out.println("Hibernate ile silindi "+user.getEmail());
	}

	@Override
	public User get(int id) {
User user = null;
		
		for (User iterator : this.userList)
		{
			if (iterator.getId() == id)
			{
				user = iterator;
				break;
			}
		}
		
		return user;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return this.userList;
	}
	
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User getEmail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
