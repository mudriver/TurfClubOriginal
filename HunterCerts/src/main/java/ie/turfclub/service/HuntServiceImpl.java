package ie.turfclub.service;

import ie.turfclub.dao.HuntDAO;
import ie.turfclub.model.Hunt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HuntServiceImpl implements HuntService {

	@Autowired
	private HuntDAO huntDAO;
	
	@Override
	public Hunt getHunt(String id) {
		return huntDAO.getHunt(id);
		
	}

	@Override
	public List<Hunt> getHunts(String chars) {
		
		return huntDAO.getHunts(chars);
	}

	@Override
	public Hunt getHuntByHuntUser(String userName) {
		return huntDAO.getHuntByUser(userName);
	}

	
	
}
