
$(function() {
	
    $('#huntSelect').select2({
        minimumInputLength: 3,
 
        placeholder: 'Enter Hunt Name',
        
        
        ajax: {
            url: "/huntercerts/service/hunts",
            dataType: 'json',
            type: "GET",
          
            quietMillis: 100,
            data: function(term, page) {
            	 
            	//alert('h' + term);
            	return {
                    term: term
                };
            },
            results: function(data, page ) {
            	//alert("Selected data is: "+JSON.stringify(data));
            	var dataReturn = [];
            	$.each( data, function( key, value ) {
            		  dataReturn.push( {id:data[key].id ,text: data[key].hunt_name} );
            		});
            	
            	return { results: dataReturn };
            }
        },
    initSelection: function(element, callback) {
    	
    	
    	callback({id: $(element).val(), text:  $('#huntName').val() });
    	
    }
      
    }).on("select2-close", function() {
    	var data = $('#horseSelect').select2('data');
    	//alert(data.text);
    	$('#huntName').val(data.text);
    	//submit the form for validation by spring when horse selected
    	//alert("selecting val=" + e.val + " choice=" + e.object.text);
    	//alert($('#horseSelect').val());
    	
    	
    	//$("#horseDetails").load("http://localhost:8080/huntercerts/hunterCert/hunt");
    	});
});











//document.ready(myFunction);



//myFunction();


