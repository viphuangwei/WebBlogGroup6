package mum.ea.group6.webblog.daoimpl;

import java.util.Collection;

import org.hibernate.SessionFactory;

import mum.ea.group6.webblog.dao.PostUserDAO;
import mum.ea.group6.webblog.domain.Comment;

public class PostUserDAOImpl implements PostUserDAO {

	private SessionFactory sf;
	
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public void saveComment(Comment comment) {
		sf.getCurrentSession().persist(comment);
		
	}

	public void updateComment(Comment comment) {
     sf.getCurrentSession().saveOrUpdate(comment);		
	}

	public Comment loadComment(long id) {
		return (Comment)sf.getCurrentSession().get(Comment.class, id);
	}

	public void delete(Comment comment) {
		sf.getCurrentSession().delete(comment);
		
	}
    
	@SuppressWarnings("uncheaking")
	public Collection<Comment> getComment(long eventId) {
		 return sf.getCurrentSession().createQuery("select distinct c from Comment c "
		 		+ "join c.event e "
		 		+ "where e.id = 'eventId' ").list();
	}
   

}
