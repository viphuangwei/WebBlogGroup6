package mum.ea.group6.webblog.serviceimpl;

import java.util.Collection;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.group6.webblog.dao.UserDAO;
import mum.ea.group6.webblog.domain.User;
import mum.ea.group6.webblog.domain.UserAccount;
import mum.ea.group6.webblog.service.UserAccountService;

public class UserAccountServiceImpl implements UserAccountService {
	private UserDAO userDao;

	public UserAccountServiceImpl(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public UserAccount createUserAccount(long userId, String firstName, String lastName, String emailAddress,
			String password,String image) {
		User student = new User(userId, firstName, lastName, emailAddress, image);
		UserAccount userAccount = new UserAccount(userId, password, student);
		userDao.saveUser(userAccount);
		return userAccount;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public UserAccount getUserAccount(long userId) {
		return userDao.loadUser(userId);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Collection<UserAccount> getAllUserAccounts() {
		return userDao.getUser();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deleteUser(long userId) {
		UserAccount user = userDao.loadUser(userId);
		userDao.delete(user);

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public UserAccount updateUserAccount(long userId, String firstName, String lastName, String emailAddress,
			String password,String image) {

		User student = new User(userId, firstName, lastName, emailAddress,image);
		UserAccount user = new UserAccount(userId, password, student);
		userDao.updateUser(user);

		return user;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean checkUser(long userId, String password) {
		
		return userDao.checkUser(userId, password);
	}

}
