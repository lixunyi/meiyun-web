$(function() {
	var el = {
		form: $("#product-form"),
		submit: $("#submit")
	};
	
	// 创建主题
	el.submit.click(function() {
		$.post("/product/new", el.form.serialize(), function(data) {
			data = $.parseJSON(data);
			if(data.success) {
				window.location.href = "/"
			} else {
				alert(data.message);
			}
		});
	});
});