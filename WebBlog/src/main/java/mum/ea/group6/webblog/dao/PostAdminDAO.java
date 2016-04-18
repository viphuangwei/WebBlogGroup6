package mum.ea.group6.webblog.dao;

import java.util.Collection;

import mum.ea.group6.webblog.domain.Announcment;
import mum.ea.group6.webblog.domain.Post;


public interface PostAdminDAO {
    
	public void savePost(Post post);
	public void updatePost(Post post);
	public Post loadPost(long id);
	public void delete(Post post);
	public Collection<Post> getPost();
	public void likePost(long postId,int like);
}
