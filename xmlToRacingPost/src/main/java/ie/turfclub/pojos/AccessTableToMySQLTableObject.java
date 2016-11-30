package ie.turfclub.pojos;

import java.util.ArrayList;

public class AccessTableToMySQLTableObject {

	private ArrayList<String> mySQLTableFields;
	private ArrayList<String> accessTableFields;
	private String mySQLConnection;
	private String mySQLTable;
	private String accessTable;
	private String accessFilePath;
	
	public ArrayList<String> getMySQLTableFields() {
		return mySQLTableFields;
	}
	public void setMySQLTableFields(ArrayList<String> mySQLTableFields) {
		this.mySQLTableFields = mySQLTableFields;
	}
	public ArrayList<String> getAccessTableFields() {
		return accessTableFields;
	}
	public void setAccessTableFields(ArrayList<String> accessTableFields) {
		this.accessTableFields = accessTableFields;
	}
	public String getMySQLConnection() {
		return mySQLConnection;
	}
	public void setMySQLConnection(String mySQLConnection) {
		this.mySQLConnection = mySQLConnection;
	}
	public String getMySQLTable() {
		return mySQLTable;
	}
	public void setMySQLTable(String mySQLTable) {
		this.mySQLTable = mySQLTable;
	}
	public String getAccessTable() {
		return accessTable;
	}
	public void setAccessTable(String accessTable) {
		this.accessTable = accessTable;
	}
	public String getAccessFilePath() {
		return accessFilePath;
	}
	public void setAccessFilePath(String accessFilePath) {
		this.accessFilePath = accessFilePath;
	}
	
	
	
}
