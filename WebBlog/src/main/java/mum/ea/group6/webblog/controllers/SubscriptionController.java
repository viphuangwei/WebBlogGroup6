package mum.ea.group6.webblog.controllers;
import java.util.ArrayList;  
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;  

@RestController
public class SubscriptionController {
	List<SubscriptionUser> subscribList;
	public SubscriptionController()
	{
		subscribList = createSubscriptionUserList();
	}
	public class SubscriptionUser{  		   
		int id;  
		String name;
		String email;
		
		public SubscriptionUser(int i, String name, String email) {  
			  super();  
			  this.id = i;  
			  this.name = name;
			  this.email = email;
		}  
		 public int getId() {  
			 return id;  
		 }  
		 public void setId(int id) {  
			 this.id = id;  
		 }  
		 public String getName() {  
			 return name;  
		 }  
		 public void setName(String name) {  
			 this.name = name;  
		 }
		 public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	}
	   
	 @RequestMapping(value = "/rest/getAllSubscribers", method = RequestMethod.GET, headers="Accept=application/json")  
	 public List<SubscriptionUser> getAllSubscribers()  
	 {  
		  return subscribList;  
	 }  
	  
	 @RequestMapping(value = "/rest/subscriber/{id}", method = RequestMethod.GET, headers="Accept=application/json")  
	 public SubscriptionUser getSubscriptionUserById(@PathVariable int id)  
	 {   		  
		  for (SubscriptionUser user: subscribList) {  
			   if(user.getId()==id)  
			      return user;  
		  }  
		  return null;  
	 }  
	  
	@RequestMapping(value="/rest/unsubscribe/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void unsubscribe(@PathVariable("id")  int id){
		  String result ="";
		  for (SubscriptionUser user: subscribList) {  
			   if(user.getId()==id){ 
				   subscribList.remove(user); 
				   result = ("User "+ user.getName()+ "unsubscribe!" + "ID is " + id);
			   } 
		  }
		  //return result;
	}
	
	@RequestMapping(value="/rest/subscribe", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody SubscriptionUser subscribe(@RequestBody SubscriptionUser user){
		String result ="";
		subscribList.add(user);
		result = ("User "+ user.getName()+ "is subscribing!" + "ID is " + user.getId());
		//return result;
		return user;
	}
	
	// Utiliy method to create subscribers list.  
	 public List<SubscriptionUser> createSubscriptionUserList()  
	 {  
		  SubscriptionUser u1 = new SubscriptionUser(1, "Jerry", "Jerry@gmail.com");  
		  SubscriptionUser u2 = new SubscriptionUser(2, "Andy", "Andy@gmail.com");  
		  SubscriptionUser u3 = new SubscriptionUser(3, "Mandy","Mandy@gmail.com");  
		  SubscriptionUser u4 = new SubscriptionUser(4, "David","David@gmail.com");  
		  
		  List<SubscriptionUser> listOfCountries = new ArrayList<SubscriptionUser>();  
		  listOfCountries.add(u1);  
		  listOfCountries.add(u2);  
		  listOfCountries.add(u3);  
		  listOfCountries.add(u4);  
		  return listOfCountries;  
	 }  
	
}
