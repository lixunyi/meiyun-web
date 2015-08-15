$(function() {
	var el = {
		form: $("#login-form"),
		submit: $("#submit"),
		alert: $("#alert")
	};
	
	// 登录
	el.submit.click(function() {
		console.log(el.form.serialize());
		$.post("/user/login", el.form.serialize(), function(data) {
			var result = $.parseJSON(data);
			el.alert.text(result.message);
			if (result.success) {
				window.location.href = "/";
			} 
		})
	});
});