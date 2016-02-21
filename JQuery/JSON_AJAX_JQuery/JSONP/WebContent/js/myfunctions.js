function sendGet() 
{
	//alert($('#zip').val().length);
	if($('#zip').val().length==5){
		var urlname='http://ziptasticapi.com/' + $('#zip').val() +'?callback=?';
		
		   $.getJSON(urlname,function(data)
			{
			 //console.log(data);
			 $('#Country').val(data.country);
			 $('#state').val(data.state);
			 $('#city').val(data.city);
			});

	}
}