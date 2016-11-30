package ie.turfclub.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import ie.turfclub.model.OwnerHandler;

@Repository
public class OwnerHandlerDAOImpl implements OwnerHandlerDAO{

	@Autowired
	 private LocalSessionFactoryBean sessionFactory;
	 
	 
	 
	private Session getCurrentSession() {
	  return sessionFactory.getObject().getCurrentSession();
	 }
	 
		 
	
	@SuppressWarnings("unchecked")
	@Override
	public OwnerHandler findByAccountNo(String accountNo) {
		
		
		System.out.println(accountNo);
		   Query query = getCurrentSession().createQuery("from OwnerHandler where owner_handler_account_no = :accountNo ");
	        query.setString("accountNo", accountNo);
	        if (query.list().size() == 0 ) {
	           return null;
	        } else {
	            
	            List<OwnerHandler> list = (List<OwnerHandler>)query.list();
	            
	            OwnerHandler handler = (OwnerHandler) list.get(0);
	        
	            System.out.println(handler.getOwner_handler_account_no());
	            return handler;
	        }
	
		
	}



	@Override
	public OwnerHandler findOwnerOnlyByAccountNo(String accountNo) {
		 Query query = getCurrentSession().createQuery("from OwnerHandler where owner_handler_account_no = :accountNo and owner_handler_owner=true");
	        query.setString("accountNo", accountNo);
	        if (query.list().size() == 0 ) {
	           return null;
	        } else {
	            
	            @SuppressWarnings("unchecked")
				List<OwnerHandler> list = (List<OwnerHandler>)query.list();
	            
	            OwnerHandler handler = (OwnerHandler) list.get(0);
	        
	            System.out.println(handler.getOwner_handler_account_no());
	            return handler;
	        }
	}
	 
	
	

}
