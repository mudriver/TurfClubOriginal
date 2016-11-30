package ie.turfclub.service;


import java.util.List;

import ie.turfclub.model.HunterCert;
 
public interface HunterCertService  {
 
    public void addHunterCert(HunterCert hunterCert);
    public HunterCert getHunterCert(int id);
    public void updateHunterCert(HunterCert hunterCert);
    public void deleteHunterCert(int id);
    public List<HunterCert> getHunterCertsByHunt(int huntId);
    public void approveHunterCertByHunt(int huntcertID);
    public void rejectHunterCertByHunt(int huntcertID);
 
}