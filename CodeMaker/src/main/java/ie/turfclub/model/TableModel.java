package ie.turfclub.model;

import java.util.ArrayList;

public class TableModel {

	private String className;
	private ArrayList<VariableMap> variables;
	
	private String catelog;
	private String tableName;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public ArrayList<VariableMap> getVariables() {
		return variables;
	}
	public void setVariables(ArrayList<VariableMap> variables) {
		this.variables = variables;
	}
	public String getCatelog() {
		return catelog;
	}
	public void setCatelog(String catelog) {
		this.catelog = catelog;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	
	
	
	
}


