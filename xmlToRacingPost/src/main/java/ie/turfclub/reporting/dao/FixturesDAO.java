package ie.turfclub.reporting.dao;

import ie.turfclub.reporting.model.pointToPoint.P2pFixtures;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public interface FixturesDAO {

	public List<P2pFixtures> getAllFixtures();
	public String getLastAutumnFixtureStringDate(int year);
	public String getLastSpringFixtureStringDate();
	public String getAutumnSeasonStartStringDate();
	public String getSpringSeasonEndStringDate();
	
}
