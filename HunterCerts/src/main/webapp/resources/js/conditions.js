$(document).ready(function() {
      $('#agreeConditions').click(function(event){
        var isChecked = $('#agree').is(':checked');
        var yes = $('#yes').is(':checked');
        var no = $('#no').is(':checked');
        event.preventDefault();
        
        if(yes || no){
        	if(isChecked){
            	$('#conditionsForm').submit();
            }
              
            else
             alert('You must agree to the terms and conditions!');
          }  
      else{
    	  alert('You must click YES or NO - Horse has ran outside Ireland');
      }}
        
        );
      
      $('#yes').click(function(event){
          var yes = $('#yes').is(':checked');
          var no = $('#no').is(':checked');
         
          
          if( no && yes){
          	
              	$('#no').prop('checked', false); 
              
                
           
    }}
          
          );
      
      $('#no').click(function(event){
          var yes = $('#yes').is(':checked');
          var no = $('#no').is(':checked');
         
          
          if( no && yes){
          	
              	$('#yes').prop('checked', false); 
              
                
           
    }}
          
          );
    });