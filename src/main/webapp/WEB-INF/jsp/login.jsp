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
<title>Login Here!</title>
</head>

<body>
	<div class="container">
		<div class="row justify-content-center align-items-center"
			style="height: 100vh;">
			<div class="col-lg-6">
				<div class="border border-2 rounded-3 p-lg-5 p-4 shadow-lg">
					<h3 class="text-center mb-4 fs-3 fw-bold">Please! login
						here...</h3>
						<h2 class="text-center mb-4 fs-3 fw-bold">${errorMessage}</h2>
					<form action="/"
						
						method="post">
						<input type="text" placeholder="Login ID" name="login_id"
							class="form-control mb-4 shadow-none rounded-3 p-2 fs-5 border-2 border"
							required> 
							<input type="password" placeholder="Password"
							name="password"
							class="form-control mb-4 shadow-none rounded-3 p-2 fs-5 border-2 border"
							required>
							<input type="hidden" name="cmd" value="get_customer_list">
						<div class="text-center">
							<button type="submit"
								class="btn btn-primary py-2 px-5 text-white fw-bold fs-5 rounded-3 shadow-none">
								Submit <i class="fa-solid fa-arrow-right"></i>
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>


</body>

</html>