package ie.turfclub.service;

import java.util.ArrayList;

public interface DatabaseService {

	public ArrayList<String> getCatelogNames(String connection);
	public ArrayList<String> getTableNames(String connection);
	public ArrayList<String> getColumns(String connection);
	
}
