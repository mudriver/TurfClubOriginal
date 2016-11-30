package ie.turfclub.service;

import ie.turfclub.dao.OwnerHandlerDAO;
import ie.turfclub.model.OwnerHandler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OwnerHandlerServiceImpl  implements OwnerHandlerService{

	@Autowired
	private OwnerHandlerDAO ownerHandlerDAO;
	
	@Override
	public void addOwnerHandler(OwnerHandler ownerHandler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OwnerHandler getOwnerHandler(String accountNo) {
		
		return ownerHandlerDAO.findByAccountNo(accountNo);
	}

	
	
	@Override
	public void updateOwnerHandler(OwnerHandler hunterCert) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOwnerHandler(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OwnerHandler> getOwnerHandlers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OwnerHandler getOwner(String accountNo) {
		return   ownerHandlerDAO.findOwnerOnlyByAccountNo(accountNo);
		
	}

	
	
}
