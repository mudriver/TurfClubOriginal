package ie.turfclub.dao;


import ie.turfclub.model.Hunt;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class HuntDAOImpl implements HuntDAO {


	 @Autowired
	 private LocalSessionFactoryBean sessionFactory;
	
		private Session getCurrentSession() {
			  return sessionFactory.getObject().getCurrentSession();
			 }
	 
	@Override
	public Hunt getHunt(String id) {
		Hunt hunt = (Hunt) getCurrentSession().get(Hunt.class, id);
		return hunt;
	}

	@Override
	public List<Hunt> getHunts(String containsChars) {
		@SuppressWarnings("unchecked")
		List<Hunt> list = getCurrentSession().createQuery("from Hunt h where h.hunt_name like '%" + containsChars + "%' AND h.hunt_live=1").list();
		return list;
	}

	@Override
	public Hunt getHuntByUser(String user) {
		@SuppressWarnings("unchecked")
		List<Hunt> list = getCurrentSession().createQuery("from Hunt h where h.hunt_userid like '%" + user + "%'").list();
		return list.get(0);
	}

}
