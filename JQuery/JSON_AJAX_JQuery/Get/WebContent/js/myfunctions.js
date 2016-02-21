function sendGet() 
{
    $.get('jsonservlet', {  title:$('#title').val() ,
    						url : $('#url').val() ,
    						categories : $('#categories').val() ,
    						tags : $('#tags').val() 
    					},function(data)
    					{
    						$('#Text').html(data);	
    					}).error(function()
    							{
    						$('#Text').html("Error Occured");
    					}).complete(function()
    							{
    								$('#comp').html("comp Occured");
    							}).success(function()
    							{
    								$('#success').html("success Occured");
    							});
    
    
}