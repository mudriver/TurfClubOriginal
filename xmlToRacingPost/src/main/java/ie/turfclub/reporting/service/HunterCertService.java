package ie.turfclub.reporting.service;


import ie.turfclub.reporting.model.pointToPoint.HunterCert;
import java.util.Date;
import java.util.List;


 
public interface HunterCertService  {
 
    public List<HunterCert> getUnprocessedHunterCerts();
    public void updateHunterCertWinsRunsAndValidate(String horseName, Date lastWin, Date lastRun,boolean autumnRejected, boolean rejected);

    
}