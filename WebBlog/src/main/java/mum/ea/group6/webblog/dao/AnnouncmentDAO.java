package mum.ea.group6.webblog.dao;

import java.util.Collection;

import mum.ea.group6.webblog.domain.Admin;
import mum.ea.group6.webblog.domain.Announcment;


public interface AnnouncmentDAO {
	public void saveAnnouncment(Announcment announcment);
	public void updateAnnouncment(Announcment announcment);
	public Announcment loadAnnouncment(long id);
	public void delete(Announcment announcment);
	public Collection<Announcment> getAnnouncment();
}
