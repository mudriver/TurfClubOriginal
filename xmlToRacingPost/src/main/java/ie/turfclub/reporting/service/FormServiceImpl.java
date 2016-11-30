package ie.turfclub.reporting.service;

import ie.turfclub.reporting.dao.FormDAO;
import ie.turfclub.reporting.model.vetreports.VetreportHorseForm;
import ie.turfclub.reporting.model.vetreports.VetreportHorsesNoForm;
import ie.turfclub.reporting.model.vetreports.VetreportMeetingsNotGenerated;
import ie.turfclub.reporting.model.vetreports.VetreportReportsSent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional("vreports")
public class FormServiceImpl implements FormService {

	@Autowired
	private FormDAO formDAO;
	
	@Override
	public void addForm(VetreportHorseForm form) {
		//System.out.println(form.getFormHorse());
		formDAO.addForm(form);

	}


	@Override
	public List<VetreportHorsesNoForm> getHorsesNoForm(String startHorse) {
		return formDAO.getHorsesNoForm(startHorse);
	}



	@Override
	public List<VetreportMeetingsNotGenerated> getMeetingsNotGenerated() {
		return formDAO.getMeetingsNotGenerated();
	}

	@Override
	public void setReportSent(VetreportReportsSent reportSent) {
		formDAO.setReportSent(reportSent);
		
	}

	public void setHorseNoFormChecked(String horse){
		
		formDAO.setHorseNoFormChecked(horse);
	}


	@Override
	public void deleteAllChecked() {
		formDAO.deleteAllChecked();
		
	}
	
}
