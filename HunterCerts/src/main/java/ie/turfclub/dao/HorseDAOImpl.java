package ie.turfclub.dao;

import ie.turfclub.model.HorseWithID;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class HorseDAOImpl implements HorseDAO {

	
	 @Autowired
	 private LocalSessionFactoryBean sessionFactory;
	 
	 
	 
	 
	private Session getCurrentSession() {
	  return sessionFactory.getObject().getCurrentSession();
	 }
	
	@Override
	public List<HorseWithID> getHorses(String containsChars) {
		@SuppressWarnings("unchecked")
		List<HorseWithID> list = getCurrentSession().createQuery("from HorseWithID h where h.horse_name like '%" + containsChars + "%'").list();
		return list;
	}

}
