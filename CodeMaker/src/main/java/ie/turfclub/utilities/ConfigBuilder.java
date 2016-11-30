package ie.turfclub.utilities;

public class ConfigBuilder {

	private String databaseConnection;
	private String databasePassword;
	private String databaseUserName;
	private String appSecurityUsersTable;
	private String appSecurityUserField;
	private String appSecurityPwdField;
	
	
	
	public ConfigBuilder(String databaseConnection, String databasePassword,
			String databaseUserName) {
		super();
		this.databaseConnection = databaseConnection;
		this.databasePassword = databasePassword;
		this.databaseUserName = databaseUserName;
	}


	
	
	public String getDatabaseConnection() {
		return databaseConnection;
	}




	public String getDatabasePassword() {
		return databasePassword;
	}




	public String getDatabaseUserName() {
		return databaseUserName;
	}




	public String getAppSecurityUsersTable() {
		return appSecurityUsersTable;
	}


	public void setAppSecurityUsersTable(String appSecurityUsersTable) {
		this.appSecurityUsersTable = appSecurityUsersTable;
	}


	public String getAppSecurityUserField() {
		return appSecurityUserField;
	}


	public void setAppSecurityUserField(String appSecurityUserField) {
		this.appSecurityUserField = appSecurityUserField;
	}


	public String getAppSecurityPwdField() {
		return appSecurityPwdField;
	}


	public void setAppSecurityPwdField(String appSecurityPwdField) {
		this.appSecurityPwdField = appSecurityPwdField;
	}
	
	private String createDBConfig(){
		return null;
	}
	
	private String createSecurityConfig(){
		return null;
	}
	
	private String createGeneralConfig(){
		return null;
	}
	
	public void buildConfig(){
		
	}
	
}
