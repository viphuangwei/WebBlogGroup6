package mum.ea.group6.webblog.service;

import java.util.Collection;
import java.util.Date;

import mum.ea.group6.webblog.domain.Announcment;

public interface AnnouncmentService {
	public Announcment createAnnouncment(String title, String discription,String image ,Date date);

	public Announcment getAnnouncment(long id);

	public Collection<Announcment> getAllAnnouncment();

	public void deleteAnnouncment(long id);

	public Announcment updateAnnouncment(String title, String discription,String image ,Date date);

}
