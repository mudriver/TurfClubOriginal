package ie.turfclub.service;

import java.util.List;

import ie.turfclub.model.Hunt;

public interface HuntService {

	public Hunt getHunt(String id);
	public List<Hunt> getHunts(String chars);	
	public Hunt getHuntByHuntUser(String userName);
	
}
