$(document).ready(function() {
	$("#loginForm").validate({
		rules : {
			username : {
				required : true,
				minlength : 4,
				maxlength : 10

			}

		}

	});
	$('input').keyup(function() {
		var username = $('#username').val();
		$.ajax({
			url : "LoginServlet",
			method : "GET",
			data : {
				username : username
			}
		}).done(function(response) {
			$("#usernameMessage").html(response);
		});

	});

});