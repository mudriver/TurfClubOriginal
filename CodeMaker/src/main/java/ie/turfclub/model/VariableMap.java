package ie.turfclub.model;

public class VariableMap {

	private String name;
	private String type;
	private String tableColumn;
	
	
	
	public VariableMap(String name, String type, String tableColumn) {
		super();
		this.name = name;
		this.type = type;
		this.tableColumn = tableColumn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTableColumn() {
		return tableColumn;
	}
	public void setTableColumn(String tableColumn) {
		this.tableColumn = tableColumn;
	}
	
	
	
}
