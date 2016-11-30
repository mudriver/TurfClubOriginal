package ie.turfclub.reporting.utilities;



import ie.turfclub.reporting.model.pointToPoint.HunterCert;
import ie.turfclub.reporting.service.FixturesService;
import ie.turfclub.reporting.service.HunterCertService;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtility {

@Autowired
private HunterCertService huntercertService;
@Autowired 
private FixturesService fixtureService;
@Autowired
FTPUtility ftpUtil;

	

public static void main(String argv[]) {
	 
  
  }

	
	public String buildXMLFileForRacingPost(String fileName) throws TransformerException, ParserConfigurationException{
		
		
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root element
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Turfclub");
		rootElement.setAttribute("type", "Runner List");
		
		
		doc.appendChild(rootElement);

		List<HunterCert>certs = huntercertService.getUnprocessedHunterCerts();
		for(HunterCert cert : certs){
			//horse elements
			 int yob = cert.getHcertYob(); 
			Element horse = doc.createElement("Horse");
			horse.setAttribute("name", cert.getHcertHorseName());
			horse.setAttribute("country", "IRE");
			horse.setAttribute("year_of_birth", String.valueOf(yob));
			rootElement.appendChild(horse);
		}
		

		


		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(fileName));

		// Output to console for testing
		 //StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		ftpUtil.ftpUploadToRacingPost(fileName);
		return fileName;
	}
	
	public void importXMLFromRacingPost(String fileName) throws ParseException{
		  
		
		//setup the maximum dates that an application must comply with
		int seasonStartYear = fixtureService.getAutumnSeasonStartYear();
	
		SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
		//Date autumnDate = fixtureService.getLastAutumnFixture(seasonStartYear);

		//Set up the maximum 
		Date maxSpringRunDate = sqlFormat.parse(seasonStartYear + "-09-01");
		Date maxAutumnRunDate = sqlFormat.parse(seasonStartYear + "-11-01");
		LocalDate maxSpringRunDT = new LocalDate(maxSpringRunDate);
		LocalDate maxAutumnRunDT = new LocalDate(maxAutumnRunDate);
		Date maxLastWin = sqlFormat.parse(seasonStartYear + "-03-01");
		LocalDate maxLastWinDT = new LocalDate(maxLastWin);
		try {
			  
				SimpleDateFormat standardformat = new SimpleDateFormat("dd/MM/yyyy");
				ftpUtil.ftpDownloadFromTurfclubRPDir(fileName, fileName);
			  	File fXmlFile = new File(fileName);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
			 
				//optional, but recommended
				//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
				doc.getDocumentElement().normalize();
			 
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			 
				NodeList nList = doc.getElementsByTagName("Horse");
			 
				System.out.println("----------------------------");
			 
				
				int autumnYear = fixtureService.getAutumnSeasonStartYear();
				Date autumnEndDate = fixtureService.getLastAutumnFixture(autumnYear);
				Date springEndDate = fixtureService.getLastSpringFixture();
				
				LocalDate autumnEndDT = new LocalDate(autumnEndDate);
				LocalDate springEndDT = new LocalDate(springEndDate);
				
				
				for (int temp = 0; temp < nList.getLength(); temp++) {
			 
					Node nNode = nList.item(temp);
			 
					System.out.println("\nCurrent Element :" + nNode.getNodeName());
			 
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			 
						Element eElement = (Element) nNode;
			 
						String lastWinDate = eElement.getAttribute("last_win_date");
						System.out.println(lastWinDate);
						String lastRunDate = eElement.getAttribute("last_run_date");
						System.out.println(lastWinDate);
						Date lastWin;
						Date lastRun;
						if(!lastWinDate.isEmpty()){
							lastWin = standardformat.parse(lastWinDate);
						}
						else{
							lastWin = null;
						}
						if(!lastRunDate.isEmpty()){
							lastRun = standardformat.parse(lastRunDate);
						}
						else{
							lastRun = null;
						}
						
						
						String horseName = eElement.getAttribute("name");
						System.out.println("Horse:" + horseName);
						checkLastWinLastRun(horseName, lastWin, lastRun, autumnEndDT, springEndDT, maxAutumnRunDT, maxSpringRunDT, maxLastWinDT );
					
						//huntercertService.updateHunterCertWinsRunsAndValidate(horseName, lastWin, lastRun, false);
						
						//System.out.println("First Name : " + eElement.getElementsByTagName("year_of_birth").item(0).getTextContent());
						//System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
						//System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
						//System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
			 
					}
				}
			    } catch (Exception e) {
				e.printStackTrace();
			    }
	}
	
	private void checkLastWinLastRun(String horseName, Date lastWin, Date lastRun, LocalDate autumnEndDT, LocalDate springEndDT, LocalDate maxAutumnLastRun, LocalDate maxSpringLastRun ,LocalDate maxLastWin ){
		

	
	    LocalDate dateOfApplication = new LocalDate();
	    //the day before the day this function processes the application will be the date the huntercert was applied for.
	    dateOfApplication = dateOfApplication.minusDays(1);
		//the last day to apply for a huntercert is twelve days before the last season fixture if its a sunday fixture
	    int daysToGoBack = 12;
		//if the last season fixture is any other day of the week the following modifies the days to go back accordingly
	    int dayOfWeekLastFixture = autumnEndDT.getDayOfWeek();
		System.out.println(dayOfWeekLastFixture);
		switch (dayOfWeekLastFixture) {
        case 1:  daysToGoBack+=1;
                 break;
        case 2:  daysToGoBack+=2;
                 break;
        case 3:  daysToGoBack+=3;
                 break;
        case 4:  daysToGoBack-=3;
                 break;
        case 5:  daysToGoBack-=2;
                 break;
        case 6:  daysToGoBack-=1;
                 break;
        default: 
                 break;
    }
		//sets the last date possible to apply for a huntercert for the autumn season
		LocalDate lastAutumnHCertDate = autumnEndDT.minusDays(daysToGoBack);
		//sets the last date possible to apply for a huntercert for the spring season
		LocalDate lastSpringHCertDate = springEndDT.minusDays(daysToGoBack);
		//checks if the huntercert has been applied for in time for the autumn season
		boolean autumnRejected = false;
		boolean springRejected = false;
		
		LocalDate lastWinDt = new LocalDate(lastWin);
		
		
		if(lastRun != null){
			LocalDate lastRunDt = new LocalDate(lastRun);
		
		if(!dateOfApplication.isAfter(lastAutumnHCertDate)){
			//checks if the horses last run date allows them to run in the autumn season
			if(!lastRunDt.isBefore(maxAutumnLastRun)){
				autumnRejected = true;
			}
			
		}
		//checks if the huntercert has been applied for in time for the autumn season
		if(!dateOfApplication.isAfter(lastSpringHCertDate)){
			//checks if the horses last run date allows them to run in the spring season
			if(!lastRunDt.isBefore(maxSpringLastRun)){
				springRejected = true;
			}
			
		}
		}
		if(lastWin != null){
		//check that the last win date is ok otherwise reject for autumn and spring
		if(lastWinDt.isAfter(maxLastWin)){
			springRejected = true;
			autumnRejected = true;
		}
		}
		System.out.println(horseName);
		huntercertService.updateHunterCertWinsRunsAndValidate(horseName, lastWin, lastRun, autumnRejected, springRejected);
	
		
	}
	

	
}
