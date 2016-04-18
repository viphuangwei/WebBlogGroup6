package mum.ea.group6.webblog.service;

import java.util.Collection;

import mum.ea.group6.webblog.domain.Comment;

public interface CommentService {

	public Comment createComment(String comment, long eventId, long userId);

	public Comment getComment(long commentId);

	public Collection<Comment> getAllComment(long eventId);

	public void deleteComment(long id);

	public Comment updateComment(String comment, long eventId, long userId);

}
