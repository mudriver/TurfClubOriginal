package ie.turfclub.xmlToRacingPost.service;


import ie.turfclub.xmlToRacingPost.dao.HunterCertDAO;
import ie.turfclub.xmlToRacingPost.model.HunterCert;

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
 public void addHunterCert(HunterCert HunterCert) {
  hunterCertDAO.addHunterCert(HunterCert);
 }
 
 @Override
 public void updateHunterCert(HunterCert HunterCert) {
  hunterCertDAO.updateHunterCert(HunterCert);
 }
 
 @Override
 public HunterCert getHunterCert(int id) {
  return hunterCertDAO.getHunterCert(id);
 }
 
 @Override
 public void deleteHunterCert(int id) {
  hunterCertDAO.deleteHunterCert(id);
 }
 


@Override
public List<HunterCert> getHunterCertsByHunt(int huntId) {
	return hunterCertDAO.getHunterCertsByHuntId(huntId);
}

@Override
public void approveHunterCertByHunt(int huntcertID) {
	hunterCertDAO.approveHunterCertByHunt(huntcertID);
	
}
 
@Override
public void rejectHunterCertByHunt(int huntcertID) {
	hunterCertDAO.rejectHunterCertByHunt(huntcertID);
	
}

}