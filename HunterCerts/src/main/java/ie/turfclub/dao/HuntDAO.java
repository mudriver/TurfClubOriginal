package ie.turfclub.dao;

import ie.turfclub.model.Hunt;

import java.util.List;

public interface HuntDAO {

	public Hunt getHunt(String id);
	public List<Hunt> getHunts(String containsChars);
	public Hunt getHuntByUser(String user);
}
