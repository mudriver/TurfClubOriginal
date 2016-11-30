package ie.turfclub.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.stringtemplate.StringTemplate;

public class FileBuilder {

	private File file;
	private FileWriter fw;
	private BufferedWriter bw = new BufferedWriter(fw);
	private StringTemplate stringTemplate;
	
	public FileBuilder(String filePathName) throws IOException{
		file = new File(filePathName);
		fw = new FileWriter(file.getAbsoluteFile());
	}
	
	public void writeToFile (String content) {
		try {
 
			
 
			
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			System.out.println("Done writing");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeFile () {
		try {
 
			bw.close();
 
			System.out.println("Closing File");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
