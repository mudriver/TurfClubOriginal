package ie.turfclub.reporting.service;

import ie.turfclub.reporting.model.vetreports.VetreportHorseForm;
import ie.turfclub.reporting.model.vetreports.VetreportHorsesNoForm;
import ie.turfclub.reporting.model.vetreports.VetreportMeetingsNotGenerated;
import ie.turfclub.reporting.model.vetreports.VetreportReportsSent;

import java.util.List;

public interface FormService {

	public void addForm(VetreportHorseForm newForm);;
	public List<VetreportHorsesNoForm> getHorsesNoForm(String startHorse);
    public List<VetreportMeetingsNotGenerated> getMeetingsNotGenerated();
	public void setReportSent(VetreportReportsSent reportSent);
	public void setHorseNoFormChecked(String horse);
	public void deleteAllChecked();
}

