package ie.turfclub.reporting.utilities;



import ie.turfclub.reporting.model.vetreports.VetreportMeetingsNotGenerated;
import ie.turfclub.reporting.model.vetreports.VetreportReportsSent;
import ie.turfclub.reporting.service.FormService;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


public class VetReporting {
	

	@Autowired
	FormService formService;
	@Autowired
	MailUtility sendMail;
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws JRException{
	
	}
	
	
	public void createAllVetReports(Connection conn){
		System.out.println("IMAGE");
		System.out.println("FS" + formService);
		BufferedImage image = null;
		try {
			image = ImageIO.read(VetReporting.class.getResourceAsStream("/resources/tclogo.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("image error");
			e.printStackTrace();
		}
		System.out.println("MEETINGS");
		List<VetreportMeetingsNotGenerated> meetings = formService.getMeetingsNotGenerated();
		System.out.println("Meetings Found:" + meetings.size());
		if(meetings.size() > 0){
			for(VetreportMeetingsNotGenerated meeting : meetings){
				
				makeVetReports(conn, meeting.getMeeting(), format.format(meeting.getDateRan()), image);
				VetreportReportsSent reportSent = new VetreportReportsSent();
				reportSent.setSentDate(meeting.getDateRan());
				reportSent.setSentMeeting(meeting.getMeeting());
				formService.setReportSent(reportSent);
			}
		}
		else{
			System.out.println("No meetings");
		}
		
	}


	public void makeVetReports(Connection conn, String meeting, String date, BufferedImage image) {

		

		@SuppressWarnings("rawtypes")
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		System.out.println(meeting + date);
		parameters.put("meeting", meeting);
		parameters.put("date", date);
		parameters.put("tclogo", image);
		JasperPrint print;
		try {
			print = JasperFillManager.fillReport(
					VetReporting.class.getResourceAsStream("/resources/VetReports.jasper"), parameters, conn);
			JasperExportManager.exportReportToPdfFile(print, "vetReport_" + meeting + "_" + date + ".pdf");
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sendMail.sendVetsEmail("Vet Report " + meeting + " " + date, "Please find attached Secondary Veterinary Report", "vetReport_" + meeting + "_" + date + ".pdf", false);
		
		
		try {
			print = JasperFillManager.fillReport(
					VetReporting.class.getResourceAsStream("/resources/VetReportsTrainers.jasper"), parameters, conn);
			JasperExportManager.exportReportToPdfFile(print, "vetReport_trainers_" + meeting + "_" + date + ".pdf");
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sendMail.sendVetsEmail("Trainers Report " + meeting + " " + date, "Please find attached Trainers Report", "vetReport_trainers_" + meeting + "_" + date + ".pdf", true);
		
		
		System.out.println("Report done");
	
		        try {
		            File destDir = new File("\\\\tcdc01\\Company\\WinData\\RaceDayDocs\\GeneratedReports\\VetReports" );
		            File srcFile = new File("vetReport_" + meeting + "_" + date + ".pdf");
		            FileUtils.copyFileToDirectory(srcFile, destDir);
		        } catch(Exception e) {
		        	System.out.println(e);
		        }

		//System.out.println("end Date" + endSqldate);
		/*List<DisEnquiries> enqs = query
				.executeHQLQuery("from DisEnquiries d where d.recAccountsProcessed=0 and d.recDate<='"
						+ endSqldate + "'");
		Session currentSession = query.getSessionFactory().openSession();
		org.hibernate.Transaction tx = null;

		try {

			System.out.println("Updating acc recs");
			for (DisEnquiries d : enqs) {
				tx = currentSession.beginTransaction();
				d.setRecAccountsProcessed(new Byte("1"));
				currentSession.saveOrUpdate(d);
				tx.commit();

			}
		} catch (Exception e) {
			System.err.print(e);
			if (tx != null) {

				tx.rollback();

			}
			JOptionPane.showMessageDialog(new JFrame(),
					"Accounts records could not be updated");

		} finally {
			if (currentSession.isOpen()) {
				currentSession.close();
			}

		}*/

		// SendMail sendEmail = new SendMail();
		// sendEmail.sendAccountsEmail("accounts_report.xls");
		
	}
	
	
	
	

	

}
