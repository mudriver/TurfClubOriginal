package ie.turfclub.reporting.service;

import ie.turfclub.reporting.model.pointToPoint.P2pFixtures;

import java.util.Date;
import java.util.List;

public interface FixturesService {

	public List<P2pFixtures> getAllFixtures();
	public Date getLastAutumnFixture(int year);
	public Date getLastSpringFixture();
	public int getAutumnSeasonStartYear();
	public int getSpringSeasionEndYear();
}
