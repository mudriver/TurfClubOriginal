package ie.turfclub.reporting.service;

import ie.turfclub.reporting.dao.FixturesDAO;
import ie.turfclub.reporting.model.pointToPoint.P2pFixtures;
import ie.turfclub.reporting.utilities.MailUtility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class FixturesServiceImpl implements FixturesService {

	@Autowired
	private FixturesDAO fixturesDAO;
	@Autowired
	private MailUtility mailUtil;
	private SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public List<P2pFixtures> getAllFixtures() {
		return fixturesDAO.getAllFixtures();
		
	}

	@Override
	public Date getLastAutumnFixture(int year) {
		try {
			return sqlFormat.parse(fixturesDAO.getLastAutumnFixtureStringDate(year));
		} catch (ParseException e) {
			mailUtil.sendITError("Auto Reports - XMLImport - Date Error", e.toString());
		}
		return null;
	}

	@Override
	public Date getLastSpringFixture() {
		try {
			return sqlFormat.parse(fixturesDAO.getLastSpringFixtureStringDate());
		} catch (ParseException e) {
			mailUtil.sendITError("Auto Reports - XMLImport - Date Error", e.toString());
		}
		return null;
	}

	@Override
	public int getAutumnSeasonStartYear() {
		String lastAutumn = fixturesDAO.getAutumnSeasonStartStringDate();
		System.out.println("Au Year" + lastAutumn);
		int year = Integer.parseInt(lastAutumn.substring(0, lastAutumn.indexOf("-")));
		System.out.println(year);
		return year;
	}

	@Override
	public int getSpringSeasionEndYear() {
		
		String lastSpring = fixturesDAO.getSpringSeasonEndStringDate();
		System.out.println("Au Year");
		int year = Integer.parseInt(lastSpring.substring(lastSpring.lastIndexOf("-")));
		return year;
	}

}
