$(function() {
	var el = {
		form: $("#login-form"),
		submit: $("#submit"),
		alert: $("#alert")
	};
	
	// 登录
	el.submit.click(function() {
		var $btn = $(this).button('loading')
		$.post("/user/login", el.form.serialize(), function(data) {
			var result = $.parseJSON(data);
			
			if (result.success) {
				el.submit.text("登录成功！");
				window.location.href = "/";
			} else { // 登录失败
				el.alert.find("strong").text(result.message);
				$btn.button('reset');
			}
		});
	});
});