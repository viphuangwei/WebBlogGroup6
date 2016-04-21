package mum.ea.group6.webblog.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class UserAccount {
	@Id
	private long user_Id;
	private String password;
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	@OneToMany(mappedBy="user")
	private List<Comment> comments = new ArrayList<>();
	

	public UserAccount() {
		super();
	}

	public UserAccount(long user_Id, String password, User user) {
		super();
		this.user_Id = user_Id;
		this.password = password;
		this.user = user;
		
	}

	public long getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(long userId) {
		user_Id = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
   
	
}
