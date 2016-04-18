package mum.ea.group6.webblog.controllers;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.ea.group6.webblog.domain.Post;
import mum.ea.group6.webblog.service.AnnouncmentService;
import mum.ea.group6.webblog.service.CommentService;
import mum.ea.group6.webblog.service.PostService;
import mum.ea.group6.webblog.service.UserAccountService;

@Controller
public class PostController {
	
	private long userId;
	
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Resource
	private PostService postService;
	
	@Resource
	private CommentService commentService;
	
	@Resource
	private UserAccountService userAccountService;
	
	@Resource
	private AnnouncmentService announcmentService;

	
	public UserAccountService getUserAccountService() {
		return userAccountService;
	}

	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public PostService getService() {
		return postService;
	}

	public void setService(PostService service) {
		this.postService = service;
	}
	
	@RequestMapping(value="/")
	public String redirect(){
		return "index";
		//return "LidyaHome";
	}
	
	
	@RequestMapping(value="/index" ,method = RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String login(long userId, String password){
		this.userId=userId;
		if(userAccountService.checkUser(userId, password))
		    return "redirect:/post";
		
		return "index";
	}
	
	/*@RequestMapping(value="/post", method=RequestMethod.GET)
	public String hommer(){
		return "redirect:/post";
	}
	*/
	
	@RequestMapping(value="/signup")
	public String signup(){
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(long id,String firstName, String lastName,String email,String password, String image ){
		
		userAccountService.createUserAccount(id, firstName, lastName, email, password, image);
		userId=id;
		return "redirect:/post";
	}
	
	
	
	
	
	@RequestMapping(value="/addpost")
	public String addPost(){
		return "addpost";
	}
	
	@RequestMapping(value="/addanouncment")
	public String addAnnoucment(){
		return "addannouncment";
	}
	@RequestMapping(value="/contact")
	public String contact(){
		return "contact";
	}
	@RequestMapping(value="/about")
	public String about(){
		return "about";
	}
	
	@RequestMapping(value="/addAnouncment",method = RequestMethod.POST)
	public String addAnnoucment(String title,String discription,String image, String date){
		
		announcmentService.createAnnouncment(title, discription, image, new Date());
		return "redirect:/announcment";
	}
	
	@RequestMapping(value="/announcment",method = RequestMethod.GET)
	public String getAnnouncments(Model model){
		
		model.addAttribute("announcments", announcmentService.getAllAnnouncment());
		return "announcment";
	}
	 
	
	@RequestMapping(value="/post" , method= RequestMethod.POST)
	public String addPost(String title,String description, String image, String type,
			String place,String date){
		
		postService.createPost(title, description, image, 0, place, type, new Date());
		
		/*postService.createPost(post.getTitle(), post.getTitle(), post.getPicture(),
				0,post.getPostType().getPlace(),"Trip",new Date());*/
		return "redirect:/post";
	}
	
	
	@RequestMapping(value="/post", method=RequestMethod.GET)
	public String posts(Model model){
		
		
		List<Post> posts=(List<Post>) postService.getAllPost();
		
		//model.addAttribute("posts", postService.getAllPost());
		model.addAttribute("posts", posts);
		System.out.println("returned ");
		return "post";
	}
	
	@RequestMapping(value="/like",method=RequestMethod.POST)
	public String likePost(int postId,int like){
		
		postService.likePost(postId,like+1);
		return "redirect:/post";
	}
	
		
	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public String profile(Model model){
		
		model.addAttribute("profile" , userAccountService.getUserAccount(userId));
		
		return "profile";		
	}
	
	@RequestMapping(value="/editprofile",method=RequestMethod.GET)
	public String editprofile(Model model){
		
		model.addAttribute("profile" , userAccountService.getUserAccount(userId));
		
		return "editprofile";		
	}
	
	@RequestMapping(value="/editprofile",method=RequestMethod.POST)
	public String profile(String firstName, String lastName,String email,String password, String image ){
		
		
		userAccountService.updateUserAccount(userId, firstName, lastName, email, password,image);
		return "redirect:/profile";		
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(){
		userId=0;
		return "redirect:/index";
	}
	@RequestMapping(value="/comment", method=RequestMethod.POST)
	public String comment(int postId,String comment){
		
		commentService.createComment(comment, postId, userId);
		System.out.println("with post id "+postId+comment);
		return "redirect:/post";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deletePost(int postId){
		System.out.println("---------------------------"+postId);
		postService.deletePost(postId);
		return "redirect:/post";
	}
	
	
	
	
	
	
	
}
