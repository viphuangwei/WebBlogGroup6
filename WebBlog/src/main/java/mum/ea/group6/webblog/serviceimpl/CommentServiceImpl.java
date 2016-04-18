package mum.ea.group6.webblog.serviceimpl;

import java.util.Collection;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.group6.webblog.dao.PostAdminDAO;
import mum.ea.group6.webblog.dao.PostUserDAO;
import mum.ea.group6.webblog.dao.UserDAO;
import mum.ea.group6.webblog.domain.Comment;
import mum.ea.group6.webblog.domain.Post;
import mum.ea.group6.webblog.domain.UserAccount;
import mum.ea.group6.webblog.service.CommentService;

public class CommentServiceImpl implements CommentService {
	private PostUserDAO commentDao;
	private PostAdminDAO eventDao;
	private UserDAO userDao;

	public CommentServiceImpl(PostUserDAO commentDao, PostAdminDAO eventDao, UserDAO userDao) {
		super();
		this.commentDao = commentDao;
		this.eventDao = eventDao;
		this.userDao = userDao;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Comment createComment(String comment, long eventId, long userId) {
		Post event = eventDao.loadPost(eventId);
		UserAccount user = userDao.loadUser(userId);
		Comment comments = new Comment(comment, event, user);
		commentDao.saveComment(comments);
		return comments;

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Comment getComment(long commentId) {
		return commentDao.loadComment(commentId);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Collection<Comment> getAllComment(long commentId) {
		return commentDao.getComment(commentId);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deleteComment(long id) {
		Comment comment = commentDao.loadComment(id);
		commentDao.delete(comment);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Comment updateComment(String comment, long eventId, long userId) {
		Post event = eventDao.loadPost(eventId);
		UserAccount user = userDao.loadUser(userId);
		Comment comments = new Comment(comment, event, user);
		commentDao.updateComment(comments);
		return comments;
	}

}
