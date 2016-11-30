package ie.turfclub.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ie.turfclub.dao.UserDAO;
import ie.turfclub.dao.UserNotFoundException;
import ie.turfclub.model.OwnerHandler;
import ie.turfclub.model.User;
 
@Service
@Transactional
@ComponentScan("ie.turfclub.dao")
public class UserServiceImpl implements UserService {
    static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
     
    @Autowired
    private UserDAO userDAO;
 
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }
 
    @Override
    public User getUser(int userId) throws UserNotFoundException {
        return userDAO.getUser(userId);
    }
 
    @Override
    public User getUser(String username) throws UserNotFoundException {
    	
    	OwnerHandler owner = userDAO.getHandler(username);
    	//check if the login is an ownerhandler
    	System.out.println("Getting user");
    	if(owner != null){
    		System.out.println("Handler");
    		return convertHandlerToUser(owner);
    	}
    	//if the user is not an ownerhandler check the users table
    	else{
    		System.out.println("Hunt");
    		User user = userDAO.getUser(username);
    		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        	String pass = encoder.encodePassword("","123456");
    		System.out.println(pass);
    		user.setAuthorities();
    		return user;
    	}
    	
    }
 
    @Override
    public void updateUser(User user) throws UserNotFoundException {
        userDAO.updateUser(user);
    }
 
    @Override
    public void deleteUser(int userId) throws UserNotFoundException {
        userDAO.deleteUser(userId);
    }
 
    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }
    
    
    
    public User convertHandlerToUser(OwnerHandler handler){
    	User user = new User();
    	user.setUsername(handler.getOwner_handler_account_no());
    	user.setPassword(handler.getOwner_handler_password());
    	Md5PasswordEncoder encoder = new Md5PasswordEncoder();
    	String pass = encoder.encodePassword("",handler.getOwner_handler_password());
    	System.out.println(pass);
    	user.setEnabled(true);
    	Collection<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_HCERT_USER");
        authorities.add(authority);
        user.setAuthorities(authorities);
    	return user;
    }
    
    //TODO Dummy role added temporarily 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            
 
            
            System.out.println(username.toUpperCase());
            User userObject = getUser(username.toUpperCase());
            
            return userObject;
        } catch (UserNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}