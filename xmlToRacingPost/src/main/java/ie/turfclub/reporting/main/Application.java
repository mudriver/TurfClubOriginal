package ie.turfclub.reporting.main;

import ie.turfclub.pojos.AccessTableToMySQLTableObject;
import ie.turfclub.reporting.dao.HCertSalesDAO;
import ie.turfclub.reporting.model.pointToPoint.HuntercertsSales;
import ie.turfclub.reporting.utilities.AccessImportExport;
import ie.turfclub.reporting.utilities.AccountReporting;
import ie.turfclub.reporting.utilities.MailUtility;
import ie.turfclub.reporting.utilities.QueryIrishRacing;
import ie.turfclub.reporting.utilities.VetReporting;
import ie.turfclub.reporting.utilities.XmlUtility;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import net.sf.jasperreports.engine.JRException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Anuj
 * @source goldenpackagebyanuj.blogspot.com
 */
@Component
public class Application {

	private SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private MailUtility mail;
	@Autowired
	private XmlUtility xmlUtils;
	@Autowired
	private HCertSalesDAO salesDAO;
	@Autowired
	private AccountReporting accountsReporting;
	@Autowired
	private QueryIrishRacing queryIrishRacing;
	@Autowired
	private VetReporting vetReporting;

	// arg options are as follows:
	// "accountsHunterCerts" generates accounts reports at end of day
	// - takes an optional second arg of date for which to generate the reports
	// in mysql format yyyy-MM-dd
	// "xmlToRacingPost" generates xml code from online huntercerts programme
	// and sends to Racing post
	// "xmlFromRacingPost" inputs data from xml file received from racing post
	// into the huntercerts programme

	public static void main(String[] args) throws Exception {

		// configre the application for spring hibernate database and DI support

		System.out.println("Context1");
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"resources/spring-config.xml");
		System.out.println("Context");
		Application standalone = ctx.getBean(Application.class);
		// Application app = new Application();
		// mail = (MailUtility) ctx.getBean(MailUtility.class);
		int argsLength = args.length;
		// if the arguments length is 1 or greater check what the argument is
		if (argsLength == 1) {

			String input = args[0];
			// if the argument is accounts generate and email
			if (input.equals("accounts")) {
				// parse the input date from second argument if it exists
				// otherwise use yesterdays date
				if (argsLength == 2) {
					standalone.makeAccountsReport(args[1]);

				} else {
					standalone.makeAccountsReport(null);
				}

				System.exit(0);
			}
			// if the argument is xmlToRacingPost generate xml Feed for Racing
			// Post and Upload via FTP
			else if (input.equals("xmlToRacingPost")) {
				standalone.makeXmlFileForRacingPost();
			}
			// if the argument is xmlFromRacingPost download XML from Racing
			// Post FTP and update huntercerts database
			else if (input.equals("xmlFromRacingPost")) {
				System.out.println("read XML");
				standalone.readXMlFileFromRacingPost();
			} else if (input.equals("accountsDisciplinariesFinesReport")) {
				System.out.println("fines Report");
				standalone.makeAccountsFinesReport();
			} else if (input.equals("updateFormFile")) {
				standalone.updateFormFile();
			} else if (input.equals("vetreports")) {
				standalone.sendVetReports();
			}
			else if (input.equals("updateTrainers")) {
				standalone.copyTrainersToMysqlDB();
				standalone.updateTrainers();
			}
			else if (input.equals("updateInspectionsOfficials")) {
				standalone.copyOfficialsToInspectionsMysqlDB();
			}
			

		} else {
			standalone.mail
					.sendITError(
							"Command Line Error",
							"The system requires a command line argument:"
									+ "arg options are as follows: \"accounts\" generates accounts reports at end of day \"xmlToRacingPost\" generates xml code from online huntercerts programme and sends to Racing post \"xmlFromRacingPost\" inputs data from xml file received from racing post into the huntercerts programme");
		}

		// standalone.checkAccountsEmail();

		/*
		 * try { app.makeAccountsReport(); } catch (ClassNotFoundException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	
	
	public void copyOfficialsToInspectionsMysqlDB(){
		AccessTableToMySQLTableObject mySQLAccessObject = new AccessTableToMySQLTableObject();
		mySQLAccessObject.setAccessFilePath("\\\\tcdc01\\Users\\AnnDoc\\Ann_W\\Access\\Duties\\Duties2015.mdb");
		mySQLAccessObject.setAccessTable("Officials");
		ArrayList<String> accessHeaders = new ArrayList<>();
		accessHeaders.add("PetName");
		accessHeaders.add("Fullname");
		accessHeaders.add("Initials");

		

		mySQLAccessObject.setAccessTableFields(accessHeaders);
		ArrayList<String> mysqlHeaders = new ArrayList<>();
		mysqlHeaders.add("officials_first_name");
		mysqlHeaders.add("officials_surname");
		mysqlHeaders.add("officials_initials");

		mySQLAccessObject.setMySQLTableFields(mysqlHeaders);
		mySQLAccessObject.setMySQLTable("inspections_officials");
		mySQLAccessObject.setMySQLConnection("jdbc:mysql://www.turfclub.ie:3306/inspections?user=root&password=1790@estab");
		AccessImportExport importer = new AccessImportExport();
		try {
			importer.copyOfficialsFromAccessToMysql(mySQLAccessObject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DONE FTY ROSTER");
		mySQLAccessObject = new AccessTableToMySQLTableObject();
		mySQLAccessObject.setAccessFilePath("\\\\tcdc01\\users\\TanyaM\\Tanya\\SECURITY\\Roster\\Roster.mdb");
		mySQLAccessObject.setAccessTable("Name and Addresses");
		accessHeaders = new ArrayList<>();
		accessHeaders.add("Firstname");
		accessHeaders.add("Lastname");
		
	
		mySQLAccessObject.setAccessTableFields(accessHeaders);
		mysqlHeaders = new ArrayList<>();
		mysqlHeaders.add("officials_first_name");
		mysqlHeaders.add("officials_surname");
		mySQLAccessObject.setMySQLTableFields(mysqlHeaders);
		mySQLAccessObject.setMySQLTable("inspections_officials");
		mySQLAccessObject.setMySQLConnection("jdbc:mysql://www.turfclub.ie:3306/inspections?user=root&password=1790@estab");
		importer = new AccessImportExport();
		try {
			importer.copyOfficialsFromAccessToMysql(mySQLAccessObject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void copyTrainersToMysqlDB(){
		
		
		AccessTableToMySQLTableObject mySQLAccessObject = new AccessTableToMySQLTableObject();
		mySQLAccessObject.setAccessFilePath("\\\\tcdc01\\Company\\WinData\\LicRenewal\\TrainersLicence\\TrLicence.mdb");
		mySQLAccessObject.setAccessTable("TrainersTable");
		ArrayList<String> accessHeaders = new ArrayList<>();
		accessHeaders.add("FirstName,SurName");
		accessHeaders.add("DateRequisted");
		accessHeaders.add("MakeLicence");
		accessHeaders.add("AccountNo");
		accessHeaders.add("SurName");
		accessHeaders.add("FirstName");
		accessHeaders.add("Address1");
		accessHeaders.add("Address2");
		accessHeaders.add("Address3");
		accessHeaders.add("Address Of Stables 1");
		accessHeaders.add("Address Of Stables 2");
		accessHeaders.add("Address Of Stables 3");
		accessHeaders.add("Home Phone");
		accessHeaders.add("Mobile");
		accessHeaders.add("Fax No");
		accessHeaders.add("Email Address");
		accessHeaders.add("Date Of Birth");
		accessHeaders.add("Restricted");
		accessHeaders.add("Hunter");
		accessHeaders.add("Curragh");
		accessHeaders.add("Date Insurance Expires");
		//accessHeaders.add("Date Lease Expires");
		//accessHeaders.add("Date 2nd Lease Expires");
		//accessHeaders.add("Employer Liability");
		//accessHeaders.add("Public Liability");
		//accessHeaders.add("Leased From");
		//accessHeaders.add("Photo");
		//accessHeaders.add("DataProtection");
		//accessHeaders.add("TCID");
		//accessHeaders.add("ContractOfEmployment");
		//accessHeaders.add("Equine Premises Number");
		//accessHeaders.add("RegisteredWithDeptAgri");
		//accessHeaders.add("NameRegistered");
		mySQLAccessObject.setAccessTableFields(accessHeaders);
		ArrayList<String> mysqlHeaders = new ArrayList<>();
		mysqlHeaders.add("trainer_name");
		mysqlHeaders.add("trainer_date_requested");
		mysqlHeaders.add("trainer_batch_no");
		mysqlHeaders.add("trainer_account_no");
		mysqlHeaders.add("trainer_surname");
		mysqlHeaders.add("trainer_first_name");
		mysqlHeaders.add("trainer_address1");
		mysqlHeaders.add("trainer_address2");
		mysqlHeaders.add("trainer_address3");
		mysqlHeaders.add("trainer_stable_address1");
		mysqlHeaders.add("trainer_stable_address2");
		mysqlHeaders.add("trainer_stable_address3");
		mysqlHeaders.add("trainer_home_phone");
		mysqlHeaders.add("trainer_mobile_phone");
		mysqlHeaders.add("trainer_fax");
		mysqlHeaders.add("trainer_email");
		mysqlHeaders.add("trainer_date_of_birth");
		mysqlHeaders.add("trainer_restricted");
		mysqlHeaders.add("trainer_hunter_chase");
		mysqlHeaders.add("trainer_curragh");
		mysqlHeaders.add("trainer_insurance_expiry");
		mySQLAccessObject.setMySQLTableFields(mysqlHeaders);
		mySQLAccessObject.setMySQLTable("lic_trainers");
		mySQLAccessObject.setMySQLConnection("jdbc:mysql://www.turfclub.ie:3306/licencing?user=root&password=1790@estab");
		AccessImportExport importer = new AccessImportExport();
		try {
			importer.readFromAccessToMysql(mySQLAccessObject, false, " WHERE NOT EXISTS (SELECT trainer_account_no FROM lic_trainers WHERE trainer_account_no ='", "AccountNo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		/*
		accessHeaders = new ArrayList<>();
		accessHeaders.add("OwnerAC");
		accessHeaders.add("OwnerACLocked");
		accessHeaders.add("OwnerFirstname");
		accessHeaders.add("OwnerSurname");
		accessHeaders.add("Address1");
		accessHeaders.add("Address2");
		accessHeaders.add("Address3");
		accessHeaders.add("Address4");
		accessHeaders.add("MobileNo");
		accessHeaders.add("PhoneNo");
		accessHeaders.add("DateOfBirth");
		accessHeaders.add("EmailAddress");
		accessHeaders.add("HRI_AC");
		accessHeaders.add("Jacket");
		accessHeaders.add("Sleeves");
		accessHeaders.add("Cap");
		accessHeaders.add("Colours");
		accessHeaders.add("JacketColour");
		accessHeaders.add("JacketDesignType");
		accessHeaders.add("JacketDesignColour");
		accessHeaders.add("SleevesColour");
		accessHeaders.add("SleevesDesignType");
		accessHeaders.add("SleevesDesignColour");
		accessHeaders.add("CapColour");
		accessHeaders.add("CapDesignType");
		accessHeaders.add("CapDesignColour");
		accessHeaders.add("UseHRI_AC");
		accessHeaders.add("DataProtection");
		accessHeaders.add("RaceCardName");
		accessHeaders.add("MultipleOwner");
		accessHeaders.add("DateInputted");
		accessHeaders.add("Owner");
		accessHeaders.add("Handler");
		accessHeaders.add("Status");
		accessHeaders.add("AllowOverride");
		accessHeaders.add("HandlerRenewal20112012");
		accessHeaders.add("HandlerRenewal20132014");
		accessHeaders.add("Labels");
		accessHeaders.add("HandlersPwd");
		accessHeaders.add("InsuranceCompany");
		accessHeaders.add("PolicyNumber");
		accessHeaders.add("RenewalEmailSent");
		accessHeaders.add("ToBeChecked");
		mySQLAccessObject.setAccessTableFields(accessHeaders);
		mysqlHeaders = new ArrayList<>();
		mysqlHeaders.add("owner_account_no");
		mysqlHeaders.add("owner_account_locked");
		mysqlHeaders.add("owner_first_name");
		mysqlHeaders.add("owner_surname");
		mysqlHeaders.add("owner_address1");
		mysqlHeaders.add("owner_address2");
		mysqlHeaders.add("owner_address3");
		mysqlHeaders.add("owner_address4");
		mysqlHeaders.add("owner_mobile_no");
		mysqlHeaders.add("owner_phone_no");
		mysqlHeaders.add("owner_date_of_birth");
		mysqlHeaders.add("owner_email");
		mysqlHeaders.add("owner_hri_acc_no");
		mysqlHeaders.add("owner_jacket");
		mysqlHeaders.add("owner_sleeves");
		mysqlHeaders.add("owner_cap");
		mysqlHeaders.add("owner_colours");
		mysqlHeaders.add("owner_jacket_colour");
		mysqlHeaders.add("owner_jacket_design_type");
		mysqlHeaders.add("owner_jacket_design_colour");
		mysqlHeaders.add("owner_sleeves_colour");
		mysqlHeaders.add("owner_sleeves_design");
		mysqlHeaders.add("owner_sleeves_design_colour");
		mysqlHeaders.add("owner_cap_colour");
		mysqlHeaders.add("owner_cap_design_type");
		mysqlHeaders.add("owner_cap_design_colour");
		mysqlHeaders.add("owner_use_hri_acc_no");
		mysqlHeaders.add("owner_data_protection");
		mysqlHeaders.add("owner_racecard_name");
		mysqlHeaders.add("owner_multiple_owner");
		mysqlHeaders.add("owner_date_inputted");
		mysqlHeaders.add("owner_owner");
		mysqlHeaders.add("owner_handler");
		mysqlHeaders.add("owner_status");
		mysqlHeaders.add("owner_allow_override");
		mysqlHeaders.add("owner_handler_renewal_2011_12");
		mysqlHeaders.add("owner_handler_renewal_2013_14");
		mysqlHeaders.add("owner_labels");
		mysqlHeaders.add("owner_handlers_pwd");
		mysqlHeaders.add("owners_handler_insurance_company");
		mysqlHeaders.add("owner_handler_insurance_policy_number");
		mysqlHeaders.add("owner_handler_renewal_email_sent");
		mysqlHeaders.add("owner_to_be_checked");
		mySQLAccessObject.setMySQLTableFields(mysqlHeaders);
		mySQLAccessObject.setMySQLTable("lic_p2p_owners_temp_copy");
		mySQLAccessObject.setAccessFilePath("\\\\tcdc01\\Company\\WinData\\P2PEntries\\MasterEntryProgram.mdb");
		mySQLAccessObject.setAccessTable("OwnersReg");
		try {
			importer.readFromAccessToMysql(mySQLAccessObject, false, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}

	private void sendVetReports() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Connection conn = null;
		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://www.turfclub.ie:3306/vetreports?user=root&password=1790@estab");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		vetReporting.createAllVetReports(conn);
	}

	private void updateFormFile() {
		try {
			queryIrishRacing.updateFormFile();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void makeAccountsFinesReport() throws ClassNotFoundException,
			SQLException {
		// create a jdbc connection to check database records using plain sql
		// and pass the connection to the report builder
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection conn = DriverManager
				.getConnection("jdbc:mysql://www.turfclub.ie:3306/turf201_disciplinaries?user=turfclu_dbuproot&password=estabp2p");
		accountsReporting.makeWeeklyDisciplinaryFinesReport(conn);

	}

	// checks the huntercerts table for any records from the current day
	// and makes an xml of the data and uploads to Racing Post FTP
	private void makeXmlFileForRacingPost()
			throws ParserConfigurationException, TransformerException {

		xmlUtils.buildXMLFileForRacingPost("TC_RP.xml");

	}

	private void readXMlFileFromRacingPost() {
		try {
			xmlUtils.importXMLFromRacingPost("turfclub_horselist_RP_TC.xml");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public String makeAccountsReport(String sqlDate)
			throws ClassNotFoundException, SQLException, JRException {

		// check if there is an input date otherwise use yesterdays date
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		if (sqlDate == null) {

			DateTime dt = new DateTime();
			dt.minusDays(1);
			sqlDate = formatter.print(dt);
		}

		// read data from sales emails
		ArrayList<HuntercertsSales> sales = mail.readEmailsAccounts();
		// save sales objects to database
		System.out.println(sales.size());
		for (HuntercertsSales sale : sales) {
			salesDAO.addHunterCertSales(sale);
		}

		// create a jdbc connection to check database records using plain sql
		// and pass the connection to the report builder
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection conn = DriverManager
				.getConnection("jdbc:mysql://www.turfclub.ie:3306/p2p?user=turfclu_dbuproot&password=estabp2p");

		// check that there are no unmatched records from either huntercerts or
		// sales
		// send email to IT and Accounts if there is
		boolean sendErrorMail = false;
		String orderId = "";
		int rowCount = 0;
		String selectUnmatchedSales = "SELECT * FROM p2p_huntercerts_sales  WHERE sales_order_id  NOT IN (SELECT p.`hcert_order_id`  FROM `p2p_hunter_certs` p WHERE DATE(p.`hcert_transaction_time`) = DATE("
				+ sqlDate + "))";
		String selectUnmatchedCerts = "SELECT * FROM `p2p_hunter_certs` p WHERE DATE(p.`hcert_transaction_time`) = DATE("
				+ sqlDate
				+ ") and  p.`hcert_order_id` NOT IN (SELECT `sales_order_id`  FROM p2p_huntercerts_sales)";
		Statement stmt = conn.createStatement();

		// check the huntercerts for matching sales
		ResultSet rs = stmt.executeQuery(selectUnmatchedCerts);
		while (rs.next()) {
			orderId += rs.getString("hcert_order_id") + ";";
			rowCount++;
		}
		rs.close();
		stmt.close();
		sendErrorMail = (rowCount >= 1);
		if (sendErrorMail) {
			mail.sendITAndAccountsError("No Matching Sale For HunterCert",
					orderId);
		}

		// reset variables
		orderId = "";
		sendErrorMail = false;
		rowCount = 0;
		stmt = conn.createStatement();

		// check sales for matching huntercerts
		rs = stmt.executeQuery(selectUnmatchedSales);
		while (rs.next()) {
			orderId += rs.getString("sales_order_id") + ";";
			rowCount++;
		}
		rs.close();
		stmt.close();
		sendErrorMail = (rowCount >= 1);
		if (sendErrorMail) {
			mail.sendITAndAccountsError("No Matching HunterCert For Sale",
					orderId);
		}

		// make the daily report for accounts
		accountsReporting.makeHunterCertsAccountsReport(conn, sqlDate);
		// close db connection after report is made
		conn.close();

		ArrayList<String> emailAddresses = new ArrayList<>();
		emailAddresses.add("chris.kane@turfclub.ie");

		mail.send("Hunter Certs Online Accounts Report",
				"Accounts Report for Hunter Certs Online Attached",
				emailAddresses, "accountsReport.pdf");

		// InputStream resourceAsStream =
		// Main.class.getResourceAsStream("../resources/tc_logo.jpg");
		// isReportImageOK(resourceAsStream);

		// parameters.put("tclogo", resourceAsStream);

		System.out.println("end");
		return "accountsReport.pdf";
	}

	public void updateTrainers(){
		
		AccessTableToMySQLTableObject mySQLAccessObject = new AccessTableToMySQLTableObject();
		mySQLAccessObject.setAccessFilePath("\\\\tcdc01\\Company\\WinData\\LicRenewal\\TrainersLicence\\TrLicence.mdb");
		mySQLAccessObject.setAccessTable("TrainersTable");
		ArrayList<String> accessHeaders = new ArrayList<>();
		accessHeaders.add("FirstName,SurName");
		accessHeaders.add("MakeLicence");
		accessHeaders.add("SurName");
		accessHeaders.add("FirstName");
		accessHeaders.add("Address1");
		accessHeaders.add("Address2");
		accessHeaders.add("Address3");
		accessHeaders.add("Address Of Stables 1");
		accessHeaders.add("Address Of Stables 2");
		accessHeaders.add("Address Of Stables 3");
		accessHeaders.add("Home Phone");
		accessHeaders.add("Mobile");
		accessHeaders.add("Fax No");
		accessHeaders.add("Email Address");
		//accessHeaders.add("Date Of Birth");
		accessHeaders.add("Restricted");
		accessHeaders.add("Hunter");
		accessHeaders.add("Curragh");
		//accessHeaders.add("Date Insurance Expires");
		//accessHeaders.add("Date Lease Expires");
		//accessHeaders.add("Date 2nd Lease Expires");
		//accessHeaders.add("Employer Liability");
		//accessHeaders.add("Public Liability");
		//accessHeaders.add("Leased From");
		//accessHeaders.add("Photo");
		//accessHeaders.add("DataProtection");
		//accessHeaders.add("TCID");
		//accessHeaders.add("ContractOfEmployment");
		//accessHeaders.add("Equine Premises Number");
		//accessHeaders.add("RegisteredWithDeptAgri");
		//accessHeaders.add("NameRegistered");
		mySQLAccessObject.setAccessTableFields(accessHeaders);
		ArrayList<String> mysqlHeaders = new ArrayList<>();
		mysqlHeaders.add("trainer_name");
		//mysqlHeaders.add("trainer_date_requested");
		mysqlHeaders.add("trainer_batch_no");
		mysqlHeaders.add("trainer_surname");
		mysqlHeaders.add("trainer_first_name");
		mysqlHeaders.add("trainer_address1");
		mysqlHeaders.add("trainer_address2");
		mysqlHeaders.add("trainer_address3");
		mysqlHeaders.add("trainer_stable_address1");
		mysqlHeaders.add("trainer_stable_address2");
		mysqlHeaders.add("trainer_stable_address3");
		mysqlHeaders.add("trainer_home_phone");
		mysqlHeaders.add("trainer_mobile_phone");
		mysqlHeaders.add("trainer_fax");
		mysqlHeaders.add("trainer_email");
		//mysqlHeaders.add("trainer_date_of_birth");
		mysqlHeaders.add("trainer_restricted");
		mysqlHeaders.add("trainer_hunter_chase");
		mysqlHeaders.add("trainer_curragh");
		//mysqlHeaders.add("trainer_insurance_expiry");
		mySQLAccessObject.setMySQLTableFields(mysqlHeaders);
		mySQLAccessObject.setMySQLTable("lic_trainers");
		mySQLAccessObject.setMySQLConnection("jdbc:mysql://www.turfclub.ie:3306/licencing?user=root&password=1790@estab");
		AccessImportExport importer = new AccessImportExport();

			try {
				importer.updateTrainersTable(mySQLAccessObject);
			}  catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		
	}
	
	
}
