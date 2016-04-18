package mum.ea.group6.webblog.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Category {
	@Id
	@GeneratedValue
	private long id;

	private String type;

	private String place;
	@Temporal(TemporalType.DATE)
	private Date date;

	public Category() {
		super();
	}

	public Category(String place, String type ,Date date) {
		super();
		this.place = place;
		this.type=type;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	

	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	

}
