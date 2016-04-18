package mum.ea.group6.webblog.dao;

import java.util.Collection;

import mum.ea.group6.webblog.domain.Admin;

public interface AdminDAO {
	public void saveAdmin(Admin admin);
	public void updateAdmin(Admin admin);
	public Admin loadAdmin(long id);
	public void delete(Admin admin);
	public Collection<Admin> getAdmin();
}
