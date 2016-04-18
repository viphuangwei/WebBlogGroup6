package mum.ea.group6.webblog.dao;

import java.util.Collection;

import mum.ea.group6.webblog.domain.Post;
import mum.ea.group6.webblog.domain.UserAccount;


public interface UserDAO {
	public void saveUser(UserAccount user);
	public void updateUser(UserAccount user);
	public UserAccount loadUser(long userId);
	public void delete(UserAccount user);
	public boolean checkUser(long userId,String password);	
	public Collection<UserAccount> getUser();
}
