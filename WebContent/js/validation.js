$(function() {
	$("#formregister").validate({
		rules : {
			firstName : {
				required : true,
				lettersonly: true,
				minlength: 4,
				maxlength: 15
			},
			lastName : {
				required : true,
				minlength: 4,
				maxlength: 15,
				lettersonly: true
			},
			phoneNumber : {
				required : true,
				digits: true,
				minlength: 6, 
				maxlength: 12
			},
			address: {
				required: true,
				minlength: 4,
				maxlength: 25
			},
			email : {
				required : true,
				email : true
			},
			dateOfBirth: {
				required:true
			}
		}
	});
});