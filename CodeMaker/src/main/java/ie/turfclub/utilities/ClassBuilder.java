package ie.turfclub.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.commons.io.FileUtils;


public class ClassBuilder {

	private StringTemplate template;
	
	public void buildModel(){
		
	}
	
	public void buildDAO(){
		
	}
	
	public void buildService(){
		
	}
	
	public void buildTests(){
		
	}
	
	public void buildConfig(ConfigBuilder configBuild){
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException{
		ClassBuilder builder = new ClassBuilder();
	
		DatabaseReader reader = new DatabaseReader("", "", "");
		reader.connectToDB();
		
		File f = new File("resources/resources/model.st");
		 
		  if(f.exists()){
			  System.out.println("File existed");
		  }else{
			  System.out.println("File not found!");
		  }
		StringTemplateGroup templateG = new StringTemplateGroup("templates", "resources/resources/");
        StringTemplate template = templateG.getInstanceOf("model");

        template.setAttribute("className", "VetReportTable");
        template.setAttribute("variable", "int id");
        template.setAttribute("variable", "String name");
        //StringTemplate query = new StringTemplate("SELECT $column; separator=\",\n\"$ FROM $table$;");
        //query.setAttribute("column", "name");
        //query.setAttribute("column", "email");
        //query.setAttribute("table", "User");
		System.out.println(template.toString());
		
	}
	
	
	private void writeClassFile(String fileName, String fileContent){
		
		File file = new File(fileName);
		try {
			FileUtils.writeStringToFile(file, fileContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
