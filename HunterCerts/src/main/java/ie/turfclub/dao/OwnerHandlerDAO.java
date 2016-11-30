package ie.turfclub.dao;

import ie.turfclub.model.OwnerHandler;
 
public interface OwnerHandlerDAO {
 
    public OwnerHandler findByAccountNo(String accountNo);
    public OwnerHandler findOwnerOnlyByAccountNo(String accountNo);
     
}
