package ie.turfclub.service;

import ie.turfclub.dao.HorseDAO;
import ie.turfclub.model.HorseWithID;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class HorseServiceImpl implements HorseService {

	@Autowired
	private HorseDAO horseDAO;
	
	@Override
	public List<HorseWithID> getHorses(String containsChars) {
		
		return horseDAO.getHorses(containsChars);
	}

}
