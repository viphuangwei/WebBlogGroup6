package mum.ea.group6.webblog.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import mum.ea.group6.webblog.dao.PostAdminDAO;
import mum.ea.group6.webblog.domain.Post;

public class PostAdminDAOImpl implements PostAdminDAO{

	private SessionFactory sf;
	
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public void savePost(Post post) {
		sf.getCurrentSession().persist(post);
		
	}

	public void updatePost(Post post) {
		sf.getCurrentSession().saveOrUpdate(post);
		
	}

	public void delete(Post post) {
		sf.getCurrentSession().delete(post);
		
	}
	
    @SuppressWarnings("uncheaked")
	public List<Post> getPost() {
		
    	List<Post> posts = sf.getCurrentSession().createQuery("select distinct e from Post e join fetch e.postType t "
    			+ "left join fetch e.comments c").list();
		for(Post e:posts){
			System.out.println(e.getId() + " " + e.getComments().size());//.add(commentService.getComment(e.getId()));
		}
		return posts;
    }

	public Post loadPost(long id) {
		return (Post)sf.getCurrentSession().get(Post.class, id);
	}

	
	public void likePost(long postId,int like) {
		
		Query query = sf.getCurrentSession().createQuery("update Post set likes = :like" +
				" where id = :postId");
		query.setParameter("like", like);
		query.setParameter("postId", postId);
		query.executeUpdate();
	
	}

}