package ie.turfclub.dao;


import ie.turfclub.model.Vaccination;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class VaccinationDAOImpl implements VaccinationsDAO {

	@Autowired
	 private LocalSessionFactoryBean sessionFactory;
	
	private Session getCurrentSession() {
		  return sessionFactory.getObject().getCurrentSession();
		 }

	
	@Override
	public void addVaccination(Vaccination vac) {
		getCurrentSession().save(vac);

	}

	@Override
	public Vaccination getVaccination(int id) {
		Vaccination vac = (Vaccination) getCurrentSession().get(Vaccination.class, id);
		  return vac;
	}

	@Override
	public List<Vaccination> getVaccinations(int id) {
		@SuppressWarnings("unchecked")
		List<Vaccination> list = getCurrentSession().createQuery("from Vaccination v where v.vac_hcert_id =" + id).list();
System.out.println(list.size());
return list;
	}

}
