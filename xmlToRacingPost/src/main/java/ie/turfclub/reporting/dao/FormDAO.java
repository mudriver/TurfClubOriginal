package ie.turfclub.reporting.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ie.turfclub.reporting.model.vetreports.VetreportHorseForm;
import ie.turfclub.reporting.model.vetreports.VetreportHorsesNoForm;
import ie.turfclub.reporting.model.vetreports.VetreportMeetingsNotGenerated;
import ie.turfclub.reporting.model.vetreports.VetreportReportsSent;

@Repository
@Transactional
public interface FormDAO {

	public void addForm(VetreportHorseForm form);

	public List<VetreportHorsesNoForm> getHorsesNoForm(String startHorse);
	public void setHorseNoFormChecked (String horse);
	public VetreportHorseForm getHorseForm(String horse, String date, String track);
	public List<VetreportMeetingsNotGenerated> getMeetingsNotGenerated();
	public void setReportSent(VetreportReportsSent reportSent);
	public void deleteAllChecked();
}
