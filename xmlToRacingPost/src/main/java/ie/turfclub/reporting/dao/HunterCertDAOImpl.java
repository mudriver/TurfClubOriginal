package ie.turfclub.reporting.dao;


import ie.turfclub.reporting.model.pointToPoint.HunterCert;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;





@Repository
@Transactional
public class HunterCertDAOImpl implements HunterCertDAO {
 
 @Autowired
 @Qualifier("p2psessionFactory")
 private LocalSessionFactoryBean sessionFactory;
 
 
 
 
 
private Session getCurrentSession() {
  return sessionFactory.getObject().openSession();
 }
 
 public void addHunterCert(HunterCert HunterCert) {
  getCurrentSession().save(HunterCert);
 }
 
 
 @Override
 public List<HunterCert> getUnprocessedHunterCerts() {
	 List<HunterCert> list = getCurrentSession().createQuery("from HunterCert h where h.hcertCertStatus='PAID' AND h.hcertDailyRountineCompleted = 0").list();
	 return list;
 }

 
	@Override
	public HunterCert getHunterCert(String horseName) {
		@SuppressWarnings("unchecked")
		List<HunterCert> list = getCurrentSession().createQuery("from HunterCert h where h.hcertHorseName like '%" + horseName + "%'").list();
		if(list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

 
	public void updateHunterCertWinsRunsAndValidate(String horseName, Date lastWin, Date lastRun,boolean autumnRejected, boolean rejected){
	 
		
		HunterCert hunterCert = getHunterCert(horseName);
		hunterCert.setHcertLastRunDate(lastRun);
		hunterCert.setHcertLastWinDate(lastWin);
		hunterCert.setHcertRejected(rejected);
		getCurrentSession().saveOrUpdate(hunterCert);
		
		
 }


 
 


 
 
 
}