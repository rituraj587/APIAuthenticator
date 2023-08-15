<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
<link rel="stylesheet" href="/css/style.css">
<title>${Task}Customer</title>
</head>

<%   
	String cmd = (String)request.getAttribute("cmd");
	String uuid = (String)request.getAttribute("uuid");
	 
	String finalCommand;
	String finalUuid;
	
	if(cmd.equals("update")){
		finalCommand = cmd;
		finalUuid =uuid;
	}
	else{
		finalCommand = cmd;
		finalUuid =uuid;
	}
	 
%>



<body>
	<div class="container">
		<div class="row justify-content-center align-items-center"
			style="min-height: 100vh;">
			<div class="col-lg-10">
				<div class="border border-2 rounded-3 p-lg-5 p-4 my-4 shadow-lg">
					<h3 class="mb-4 fs-3 text-center fw-bold">${Task}Customer</h3>

					<form action="/customer" method="post">
						<div class="row justify-content-center">
							<div class="col-md-6 col-sm-10">
								<input type="text" placeholder="First Name" name="first_name"
									class="form-control mb-3 shadow-none rounded-3 p-2 fs-5 border-2 border"
									required>
							</div>
							<div class="col-md-6 col-sm-10">
								<input type="text" placeholder="Last Name" name="last_name"
									class="form-control mb-3 shadow-none rounded-3 p-2 fs-5 border-2 border"
									required>
							</div>
							<div class="col-md-6 col-sm-10">
								<input type="text" placeholder="Street" name="street"
									class="form-control mb-3 shadow-none rounded-3 p-2 fs-5 border-2 border">
							</div>
							<div class="col-md-6 col-sm-10">
								<input type="text" placeholder="Address" name="address"
									class="form-control mb-3 shadow-none rounded-3 p-2 fs-5 border-2 border">
							</div>
							<div class="col-md-6 col-sm-10">
								<input type="text" placeholder="City" name="city"
									class="form-control mb-3 shadow-none rounded-3 p-2 fs-5 border-2 border">
							</div>
							<div class="col-md-6 col-sm-10">
								<input type="text" placeholder="State" name="state"
									class="form-control mb-3 shadow-none rounded-3 p-2 fs-5 border-2 border">
							</div>
							<div class="col-md-6 col-sm-10">
								<input type="email" placeholder="Email Address" name="email"
									class="form-control mb-3 shadow-none rounded-3 p-2 fs-5 border-2 border">
							</div>
							<div class="col-md-6 col-sm-10">
								<input type="number" placeholder="Phone" name="phone"
									class="form-control mb-3 shadow-none rounded-3 p-2 fs-5 border-2 border">
							</div>
			<!-- ---------------------------- -->
							<div class="col-md-6 col-sm-10">
								<input type="hidden" name="cmd" value="<%= finalCommand %>"
									class="form-control mb-3 shadow-none rounded-3 p-2 fs-5 border-2 border">
							</div>
														<div class="col-md-6 col-sm-10">
								<input type="hidden" name="uuid" value="<%= finalUuid %>"
									class="form-control mb-3 shadow-none rounded-3 p-2 fs-5 border-2 border">
							</div>
			<!-- ---------------------------- -->				
							
							<div class="text-center col-12">
								<button type="submit"
									class="btn btn-primary py-2 px-5 text-white fw-bold fs-5 rounded-3 shadow-none">
									Submit <i class="fa-solid fa-arrow-right"></i>
								</button>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>