package ie.turfclub.service;

import ie.turfclub.model.HorseWithID;

import java.util.List;

public interface HorseService {

    public List<HorseWithID> getHorses(String chars);
	
}
