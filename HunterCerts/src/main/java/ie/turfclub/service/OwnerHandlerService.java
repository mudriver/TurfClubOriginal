package ie.turfclub.service;

import ie.turfclub.model.OwnerHandler;

import java.util.List;

public interface OwnerHandlerService {

    public void addOwnerHandler(OwnerHandler ownerHandler);
    public OwnerHandler getOwner(String accountNo);
    public OwnerHandler getOwnerHandler(String accountNo);
    public void updateOwnerHandler(OwnerHandler hunterCert);
    public void deleteOwnerHandler(int id);
    public List<OwnerHandler> getOwnerHandlers();
	
}
