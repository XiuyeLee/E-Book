$(function() {
	//该el表达式失效
	//PrimeFaces.changeTheme('${sessionScope.theme == null?"swanky-purse":sessionScope.theme}');
	$.ajax({
		type:"post",
		url:"currentTheme.do",
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