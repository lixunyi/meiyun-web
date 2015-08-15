$(function() {
	var el = {
		form: $("#label-form"),
		submit: $("#submit")
	};
	
	// 创建主题
	el.submit.click(function() {
		$.post("/label/new", el.form.serialize(), function(data) {
			console.log(data);
		});
	});
});