$(document).ready(function(){

	$('.chat_head').click(function(){
		$('.chat_body').slideToggle('slow');
	});
	$('.msg_head').click(function(){
		$('.msg_wrap').slideToggle('slow');
	});
	
	$('.close').click(function(){
		$('.msg_box').hide();
	});
	
	
	$('textarea').keypress(
    function(e){
        if (e.keyCode == 13) {
            e.preventDefault();
            var msg = $(this).val();
			$(this).val('');
			if(msg!='')
			$('<div class="msg_b">'+msg+'</div>').insertBefore('.msg_push');
			$('.msg_body').scrollTop($('.msg_body')[0].scrollHeight);
			
			sendToWatsonConversation(msg);
        }
    });
	
	
	function sendToWatsonConversation(msgData){
		 try
		    {
		        asyncRequest = new XMLHttpRequest();
		        asyncRequest.addEventListener("readystatechange", stateChange, false);
		        asyncRequest.open('GET', '/Farmacia/watson?nome='+msgData, true);    //   /Test is url to Servlet!
		        asyncRequest.send(null);
		    }
		    catch(exception)
		   {
		    alert("Request failed");
		   }
	} 
	
	function stateChange(){
		if(asyncRequest.readyState == 4 && asyncRequest.status == 200){
			var msgResponse = JSON.parse(asyncRequest.responseText).output.text;
			$('<div class="msg_a">'+msgResponse+'</div>').insertBefore('.msg_push');
			$('.msg_body').scrollTop($('.msg_body')[0].scrollHeight);
			
	    }
	}
	
});