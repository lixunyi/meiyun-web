$(function() {
	var el = {
		form: $("#register-form"),
		submit: $("#submit"),
		alert: $("#alert")
	};
	
	// 注册
	el.submit.click(function() {
		
		console.log(el.form.serialize());
		
		$.post("/user/register", el.form.serialize(), function(data) {
			var result = $.parseJSON(data);
			el.alert.text(result.message);
			if (result.success) {
				window.location.href = "/";
			} 
		});
	});
});