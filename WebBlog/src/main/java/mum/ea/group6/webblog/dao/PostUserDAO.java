package mum.ea.group6.webblog.dao;

import java.util.Collection;

import mum.ea.group6.webblog.domain.Comment;

public interface PostUserDAO {
	public void saveComment(Comment comment);
	public void updateComment(Comment comment);
	public Comment loadComment(long id);
	public void delete(Comment comment);
	public Collection<Comment> getComment(long eventId);
	
	
}
