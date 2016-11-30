package ie.turfclub.dao;

import ie.turfclub.model.HorseWithID;


import java.util.List;

public interface HorseDAO {

	public List<HorseWithID> getHorses(String containsChars);
}
