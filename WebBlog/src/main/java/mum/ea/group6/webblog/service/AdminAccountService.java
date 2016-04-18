package mum.ea.group6.webblog.service;

import java.util.Collection;

import mum.ea.group6.webblog.domain.Admin;

public interface AdminAccountService {
	public void createAdmin();

	public Admin getAdmin(long id);

	public Collection<Admin> getAllAdmin();

	public void deleteAdmin(long Id);

}
