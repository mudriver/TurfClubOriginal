package ie.turfclub.reporting.main;

import ie.turfclub.reporting.utilities.MailUtility;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * Hello world!
 * 
 */
public class App {
	
	private MailUtility mail = new MailUtility( null);
		
	
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		App app = new App();

		app.checkAccountsEmail();
		
		/*
		 * try { app.makeAccountsReport(); } catch (ClassNotFoundException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	//check emails from sales folder of chris.kane@turfclub.ie email for new emails and add info to database
	public void checkAccountsEmail(){
		
		mail.readEmailsAccounts();
		ArrayList<String> emailAddresses = new ArrayList<>();
		emailAddresses.add("chris.kane@turfclub.ie");
		try {
			mail.send("Hunter Certs Online Accounts Report", "Accounts Report for Hunter Certs Online Attached", emailAddresses, makeAccountsReport());
		} catch (ClassNotFoundException | SQLException | JRException e) {
			System.err.println(e);
		}
		
		
	}
	
	
	
	
	@SuppressWarnings({ "unchecked" })
	public String makeAccountsReport() throws ClassNotFoundException,
			SQLException, JRException {

		@SuppressWarnings("rawtypes")
		Map parameters = new HashMap();

		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection conn = DriverManager
				.getConnection("jdbc:mysql://www.turfclub.ie:3306/p2p?user=turfclu_dbuproot&password=estabp2p");

		// InputStream resourceAsStream =
		// Main.class.getResourceAsStream("../resources/tc_logo.jpg");
		// isReportImageOK(resourceAsStream);

		// parameters.put("tclogo", resourceAsStream);
		parameters.put("date", new Date().toString());
		String filename = new File(".").getAbsolutePath();

		filename = filename.substring(0, filename.length() - 2);
		String classpath = System.getProperty("java.class.path");
		System.out.println(new File("").getAbsolutePath());

	
			//JasperCompileManager.compileReportToFile(filename+ "/src/main/java/ie/turfclub/xmlToRacingPost/resources/AccountsReportHCerts.jrxml","C:\\Users\\resources.jasper");
			//
			// JasperReport report =
			// JasperCompileManager.compileReport(App.class.getResourceAsStream("../resources/AccountsReportHCerts.jrxml"));
			// JasperPrint jasperPrint = JasperFillManager.fillReport(report,
			// parameters, conn);

			// DefaultJasperReportsContext context =
			// DefaultJasperReportsContext.getInstance();
			// JOptionPane.showMessageDialog(new JFrame(),"Done Report Fil;");
			// JRPropertiesUtil.getInstance(context).setProperty("net.sf.jasperreports.default.pdf.embedded","true");
			JasperPrint print = JasperFillManager.fillReport(
					"C:\\Users\\resources.jasper", parameters, conn);
			// JOptionPane.showMessageDialog(new JFrame(),"Done Report Fil;");

			JasperExportManager.exportReportToPdfFile(print,
					"accountsReport.pdf");
		

		return "accountsReport.pdf";
	}

}
