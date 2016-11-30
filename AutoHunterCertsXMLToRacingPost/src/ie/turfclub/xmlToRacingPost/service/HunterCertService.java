package ie.turfclub.xmlToRacingPost.service;


import ie.turfclub.xmlToRacingPost.model.HunterCert;

import java.util.List;


 
public interface HunterCertService  {
 
    public void addHunterCert(HunterCert hunterCert);
    public HunterCert getHunterCert(int id);
    public void updateHunterCert(HunterCert hunterCert);
    public void deleteHunterCert(int id);
    public List<HunterCert> getHunterCertsByHunt(int huntId);
    public void approveHunterCertByHunt(int huntcertID);
    public void rejectHunterCertByHunt(int huntcertID);
 
}