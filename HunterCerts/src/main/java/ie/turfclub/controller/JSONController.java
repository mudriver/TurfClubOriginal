package ie.turfclub.controller;

import ie.turfclub.model.HorseWithID;
import ie.turfclub.model.Hunt;
import ie.turfclub.service.HorseService;
import ie.turfclub.service.HuntService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/service")
public class JSONController {
	
 
	@Autowired
	 HorseService horseService;
	@Autowired
	 HuntService huntService;
	   
	
	@RequestMapping(value = "/horses", method = RequestMethod.GET)
	 public @ResponseBody List<HorseWithID> getHorses(@RequestParam("term") String term) {
	  //System.out.println(foo);
	 
		 List<HorseWithID> horses = horseService.getHorses(term);
	  return horses;
	 }
	
	@RequestMapping(value = "/hunts", method = RequestMethod.GET)
	 public @ResponseBody List<Hunt> getHunts(@RequestParam("term") String term) {
	  //System.out.println(foo);
	 
      List<Hunt> hunts = huntService.getHunts(term);
	  return hunts;
	 }
	 
	
	 
	 
	 
}