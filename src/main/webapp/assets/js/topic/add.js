$(function() {
	var el = {
		form: $("#topic-form"),
		submit: $("#submit")
	};
	
	// 创建主题
	el.submit.click(function() {
		$.post("/topic/new", el.form.serialize(), function(data) {
			data = $.parseJSON(data);
			if(data.success) {
				window.location.href = "/topic"
			} else {
				alert(data.message);
			}
		});
	});
});