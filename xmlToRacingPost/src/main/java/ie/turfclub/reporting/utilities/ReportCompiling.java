package ie.turfclub.reporting.utilities;

import java.io.File;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

public class ReportCompiling {

	
	public static void main(String[] args) throws Exception {
		ReportCompiling compile = new ReportCompiling();
		compile.compileReports("/resources/resources", "/CompiledReports");
		
	}
	
	public void compileReports(String reportsLocation, String outputDir){
		//check the input directory for .jasper files and compile each of them to the output folder
		String filename = new File(".").getAbsolutePath();

		filename = filename.substring(0, filename.length() - 2);
		System.out.println(filename + reportsLocation);
		File path = new File(filename + reportsLocation);

	    File [] files = path.listFiles();
	    for (int i = 0; i < files.length; i++){
	        if (files[i].isFile()){ //this line weeds out other directories/folders
	        	System.out.println(files[i].getName());
	        	if(files[i].getName().endsWith(".jrxml")){
	            
	            	System.out.println(files[i].getName());
	            	String output = files[i].getName().substring(0,files[i].getName().lastIndexOf(".")) + ".jasper";
	            	

	        	//	/AccountsReportHCerts.jrxml
	        	try {
					
	        		JasperCompileManager.compileReportToFile(filename+reportsLocation + "\\" + files[i].getName() , filename + outputDir + "/" + output);
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        		//
	        		// JasperReport report =
	        		// JasperCompileManager.compileReport(App.class.getResourceAsStream("../resources/AccountsReportHCerts.jrxml"));
	        		// JasperPrint jasperPrint = JasperFillManager.fillReport(report,
	        		// parameters, conn);

	        		// DefaultJasperReportsContext context =
	        		// DefaultJasperReportsContext.getInstance();
	        		// JOptionPane.showMessageDialog(new JFrame(),"Done Report Fil;");
	        		// JRPropertiesUtil.getInstance(context).setProperty("net.sf.jasperreports.default.pdf.embedded","true");
	            }
	        	
	        }
	    }
		
		
	}
	
}
