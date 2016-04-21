package mum.ea.group6.webblog.serviceimpl;

import java.util.Collection;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.group6.webblog.dao.AdminDAO;
import mum.ea.group6.webblog.domain.Admin;
import mum.ea.group6.webblog.service.AdminAccountService;

public class AdminAccountServiceImpl implements AdminAccountService {
	private AdminDAO adminDao;

	public AdminAccountServiceImpl(AdminDAO adminDao) {
		super();
		this.adminDao = adminDao;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void createAdmin() {
		Admin admin1 = new Admin("Lidya", "Kidane");
		Admin admin2 = new Admin("Matias", "Cherenet");
		Admin admin3 = new Admin("Wei", "viphuang");
		adminDao.saveAdmin(admin1);
		adminDao.saveAdmin(admin2);
		adminDao.saveAdmin(admin3);

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Admin getAdmin(long id) {
		return adminDao.loadAdmin(id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Collection<Admin> getAllAdmin() {
		return adminDao.getAdmin();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deleteAdmin(long Id) {
		Admin admin = adminDao.loadAdmin(Id);
		adminDao.delete(admin);

	}

}
