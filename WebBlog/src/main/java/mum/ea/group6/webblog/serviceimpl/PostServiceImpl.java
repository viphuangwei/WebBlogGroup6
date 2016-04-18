package mum.ea.group6.webblog.serviceimpl;

import java.util.Collection;
import java.util.Date;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.group6.webblog.dao.PostAdminDAO;
import mum.ea.group6.webblog.dao.PostUserDAO;
import mum.ea.group6.webblog.domain.Category;
import mum.ea.group6.webblog.domain.Comment;
import mum.ea.group6.webblog.domain.Post;
import mum.ea.group6.webblog.service.PostService;

public class PostServiceImpl implements PostService {
	private PostAdminDAO postDao;

	public PostServiceImpl(PostAdminDAO postDao) {
		super();
		this.postDao = postDao;

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Post createPost(String title, String description, String picture, int likes, String place, String type,
			Date date) {
		Category postType = new Category(place, type, date);

		Post post = new Post(title, description, picture, likes, postType);
		post.setPostType(postType);
		postDao.savePost(post);
		return post;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Post getPost(long id) {
		return postDao.loadPost(id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Collection<Post> getAllPost() {
		Collection<Post> posts =  postDao.getPost();
		return posts;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deletePost(long id) {
		Post post = postDao.loadPost(id);
		postDao.delete(post);

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Post updatePost(String title, String description, String picture, int likes, String place, String type,
			Date date) {
		Category postType = new Category(place, type, date);
		Post post = new Post(title, description, picture, likes, postType);
		post.setPostType(postType);
		postDao.updatePost(post);
		return post;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void likePost(long postId,int like) {
		
		postDao.likePost(postId,like);
		
	}

	

}
