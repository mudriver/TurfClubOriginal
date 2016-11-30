package ie.turfclub.reporting.dao;

import ie.turfclub.reporting.model.pointToPoint.P2pFixtures;

import java.util.List;






import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class FixturesDAOImpl implements FixturesDAO {

	
	@Autowired
	@Qualifier("p2psessionFactory")
	 private LocalSessionFactoryBean sessionFactory;
	
	private Session getCurrentSession() {
		  return sessionFactory.getObject().openSession();
		 }
	
	@Override
	public List<P2pFixtures> getAllFixtures() {
		 List<P2pFixtures> list = getCurrentSession().createQuery("from P2pFixtures").list();
		 return list;
	}

	@Override
	public String getLastAutumnFixtureStringDate(int year) {
		System.out.println(year);
		//List<P2pFixtures> list = getCurrentSession().createQuery("from P2pFixtures f where (f.fixtureId, f.fixtureDate)  in (select ff.fixtureId, max(ff.fixtureDate) from P2pFixtures ff where ff.fixtureDate <= '" + year +  "-12-25')").list();
		List list = getCurrentSession().createQuery("select max(ff.fixtureDate) from P2pFixtures ff where ff.fixtureDate <= '" + year +  "-12-25'").list();
		
		return (String) list.get(0).toString();
	}

	@Override
	public String getLastSpringFixtureStringDate() {
List list = getCurrentSession().createQuery("select max(ff.fixtureDate) from P2pFixtures ff").list();
		
		return (String) list.get(0).toString();
	}

	@Override
	public String getAutumnSeasonStartStringDate() {
List list = getCurrentSession().createQuery("select min(ff.fixtureDate) from P2pFixtures ff").list();
		
		return (String) list.get(0).toString();
	}

	@Override
	public String getSpringSeasonEndStringDate() {
List list = getCurrentSession().createQuery("select max(ff.fixtureDate) from P2pFixtures ff").list();
		
		return (String) list.get(0).toString();
	}





}
