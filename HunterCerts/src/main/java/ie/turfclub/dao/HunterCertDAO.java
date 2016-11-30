package ie.turfclub.dao;



import java.util.List;

import ie.turfclub.model.HunterCert;
 
public interface HunterCertDAO {
 
    public void addHunterCert(HunterCert HunterCert);
    public HunterCert getHunterCert(int id);
    public void updateHunterCert(HunterCert HunterCert);
    public void deleteHunterCert(int id);
    public List<HunterCert> getHunterCertsByHuntId(int huntid);
    public void approveHunterCertByHunt(int hunterCertId);
    public void rejectHunterCertByHunt(int hunterCertId);
}
