package mum.ea.group6.webblog.service;

import java.util.Collection;

import mum.ea.group6.webblog.domain.UserAccount;

public interface UserAccountService {
	public UserAccount createUserAccount(long userId, String firstName, String lastName, String emailAddress,
			String password, String image);

	public UserAccount getUserAccount(long userId);

	public Collection<UserAccount> getAllUserAccounts();
	
	public boolean checkUser(long userId,String password);
	
	public void deleteUser(long userId);

	public UserAccount updateUserAccount(long userId, String firstName, String lastName, String emailAddress,
			String password,String image);
     
} 
