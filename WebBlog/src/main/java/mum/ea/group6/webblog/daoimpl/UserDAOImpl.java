package mum.ea.group6.webblog.daoimpl;

import java.sql.ResultSet;
import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import mum.ea.group6.webblog.dao.UserDAO;
import mum.ea.group6.webblog.domain.Admin;
import mum.ea.group6.webblog.domain.UserAccount;

public class UserDAOImpl implements UserDAO {

	private SessionFactory sf;
    
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public void saveUser(UserAccount user) {
		sf.getCurrentSession().persist(user);
		
	}

	public void updateUser(UserAccount user) {
		sf.getCurrentSession().saveOrUpdate(user);
		
		
	}

	public UserAccount loadUser(long userId) {
		return (UserAccount)sf.getCurrentSession().get(UserAccount.class, userId);
		
	}

	public void delete(UserAccount user) {
		sf.getCurrentSession().delete(user);
		
	}
	@SuppressWarnings("unchecked")
	public Collection<UserAccount> getUser() {
	
		 return sf.getCurrentSession().createQuery("select u from UserAccount u join fetch u.user ").list();
	}

	
	public boolean checkUser(long userId, String password) {
	Query q= sf.getCurrentSession().createQuery("from UserAccount where user_id = :userId and password = :password");
	q.setParameter("userId", userId); 
	q.setParameter("password", password);
	return (q.uniqueResult() != null);
	}
	
	
	
}
