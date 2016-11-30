package ie.turfclub.reporting.utilities;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPUtility {

	private String rpserver = "cw3.tm-xnet.com";
    private int port = 21;
    private String rpuser = "turfclubie";
    private String rppass = "kelpie";
    private String tcserver = "www.turfclub.ie";
    private String tcuser = "rcpost";
    private String tcpass = "*XML@feed*";
	
    public static void main(String[] args){
    	FTPUtility util = new FTPUtility();
    	util.ftpDownloadFromTurfclubRPDir("turfclub_horselist_RP_TC.xml", "turfclub_horselist_RP_TC.xml");
    }
    
    
	public void ftpUploadToRacingPost(String fileName){
		 FTPClient ftpClient = new FTPClient();
	        try {
	 
	            ftpClient.connect(rpserver, port);
	            ftpClient.login(rpuser, rppass);
	            ftpClient.enterLocalPassiveMode();
	 
	            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	 
	            // APPROACH #1: uploads first file using an InputStream
	            File firstLocalFile = new File(fileName);
	 
	            String firstRemoteFile = fileName;
	            InputStream inputStream = new FileInputStream(firstLocalFile);
	 
	            System.out.println("Start uploading file");
	            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
	            inputStream.close();
	            if (done) {
	                System.out.println("The file is uploaded successfully.");
	            }
	 
	         
	 
	        } catch (IOException ex) {
	            System.out.println("Error: " + ex.getMessage());
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (ftpClient.isConnected()) {
	                    ftpClient.logout();
	                    ftpClient.disconnect();
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	}
	
	public void ftpDownloadFromTurfclubRPDir(String fileName, String saveFileAs){
		
 
		 // get an ftpClient object
		  FTPClient ftpClient = new FTPClient();

		  try {
			  ftpClient.connect(tcserver, port);
			  System.out.println("Connected");
	            ftpClient.login(tcuser, tcpass);
	            ftpClient.enterLocalActiveMode();
	            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	 
	            // APPROACH #1: using retrieveFile(String, OutputStream)
	            String remoteFile1 = fileName;
	            File downloadFile1 = new File(saveFileAs);
	            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
	            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
	            outputStream1.close();
	 
	            if (success) {
	                System.out.println("File #1 has been downloaded successfully.");
	            }
		  
		  
		  }  catch (IOException ex) {
	            System.out.println("Error: " + ex.getMessage());
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (ftpClient.isConnected()) {
	                    ftpClient.logout();
	                    ftpClient.disconnect();
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
		 
}
}