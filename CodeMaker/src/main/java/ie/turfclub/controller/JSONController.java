package ie.turfclub.controller;


import ie.turfclub.service.DatabaseService;

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
	DatabaseService dbService;
	
	   
	@RequestMapping(value = "/tables", method = RequestMethod.GET)
	 public @ResponseBody List<String> getMeetings(@RequestParam("database") String db) {
	  //System.out.println(foo);
	 
		
	  List<String> tables = dbService.getTableNames("vetreports");
	  if(tables.isEmpty()){
		  System.out.println("NULL");
	  }else{
		  for(String table : tables){
			  System.out.println(tables);
		  }
	  }
	  
	  return tables;
	 }
	
	
	
	
	
	
	
	 
	 
	 
}