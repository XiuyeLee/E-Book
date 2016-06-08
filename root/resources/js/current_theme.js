$(function() {
	//该el表达式失效
	//PrimeFaces.changeTheme('${sessionScope.theme == null?"swanky-purse":sessionScope.theme}');
	$.ajax({
		type:"post",
		url:"/E-Book/currentTheme.do",//我以前也碰到过相对绝对地址，客户端的绝对地址从域名后的斜线‘/’开始
		dataType:"text",
		success:function(data){
			
			PrimeFaces.changeTheme(data?data:"swanky-purse");
				
			console.log(data);
			
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			PrimeFaces.changeTheme('swanky-purse');
		}
	});
	
});