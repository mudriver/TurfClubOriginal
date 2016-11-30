package ie.turfclub.xmlToRacingPost.dao;


import ie.turfclub.xmlToRacingPost.model.HunterCert;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;





@Repository
public class HunterCertDAOImpl implements HunterCertDAO {
 
 @Autowired
 private LocalSessionFactoryBean sessionFactory;
 
 
 
 
 
private Session getCurrentSession() {
  return sessionFactory.getObject().getCurrentSession();
 }
 
 public void addHunterCert(HunterCert HunterCert) {
  getCurrentSession().save(HunterCert);
 }
 
 public void updateHunterCert(HunterCert hunterCert) {
 // HunterCert hunterCertToUpdate = getHunterCert(hunterCert.getId());
 
  
  

  getCurrentSession().saveOrUpdate(hunterCert);
 }
 
 public HunterCert getHunterCert(int id) {
  HunterCert hunterCert = (HunterCert) getCurrentSession().get(HunterCert.class, id);
  //HunterCert hunterCert = (HunterCert) getCurrentSession().get(HunterCert.class, id);System.out.println(hunterCert.getHorse_name());
  return hunterCert;
 }
 
 public void deleteHunterCert(int id) {
  HunterCert HunterCert = getHunterCert(id);
  if (HunterCert != null)
   getCurrentSession().delete(HunterCert);
 }
 


@Override
public List<HunterCert> getHunterCertsByHuntId(int huntid) {
	@SuppressWarnings("unchecked")
	List<HunterCert> list = getCurrentSession().createQuery("from HunterCert h where hcert_hunt_id=" +  huntid  + " AND h.status='PAYED'").list();
	 return list;
}

@Override
public void approveHunterCertByHunt(int hunterCertId) {
	HunterCert hunterCert = (HunterCert) getCurrentSession().get(HunterCert.class, hunterCertId);
	hunterCert.setStatus("HUNTAPPROVED");
	getCurrentSession().saveOrUpdate(hunterCert);
	
}
 
@Override
public void rejectHunterCertByHunt(int hunterCertId) {
	HunterCert hunterCert = (HunterCert) getCurrentSession().get(HunterCert.class, hunterCertId);
	hunterCert.setStatus("HUNTREJECTED");
	getCurrentSession().saveOrUpdate(hunterCert);
	
}
	
	
 
 
}