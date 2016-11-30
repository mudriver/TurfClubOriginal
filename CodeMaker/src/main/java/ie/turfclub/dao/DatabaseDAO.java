package ie.turfclub.dao;

import java.util.ArrayList;

public interface DatabaseDAO {

	public ArrayList<String> getCatelogNames(String connection);
	public ArrayList<String> getTableNames(String db);
	public ArrayList<String> getColumns(String connection);
}
