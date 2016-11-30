package ie.turfclub.dao;

import ie.turfclub.utilities.DatabaseReader;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseDAOImpl implements DatabaseDAO {

	@Autowired
	DatabaseReader reader;
	
	@Override
	public ArrayList<String> getCatelogNames(String connection) {
		
		return reader.getDatabases();
	}

	@Override
	public ArrayList<String> getTableNames(String db) {
		return reader.getTables(db);
	}

	@Override
	public ArrayList<String> getColumns(String connection) {
		return reader.
	}

}
