$(function() {
	$("table.tab .num").blur(function() {
		var cartid = $(this).closest("tr").find(".cartid").val();
		var userid = $(this).closest("tr").find(".userid").val();
		var num = $(this).val();
		var str = num + "," + userid + "," + cartid;
		$.getJSON("ajax/getCart.action",{id:str},function(myJSON){
			//window.location.reload();
			$(location).attr('href', 'index/cart.action');
		});
	});
});