package ie.turfclub.reporting.dao;

import ie.turfclub.reporting.model.vetreports.VetreportHorseForm;
import ie.turfclub.reporting.model.vetreports.VetreportHorsesNoForm;
import ie.turfclub.reporting.model.vetreports.VetreportHorsesNoFormCheckedToday;
import ie.turfclub.reporting.model.vetreports.VetreportMeetingsNotGenerated;
import ie.turfclub.reporting.model.vetreports.VetreportReportsSent;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class FormDAOImpl implements FormDAO {

	@Autowired
	@Qualifier("vreportsSessionFactory")
	private SessionFactory sessionFactory;
	private int saves = 0;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	private Session getCurrentSession() {
		  return sessionFactory.getCurrentSession();
		 }
	
	
	
	
	@Override
	public void addForm(VetreportHorseForm form) {
		System.out.println("Open Session");
		Session session = getCurrentSession();
		
		

			
	
				VetreportHorseForm exist = getHorseForm(form.getFormHorse(), format.format(form.getFormDate()), form.getFormTrack());
				if(exist == null){
					
					 System.out.println("Save:" + form.getFormHorse() + " " + form.getFormDate() + " " + form.getFormResult() );
					
					try {
		                
						session.save(form);
		            } catch (ConstraintViolationException e) {
		                
		            	System.out.println(e);
		            }
					
					
				   System.out.println("Save Complete");
				}
				else{
					System.out.println("Already Complete: " + form.getFormHorse() + " " + form.getFormDate() + " " + form.getFormResult());
					
				}
				
				
			
            


			


		

	}

	

	@Override
	public List<VetreportHorsesNoForm> getHorsesNoForm(String startHorse) {
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<VetreportHorsesNoForm> list = session.createQuery("from VetreportHorsesNoForm where horseName >'" + startHorse +"'").setMaxResults(30).list();
		
		if(list.isEmpty()){
			return null;
		}

		return list;
	}

	@Override
	public VetreportHorseForm getHorseForm(String horse, String date, String track) {
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<VetreportHorseForm> list = session.createQuery("from VetreportHorseForm v WHERE v.formHorse='" + horse.replaceAll("'", "''") + "' AND v.formDate='" + date + "' AND v.formTrack='" + track + "'").list();
		
		if(list.isEmpty()){
			return null;
		}

		return list.get(0);
	}

	@Override
	public List<VetreportMeetingsNotGenerated> getMeetingsNotGenerated() {
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<VetreportMeetingsNotGenerated> list = session.createQuery("from VetreportMeetingsNotGenerated").list();
		
		if(list.isEmpty()){
			return new ArrayList<>();
		}
	
        
		return list;
	}

	@Override
	public void setReportSent(VetreportReportsSent reportSent) {
		
		Session session = getCurrentSession();
		session.save(reportSent);
		System.out.println("Save Complete");

		System.out.println("Close Session");
		
	}




	@Override
	public void setHorseNoFormChecked(String horse) {
		 VetreportHorsesNoFormCheckedToday horseChecked = new VetreportHorsesNoFormCheckedToday();
		 horseChecked.setCheckedHorse(horse);
		 Session session = getCurrentSession();
		 session.save(horseChecked);
	}




	@Override
	public void deleteAllChecked() {
		String stringQuery = "DELETE FROM VetreportHorsesNoFormCheckedToday";
		org.hibernate.Query query = getCurrentSession().createQuery(stringQuery);
		query.executeUpdate();
		
	}

}
