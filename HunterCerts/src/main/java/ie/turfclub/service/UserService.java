package ie.turfclub.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import ie.turfclub.dao.UserNotFoundException;
import ie.turfclub.model.User;
 
public interface UserService extends UserDetailsService {
 
    public void addUser(User user);
 
    public User getUser(int userId) throws UserNotFoundException;
 
    public User getUser(String username) throws UserNotFoundException;
 
    public void updateUser(User user) throws UserNotFoundException;
 
    public void deleteUser(int userId) throws UserNotFoundException;
 
    public List<User> getUsers();
}
