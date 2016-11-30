package ie.turfclub.controller;

import ie.turfclub.model.User;
import ie.turfclub.service.HorseService;
import ie.turfclub.service.HuntService;
import ie.turfclub.service.HunterCertService;







import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

@RequestMapping(value = "/huntApproval")
public class HuntApprovalController {

	static Logger logger = LoggerFactory.getLogger(HuntApprovalController.class);
	// service to get huntercert objects from the database
	@Autowired
	private HunterCertService hunterCertService;
	// service to get hunt objects from the database
	@Autowired
	private HuntService huntService;
	@Autowired
	private HorseService horseService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listOfHunterCertsForApproval(Model model, @RequestParam(value = "ERROR", required = false) String error) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)auth.getPrincipal();
		System.out.println(user.getUser_hunt_id().getHunt_name());
		
		model.addAttribute("hunt", user.getUser_hunt_id().getHunt_name());
		model.addAttribute("huntercerts", hunterCertService.getHunterCertsByHunt(Integer.parseInt( user.getUser_hunt_id().getId())));
		
		
		
		return "huntercert-huntApproval";
	}
	
	
	// Approve Function for HunterCerts
		@RequestMapping(value = "/approve", method = RequestMethod.GET)
		public String approveHunterCert(Model model,
				@RequestParam(value = "horseName", required = true) String name,
				@RequestParam(value = "approve", required = true) String approve) {

			

			if (approve.equals("approveStage")) {
				model.addAttribute("horse_name", name);
				model.addAttribute("approve", "approve");
				return "huntercert-approveCancel";

			}

			else if (approve.equals("rejectStage")) {
				model.addAttribute("horse_name", name);
				model.addAttribute("reject", "reject");
				return "huntercert-approveCancel";

			
			}
			
			
			else if (approve.equals("approve")) {
				
				hunterCertService.approveHunterCertByHunt(Integer.parseInt(horseService.getHorses(name).get(0).getId()));
				return "redirect:/huntApproval/";

			}
			
			else if(approve.equals("reject")){
				hunterCertService.rejectHunterCertByHunt(Integer.parseInt(horseService.getHorses(name).get(0).getId()));
				return "redirect:/huntApproval/";
			}
			else{
				return "redirect:/huntApproval/";
			}
			

		

		}
	
	
}
