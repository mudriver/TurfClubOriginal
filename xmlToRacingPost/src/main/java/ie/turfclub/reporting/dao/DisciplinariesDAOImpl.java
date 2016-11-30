package ie.turfclub.reporting.dao;

import java.util.List;

import ie.turfclub.reporting.model.discips.DisEnquiriesTable;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class DisciplinariesDAOImpl implements DisciplinariesDAO {

	@Autowired
	@Qualifier("discipsessionFactory")
	 private LocalSessionFactoryBean sessionFactory;
	
	private Session getCurrentSession() {
		  return sessionFactory.getObject().openSession();
		 }
	
	@Override
	public void update(DisEnquiriesTable disciplinary) {
		getCurrentSession().save(disciplinary);

	}

	@Override
	public List<DisEnquiriesTable> getUnProcessedAccounts(String maxDate) {
		 List<DisEnquiriesTable> list = getCurrentSession().createQuery("from DisEnquiriesTable d where d.recDate<='"  + maxDate + "' AND d.recAccountsProcessed=0").list();
		 return list;
	}



	
	
}
