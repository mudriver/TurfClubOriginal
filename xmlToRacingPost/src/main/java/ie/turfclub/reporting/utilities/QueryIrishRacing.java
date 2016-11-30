package ie.turfclub.reporting.utilities;

import ie.turfclub.reporting.model.vetreports.VetreportHorseForm;
import ie.turfclub.reporting.model.vetreports.VetreportHorsesNoForm;
import ie.turfclub.reporting.service.FormService;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

public class QueryIrishRacing {

	@Autowired
	FormService formService;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyy");
	private SimpleDateFormat lastRunDateFormat = new SimpleDateFormat(
			"ddMMMyyyy");
	private List<VetreportHorseForm> newForm = new ArrayList<>();

	public static void main(String[] args) {
		QueryIrishRacing irishRacing = new QueryIrishRacing();
		SimpleDateFormat lastRunDateFormat = new SimpleDateFormat(
				"ddMMMyyyy");
		Date date = null;
		try {
			date = lastRunDateFormat.parse("24th Oct 2014".replaceAll(" ", "").replaceAll("th", "").replaceAll("st", "").replaceAll("nd", "").replaceAll("rd", ""));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date);
		
	}

	public void updateFormFile() throws ParseException, IOException {
		
		formService.deleteAllChecked();
		int stop = 0;
		String startHorse = "";
		while(stop == 0){
		System.out.println("load more horses");
			List<VetreportHorsesNoForm> horses = formService.getHorsesNoForm(startHorse);
			
		if(horses == null){
			stop = 1;
			break;
		}
		else{
			newForm = new ArrayList<>();
		}
		String message = "RUN AGAIN FOR HORSEs";
		
		for (VetreportHorsesNoForm horse : horses) {

			System.out.println("Start horse:" + horse.getHorseName());
			try {
				// String hName = horse.getHorseName().replaceAll(" ",
				// "+").replaceAll("[(]", "%28").replaceAll("[)]",
				// "%29").replaceAll("[']", "%27");
				// System.out.println(hName);

					getSearchResults(horse);
				
				System.out.println("Done horse:" + horse.getHorseName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			formService.setHorseNoFormChecked(horse.getHorseName());

		}
		
		updateFormForHorses(newForm);


		}
		System.out.println("Complete");
	}

	public void getSearchResults(VetreportHorsesNoForm horse)
			throws IOException {
		String hName = horse.getHorseName().replaceAll(" ", "+")
				.replaceAll("[(]", "%28").replaceAll("[)]", "%29")
				.replaceAll("[']", "%27");

		Document searchdoc = Jsoup
				.connect(
						"http://www.irishracing.com/search?prs=" + hName
								+ "&prw=horse").get();

		 for (int i = 1; i <= 5; i++) {
		      try{
		    	  searchdoc = Jsoup
		  				.connect(
		  						"http://www.irishracing.com/search?prs=" + hName
		  								+ "&prw=horse").timeout(5000).get();
		          break; // Break immediately if successful
		      }
		      catch (SocketTimeoutException e){
		          // Swallow exception and try again
		          System.err.println("jsoup Timeout occurred " + i + " time(s)");
		      }                 
		  }
		
		Elements lists = searchdoc.getElementById("content").getElementsByTag(
				"ul");
		for (Element list : lists) {
			Elements moreThanOneHorse = list.getElementsByTag("li");
			// writer.write(hName + " " + moreThanOneHorse.size());
			if (moreThanOneHorse.size() == 1) {
				for (Element listItem : list.getElementsByTag("a")) {

					String href = "http://www.irishracing.com/"
							+ listItem.attr("href");

					//System.out.println("SINGLE " + href);
					 
						getFormTable(href, horse);
					
				}
			} else {
				ArrayList<FormSearchHorses> searchHorses = new ArrayList<>();
				//System.out.println("DUPLICATE HORSE ERROR");
				for (Element item : moreThanOneHorse) {
					//System.out.println(item.text() + " -- " + horse.getHorseName());
					if (item.text().contains(horse.getHorseName() + " (IRE)")
							) {
						for (Element listItem : item.getElementsByTag("a")) {

							//System.out.println(listItem.text());
							String href = "http://www.irishracing.com/"
									+ listItem.attr("href");

							FormSearchHorses searchHorse = new FormSearchHorses();
							searchHorse.setHorseFormURL(href);
							searchHorse.setName(hName);
							Date lastRun = null;
							String dateText = item.text()
							.substring(
									item.text()
											.lastIndexOf("Last ran ")
											+ "Last ran ".length()).replaceAll(" ", "").replaceAll("th", "").replaceAll("st", "").replaceAll("nd", "").replaceAll("rd", "");
							
							try {
								lastRun = lastRunDateFormat.parse(dateText);
							} catch (ParseException e) {
								
								System.out.println("DATE PARSE ERROR");
								try {
									lastRun = lastRunDateFormat.parse("01Jan" + item.text().lastIndexOf(" "));
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
							}
							searchHorse.setLastRun(lastRun);
searchHorses.add(searchHorse);
						}
					}
					else if (item.text().contains(horse.getHorseName() + " (GB)")
							) {
						for (Element listItem : item.getElementsByTag("a")) {

							//System.out.println(listItem.text());
							String href = "http://www.irishracing.com/"
									+ listItem.attr("href");

							FormSearchHorses searchHorse = new FormSearchHorses();
							searchHorse.setHorseFormURL(href);
							searchHorse.setName(hName);
							Date lastRun = null;
							String dateText = item.text()
							.substring(
									item.text()
											.lastIndexOf("Last ran ")
											+ "Last ran ".length()).replaceAll(" ", "").replaceAll("th", "").replaceAll("st", "").replaceAll("nd", "").replaceAll("rd", "");
							
							try {
								lastRun = lastRunDateFormat.parse(dateText);
							} catch (ParseException e) {
								
								System.out.println("DATE PARSE ERROR");
								try {
									lastRun = lastRunDateFormat.parse("01Jan" + item.text().lastIndexOf(" "));
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
							}
							searchHorse.setLastRun(lastRun);
						    searchHorses.add(searchHorse);
						}
					}
					
					
					

				}
				if(searchHorses.size() == 1){
					getFormTable(searchHorses.get(0).horseFormURL, horse);
				}
				else if(searchHorses.size() > 1){
					//System.out.println("HORSES WITH DUPLICATES");
					Collections.sort(searchHorses);
					for(FormSearchHorses h : searchHorses){
						
						
						//System.out.println( h.getHorseFormURL() + " " + h.getLastRun());
					}
					getFormTable(searchHorses.get(searchHorses.size()-1).horseFormURL, horse);
				}
				else{
					System.out.println("check other duplicates here!!!");
				}
				
				
			}

		}
	}

	public void getFormTable(String link, VetreportHorsesNoForm horseToUpdate)
			throws IOException {
		
		
		Document results = null; 
		 for (int i = 1; i <= 5; i++) {
		      try{
		    	  System.out.print("Getting Horse Results:");
		    	  results = Jsoup.connect(link).timeout(5000).get();
		          break; // Break immediately if successful
		      }
		      catch (SocketTimeoutException e){
		          // Swallow exception and try again
		          System.err.println("jsoup Timeout occurred " + i + " time(s)");
		      }                 
		  }
		Elements tableRows = results.getElementById("formlines")
				.getElementsByTag("tr");
		
		for (Element tableRow : tableRows) {
			if (tableRow.getElementsByTag("th").size() == 0) {

				int count = 0;
				
				VetreportHorseForm horseForm = new VetreportHorseForm();
				horseForm.setFormHorse(horseToUpdate.getHorseName());
				horseForm.setFormRcId(horseToUpdate.getRowId());
				for (Element tableCell : tableRow.getElementsByTag("td")) {
					// System.out.println("CELL");
					//System.out.println(tableCell.text());

					switch (count) {
					case 0:

						try {

							horseForm.setFormDate(dateFormat.parse(tableCell.text()
									.trim()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						
						break;
					case 1:
							horseForm.setFormTrack(tableCell.text()
									.trim());
						break;
					case 3:
						// System.out.println("Conditions " +
						// tableCell.text().trim());
						horseForm.setFormConditions(tableCell.text().trim());
						break;
					case 4:
						// System.out.println("Race " +
						// tableCell.text().trim());
						horseForm.setFormRace(tableCell.text().trim());
						break;
					case 5:
						// System.out.println("Form " +
						// tableCell.text().trim());
						horseForm.setFormResult(tableCell.text().trim());
						break;
					}

					count++;

				}
				//horseForm.setFormRcId(horseToUpdate.getRowId());
				newForm.add(horseForm);
				
				
			}

		}
	}

	
	public boolean checkIfHorseHasForm(VetreportHorseForm horseForm, List<VetreportHorseForm> existingHorseForm){
		
		System.out.println("Check Exists");
		if(existingHorseForm == null){
			System.out.println("Check Exists False");
			return false;
		}
		for(VetreportHorseForm existform :existingHorseForm){
			if(horseForm.getFormDate().equals(existform.getFormDate()) && horseForm.getFormHorse().equals(existform.getFormHorse())){
				System.out.println("Check Exists TRUE");
				return true;
			}
		}
		System.out.println("Check Exists False1");
		return false;
	}
	
	public String updateFormForHorses(List<VetreportHorseForm> horseForm) {
		String lastHorse = "";
		for(VetreportHorseForm newForm : horseForm){
			formService.addForm(newForm);
			lastHorse = newForm.getFormHorse();
		}
		return lastHorse;
		
		
	}

	private class FormSearchHorses implements Comparable<FormSearchHorses> {
		private String Name;
		private Date LastRun;
		private String horseFormURL;

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public Date getLastRun() {
			return LastRun;
		}

		public void setLastRun(Date lastRun) {
			LastRun = lastRun;
		}

		public String getHorseFormURL() {
			return horseFormURL;
		}

		public void setHorseFormURL(String horseFormURL) {
			this.horseFormURL = horseFormURL;
		}

		@Override
		public int compareTo(FormSearchHorses horse) {
			
			return this.getLastRun().compareTo(horse.getLastRun());
		}

	}

}
