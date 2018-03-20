$(function() {
	$("#username").blur(function() {
		var username = $("#username").val();
		if (username == "") {
			$("#usernamerror").html("请输入用户名");
		} else {
			$("#usernamerror").html("");
		}
		$.getJSON("ajax/getUsername.action",{id:username},function(myJSON){
			 var v = myJSON[0].value;
			 if(v =='false'){
				 $("#usernamerror").html("用户名已存在");
			 }else{
				 $("#usernamerror").html("用户名可以注册");
			 }
  			
		});
	});
});
$(function() {
	$("#password").blur(function() {
		var password = $("#password").val();
		if (password == "") {
			$("#passworderror").html("请输入密码");
		} else {
			$("#passworderror").html("");
		}
	});
});
$(function() {
	$("#repassword").blur(function() {
		var repassword = $("#repassword").val();
		var password = $("#password").val();
		if (repassword == "") {
			$("#repassworderror").html("请输入校验密码");
		} else if (repassword != password) {
			$("#repassworderror").html("密码校验失败");
		} else {
			$("#repassworderror").html("");
		}
	});
});
$(function() {
	$("#realname").blur(function() {
		var realname = $("#realname").val();
		if (realname == "") {
			$("#realnamerror").html("请输入姓名");
		} else {
			$("#realnamerror").html("");
		}
	});
});
$(function() {
	$("#birthday").change(function() {
		var birthday = $("#birthday").val();
		$("#birthdayerror").html("");
	});
});
$(function() {
	$("#contact").blur(function() {
		var contact = $("#contact").val();
		if (contact == "") {
			$("#contacterror").html("请输入联系方式");
		} else {
			$("#contacterror").html("");
		}
	});
});

$(function() {
	$("#btn").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		var repassword = $("#repassword").val();
		var realname = $("#realname").val();
		var birthday = $("#birthday").val();
		var contact = $("#contact").val();
		var flag = false;
		if (username == "") {
			$("#usernamerror").html("请输入用户名");
			flag = false;
		} else {
			$("#usernamerror").html("");
			flag = true;
		}
		if (password == "") {
			$("#passworderror").html("请输入密码");
			flag = false;
		} else {
			$("#passworderror").html("");
			flag = true;
		}
		if (repassword == "") {
			$("#repassworderror").html("请输入校验密码");
			flag = false;
		} else if (repassword != password) {
			$("#repassworderror").html("密码校验失败");
			flag = false;
		} else {
			$("#repassworderror").html("");
			flag = true;
		}
		if (realname == "") {
			$("#realnamerror").html("请输入姓名");
			flag = false;
		} else {
			$("#realnamerror").html("");
			flag = true;
		}
		if (birthday == "") {
			$("#birthdayerror").html("请选择出生日期");
			flag = false;
		} else {
			$("#birthdayerror").html("");
			flag = true;
		}
		if (contact == "") {
			$("#contacterror").html("请输入联系方式");
			flag = false;
		} else {
			$("#contacterror").html("");
			flag = true;
		}
		$.getJSON("ajax/getUsername.action",{id:username},function(myJSON){
			 var v = myJSON[0].value;
			 if(v =='false'){
				 $("#usernamerror").html("用户名已存在");
				 flag = false;
			 }else{
				 flag = true;
			 }
		});
		if(flag){
			$("#myform").submit()
		}
	});
});
