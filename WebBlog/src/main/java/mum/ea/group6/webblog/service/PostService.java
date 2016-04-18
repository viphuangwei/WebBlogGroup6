package mum.ea.group6.webblog.service;

import java.util.Collection;
import java.util.Date;

import mum.ea.group6.webblog.domain.Category;
import mum.ea.group6.webblog.domain.Comment;
import mum.ea.group6.webblog.domain.Post;
import mum.ea.group6.webblog.domain.UserAccount;

public interface PostService {
	public Post createPost(String title, String description, String picture, int likes, String place, String type,
			Date date);

	public Post getPost(long id);

	public Collection<Post> getAllPost();

	public void deletePost(long id);

	public Post updatePost(String title, String description, String picture, int likes, String place, String type,
			Date date);

	public void likePost(long eventId,int like);

}
