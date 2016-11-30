package ie.turfclub.dao;

import java.util.List;

import ie.turfclub.model.OwnerHandler;
import ie.turfclub.model.User;
 
public interface UserDAO {
 
    public void addUser(User user);
 
    public User getUser(int userId) throws UserNotFoundException;
 
    public OwnerHandler getHandler(String username) throws UserNotFoundException;
 
    public User getUser(String username) throws UserNotFoundException;
    
    public void updateUser(User user) throws UserNotFoundException;
 
    public void deleteUser(int userId) throws UserNotFoundException;
 
    public List<User> getUsers();
}