package com;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 

import com.model.User1;
import com.service.RegistrationService;

 

@RestController
@RequestMapping(path="/api")
@Validated
public class RegistrationController {
	@Autowired
    private RegistrationService rservice;

 

    @PostMapping("/registeruser")
    public User1  registerUser(@Valid @RequestBody User1 user1) throws Exception
    {
        String tempEmailId=user1.getEmailId();
        if(tempEmailId!= null && !"".equals(tempEmailId)) 
        {
            User1 userObj = rservice.fetchUserByEmailId(tempEmailId);
            if(userObj != null) 
            {
                throw new Exception("userName with "+tempEmailId+" is already exist");
            }
        }
        User1 userObj=null;
        userObj=rservice.saveUser(user1);
        return userObj;
    }
    
    @PostMapping("/login")
    public User1 loginUser( @RequestBody User1 user1) throws Exception
    {
    	String tempEmailId=user1.getEmailId();
    	String tempPass=user1.getPassword();
    	User1 userObj=null;
    	if(tempEmailId!=null && tempPass !=null)
    	{
    		userObj= rservice.fetchUserByEmailId(tempEmailId);
    		//userObj=rservice.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
    	}
    	if(userObj == null) 
        {
            throw new Exception("Bad Credentials");
        }
    	return userObj;
    	
    }
}


