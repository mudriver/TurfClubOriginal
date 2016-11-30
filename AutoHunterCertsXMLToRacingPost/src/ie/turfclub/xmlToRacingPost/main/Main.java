package ie.turfclub.xmlToRacingPost.main;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ie.turfclub.xmlToRacingPost.config.XMLToRacingPostConfig;



public class Main {


	
	public static void main(String [] args){
		System.out.println("Running");
		JOptionPane.showMessageDialog(new JFrame(), "Running");
		AnnotationConfigApplicationContext ctx = 
			      new AnnotationConfigApplicationContext();
		//generateXML for Racing Post
		JOptionPane.showMessageDialog(new JFrame(), "R2a");
		//ctx.register(DatabaseConfig.class);
		JOptionPane.showMessageDialog(new JFrame(), "R2b");
		ctx.register(XMLToRacingPostConfig.class);
		JOptionPane.showMessageDialog(new JFrame(), "R2b");
		ctx.refresh();
		JOptionPane.showMessageDialog(new JFrame(), "R2");
		Main main = new Main();
		JOptionPane.showMessageDialog(new JFrame(), "R3");
		
			
	}
	
	
	
	
	
	
	public Image readImage(byte[] bytes) throws JRException
	{
		InputStream bais = new ByteArrayInputStream(bytes);

		Image image = null;
		try
		{
			image = ImageIO.read(bais);
		}
		catch (Exception e)
		{
			throw new JRException(e);
		}
		finally
		{
			try
			{
				bais.close();
			}
			catch (IOException e)
			{
			}
		}

		if (image == null)
		{
			throw new JRException("Image read failed.");
		}

		return image;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public String makeAccountsReport() throws ClassNotFoundException, SQLException{
		 @SuppressWarnings("rawtypes")
		Map parameters = new HashMap();
		 
		 Class.forName("com.mysql.jdbc.Driver");
		 java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://www.turfclub.ie:3306/p2p?user=turfclu_dbuproot&password=estabp2p");
		 
		 //InputStream resourceAsStream = Main.class.getResourceAsStream("../resources/tc_logo.jpg");
		//isReportImageOK(resourceAsStream);
		try {
			JOptionPane.showMessageDialog(new JFrame(), "Image");
			BufferedImage image = ImageIO.read(Main.class.getResourceAsStream("../resources/tc_logo.jpg"));
			JOptionPane.showMessageDialog(new JFrame(),"Done Report Img;");
			parameters.put("tclogo", image);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(new JFrame(), "e");
			e.printStackTrace();
		}
		 //parameters.put("tclogo", resourceAsStream);
		 parameters.put("date", new Date().toString());
		 String filename = new File(".").getAbsolutePath();
		
		 filename = filename.substring(0, filename.length()-2);
		 String classpath = System.getProperty("java.class.path");
		 System.out.println(new File("").getAbsolutePath()); 
		 System.out.println(classpath);
		 System.out.println(filename);
		
		 try {
			 //JasperCompileManager.compileReportToFile(filename + "/src/ie/turfclub/xmlToRacingPost/resources/AccountsReportHCerts.jrxml", filename+  "/src/ie/turfclub/xmlToRacingPost/resources/AccountsReportHCerts.jasper");
			 //
			 //JasperReport report = JasperCompileManager.compileReport(Main.class.getResourceAsStream("../resources/AccountsReportHCerts.jrxml"));
			// JasperPrint jasperPrint = JasperFillManager.fillReport(report,  parameters, conn);
			 
			 //DefaultJasperReportsContext context = DefaultJasperReportsContext.getInstance(); 
			 JOptionPane.showMessageDialog(new JFrame(),"Done Report Fil;");
			 //JRPropertiesUtil.getInstance(context).setProperty("net.sf.jasperreports.default.pdf.embedded","true");
			 JasperPrint print = JasperFillManager.fillReport(Main.class.getResourceAsStream("../resources/AccountsReportHCerts.jasper"),
			            parameters, conn);
			 JOptionPane.showMessageDialog(new JFrame(),"Done Report Fil;");
			
			 JasperExportManager.exportReportToPdfFile(print,
	                  "accountsReport.pdf");
					} catch (JRException e1) {
						JOptionPane.showMessageDialog(new JFrame(),e1);
			e1.printStackTrace();
		}
		
		 JOptionPane.showMessageDialog(new JFrame(),"Done");
		return "";
	}
	
	
	
	
}
