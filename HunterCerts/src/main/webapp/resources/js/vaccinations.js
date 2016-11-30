$(document).ready(function() {
	// Datepicker Popups calender to Choose date.
	
	$(function() {
	$(".datepicker").datepicker({maxDate: '+0m +0w +0d', dateFormat :'dd/mm/yy'  });
	// Pass the user selected date format.
	$('.error0').hide();
	$('.error1').hide();
	$('.error2').hide();
	});
	
	
	});

$("#vaccinations2\\.vac_date").blur(function() {
	
	var dtVal=$('#vaccinations2\\.vac_date').val();
	if(dtVal != ""){
		if(ValidateDate(dtVal))
		   {
			   $('.error2').hide();
		   }
		   else{
			   $('.error2').show();
		   }
	}
	else{
		 $('.error2').hide();
	}
	
	
	
   
});

$("#vaccinations1\\.vac_date").blur(function() {
	
	var dtVal=$('#vaccinations1\\.vac_date').val();
	if(dtVal != ""){
		if(ValidateDate(dtVal))
		   {
			   $('.error1').hide();
		   }
		   else{
			   $('.error1').show();
		   }
	}
	else{
		 $('.error1').hide();
	}
	
	
   
});
$("#vaccinations0\\.vac_date").blur(function() {
	
	var dtVal=$('#vaccinations0\\.vac_date').val();
	if(dtVal != ""){
		if(ValidateDate(dtVal))
		   {
			   $('.error0').hide();
		   }
		   else{
			   $('.error0').show();
		   }
	}
	else{
		 $('.error0').hide();
	}
	
	
   
});

$('#formsubmit').click(function(event){
	
	event.preventDefault();
	if($('.error0').is(":visible") || $('.error1').is(":visible") || $('.error2').is(":visible")){
		
	}
	else{
		$('#vaccinationForm').submit();
	}
	
	
});


function ValidateDate(dtValue)
{
var dtRegex = new RegExp(/\b\d{1,2}[\/-]\d{1,2}[\/-]\d{4}\b/);
return dtRegex.test(dtValue);
}