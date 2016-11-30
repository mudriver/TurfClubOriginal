package ie.turfclub.reporting.dao;



import ie.turfclub.reporting.model.pointToPoint.HunterCert;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface HunterCertDAO {
 

    public List<HunterCert> getUnprocessedHunterCerts();
    public HunterCert getHunterCert(String horseName);
    public void updateHunterCertWinsRunsAndValidate(String horseName, Date lastWin, Date lastRun, boolean autumnRejected, boolean rejected);

  
}
