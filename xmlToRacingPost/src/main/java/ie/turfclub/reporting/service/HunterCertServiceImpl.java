package ie.turfclub.reporting.service;


import ie.turfclub.reporting.dao.HunterCertDAO;
import ie.turfclub.reporting.model.pointToPoint.HunterCert;

import java.util.Date;
import java.util.List;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class HunterCertServiceImpl implements HunterCertService {
 
 @Autowired
 private HunterCertDAO hunterCertDAO;

@Override
public List<HunterCert> getUnprocessedHunterCerts() {
	return hunterCertDAO.getUnprocessedHunterCerts();
}

@Override
public void updateHunterCertWinsRunsAndValidate(String horseName, Date lastWin,
		Date lastRun,boolean autumnRejected, boolean rejected) {
	hunterCertDAO.updateHunterCertWinsRunsAndValidate(horseName, lastWin, lastRun, autumnRejected, rejected);
	
}




}