package ie.turfclub.xmlToRacingPost.reportGenerating;

import ie.turfclub.xmlToRacingPost.service.HunterCertService;

public class GenerateXMLReport {

	private HunterCertService service;

	public GenerateXMLReport(HunterCertService service) {
		super();
		this.service = service;
	}
	
	public void getReport(){
		service.getHunterCertsByHunt(17);
	}
	
}
