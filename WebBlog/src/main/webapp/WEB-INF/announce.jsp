<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">

<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Announcements</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/business-casual.css" rel="stylesheet">

<!-- Fonts -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="brand">Announcements</div>
	<div class="address-bar">Stay Up2Date</div>

	<!-- Navigation -->
	<nav class="navbar navbar-default" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
			<a class="navbar-brand" href="index.html">Web Blog</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="./posted">Posts</a></li>
				<li><a href="./announce">Announcement</a></li>

				<li><a href="./about">About</a></li>

				<li><a href="./profile">My Profile</a></li>


				<li><a href="./contact">Contact</a></li>
				<a href="./logout" class="btn btn-success ">LogOut</a>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<div class="container">
		<c:forEach var="announcment" items="${announcments}">
			<div class="row">
				<div class="box">
					<div class="col-lg-12">

						<hr>
						<h2 class="intro-text text-center">
							<strong>${announcment.title}</strong>
						</h2>
						<hr>

						<img class="img-responsive img-border img-left" alt=""
							src="resources/img/${announcment.image}"> <Strong>@
							${announcment.date}</Strong>
						<hr class="visible-xs">
						<p>${announcment.discription}</p>

					</div>
				</div>
			</div>
		</c:forEach>

		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						Announcements<strong>worth visiting</strong>
					</h2>
					<hr>
					<img class="img-responsive img-border img-left"
						src="resources/img/intro-pic.jpg" alt="">
					<hr class="visible-xs">
					<p>Mark Forrester
					This awesome blog-styled website is a creative outlet for Mark Forrester, a “half-baked”
 					(his words) English/South African freelance designer and entrepreneur. 
 					The journal is easy and pleasant to navigate, and the cartoon illustrations in the header and footer are incredible. 
					(They were designed by Cape Town-based illustrator and cartoonist Alex Latimer). </p>
						<p>
						......</p>
					<!-- </p> -->

				</div>
			</div>
		</div>

		<!-- <div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						Big  <strong>Announcments</strong>
					</h2>
					<hr>
					<p>.</p>
				</div>
			</div> 
		</div> -->

	</div>
	<!-- /.container -->

	<footer> 
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<a href="./addannouncment" class="btn btn-success btn-lg btn-block">Add
					Announcement</a>
				<p>Copyright &copy;Web Blog 2016</p>
			</div>
		</div>
	</div>
	</footer>

	<!-- jQuery -->
	<script src="resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>

	<!-- Script to Activate the Carousel -->
	<script>
		$('.carousel').carousel({
			interval : 5000
		//changes the speed
		})
	</script>

</body>

</html>
