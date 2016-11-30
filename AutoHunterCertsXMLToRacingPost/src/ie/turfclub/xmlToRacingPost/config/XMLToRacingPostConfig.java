package ie.turfclub.xmlToRacingPost.config;

import ie.turfclub.xmlToRacingPost.reportGenerating.GenerateXMLReport;
import ie.turfclub.xmlToRacingPost.service.HunterCertService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"ie.turfclub.XMLToRacingPost"})
public class XMLToRacingPostConfig {

	@Autowired
	private HunterCertService service;
	
	@Bean 
	   public GenerateXMLReport reportGenerating(){
	      
		return new GenerateXMLReport(service);
	   }
	
}
