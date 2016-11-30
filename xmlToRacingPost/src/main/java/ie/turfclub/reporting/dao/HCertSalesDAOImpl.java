package ie.turfclub.reporting.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ie.turfclub.reporting.model.pointToPoint.HuntercertsSales;

@Repository
@Transactional
public class HCertSalesDAOImpl implements HCertSalesDAO {

	@Autowired
	@Qualifier("p2psessionFactory")
	 private LocalSessionFactoryBean sessionFactory;
	
	private Session getCurrentSession() {
		  return sessionFactory.getObject().openSession();
		 }
	
	@Override
	public void addHunterCertSales(HuntercertsSales sale) {
		
		getCurrentSession().save(sale);

	}

	
}
