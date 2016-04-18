package mum.ea.group6.webblog.domain;

import java.awt.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	private long UserId;
	private String firstName;
	private String lastName;
	private String image;
	private String emailAddress;

	public User() {
		super();
	}
	

	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public User(long userId, String firstName, String lastName,String emailAddress,String image ) {
		super();
		UserId = userId;
		this.firstName = firstName;
		this.lastName=lastName;
		this.emailAddress = emailAddress;

		this.image=image;
	}

	public long getUserId() {
		return UserId;
	}

	public void setUserId(long userId) {
		UserId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
   
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	

}
