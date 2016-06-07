function loginOut(){
	$.ajax({
		type:"post",
		url:"loginOut.do",
	});
	return true;
}
$(
		function(){
			$(".loginOut").bind("click",loginOut);
		}
);

