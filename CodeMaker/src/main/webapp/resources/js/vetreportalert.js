$(document).ready(function() {
	$('#formSubmit').click(function(event) {

		event.preventDefault();
		//console.log($('#horseSel').val());
		$('#vetReportAlertForm').submit();
		

	});

	$('#reportTypeSel').change(function() {
		console.log("type change");
		if($('#reportTypeSel').val() == "Trainer"){
			console.log("show ");
			$('#trainerSelector').show();
			$('#horseSelector').hide();
		}
		if($('#reportTypeSel').val() == "Horse"){
			console.log("show horse");
			$('#trainerSelector').hide();
			$('#horseSelector').show();
		}
	});

	console.log("hiding");
	$('#horseSelError').hide();
	$('#trainerSelError').hide();
	$('#trainerSelector').hide();
	$('#horseSelector').hide();
	
	
	$(function() {
		console.log("select 2 horse selector");
	    $('#horseSel').select2({
	        minimumInputLength: 3,
	 
	        placeholder: 'Enter Horse Name',
	        
	        
	        ajax: {
	            url: "/vetReports/service/horsesAll",
	            dataType: 'json',
	            type: "GET",
	          
	            quietMillis: 100,
	            data: function(term, page) {
	            	 
	            	//alert('h' + term);
	            	return {
	                    chars: term
	                };
	            },
	            results: function(data, page ) {
	            	//alert("Selected data is: "+JSON.stringify(data));
	            	var dataReturn = [];
	            	$.each( data, function( key, value ) {
	            		  dataReturn.push( {id:data[key][1] ,text: data[key][0]} );
	            		});
	            	
	            	return { results: dataReturn };
	            }
	        },
	    
	      
	    });
	    
	    
	   
	    	
	    	/*.on("change", function(e) {
	            // mostly used event, fired to the original element when the value changes
	    		$('#horseForm').submit();
	          });*/
	});
	
	 $(function() {
			console.log("select 2 horse selector");
		    $('#trainerSel').select2({
		        minimumInputLength: 3,
		 
		        placeholder: 'Enter Horse Name',
		        
		        
		        ajax: {
		            url: "/vetReports/service/trainersAll",
		            dataType: 'json',
		            type: "GET",
		          
		            quietMillis: 100,
		            data: function(term, page) {
		            	 
		            	//alert('h' + term);
		            	return {
		                    chars: term
		                };
		            },
		            results: function(data, page ) {
		            	//alert("Selected data is: "+JSON.stringify(data));
		            	var dataReturn = [];
		            	$.each( data, function( key, value ) {
		            		  dataReturn.push( {id:data[key][1] ,text: data[key][0]} );
		            		});
		            	
		            	return { results: dataReturn };
		            }
		        },
		    
		      
		    });
	
	 });
	
});