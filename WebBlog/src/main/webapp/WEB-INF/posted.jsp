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

<title>Top Posts</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/business-casual.css" rel="stylesheet">

<!-- Fonts -->
<link
	href="http://resources/fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="http://resources/fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="brand">Top Posts</div>
	<div class="address-bar">comment, like , share</div>

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
			<a class="navbar-brand" href="index.html">Top Posts</a>
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
		<c:forEach var="even" items="${posts}">
			<div class="row">
				<div class="box">
					 <div class="col-lg-12">
						<hr>
						<h2 class="intro-text text-center">
							${even.postType.type} 
						</h2>
						<hr>
					</div> 

					<div class="col-lg-12 text-center">
						<img class="img-responsive img-border img-left"
							src="resources/img/${even.picture}" alt="">
						<h2>
							${even.title}<br> <small>${even.postType.date}</small><br>
							<strong>@${even.postType.place}</strong>
						</h2>
						<p>${even.description}.</p>
						<p>posted id is......</p>
						<p>${even.id}.</p>
						<hr>
						<h3>Comments</h3>
						<hr>

						<c:forEach var="com" items="${even.comments}">
							${com.comment}
			              	${com.user.user.firstName}
			              	<hr>
						</c:forEach>




						<form action="comment?id=${even.id}" method="post">
							<textarea class="form-control" rows="1" name="comment"></textarea>
							<button type="submit" class="btn btn-success ">Comment</button>
						</form>
						<hr>
						<form action="like?id=${even.id}&like=${even.likes}"
							method="post">
							<button type="submit" class="btn btn-success">Like</button>
							<Strong>${even.likes}</Strong> others likes this
						</form>

						<hr>
						<form action="delete?id=${even.id}" method="post">

							<button class="btn btn-danger " type="submit">Delete</button>
						</form>
					</div>

				</div>
			</div>
		</c:forEach>
		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						New Posts
					</h2>
					<hr>
				</div>

				<div class="col-lg-12 text-center">
					<img class="img-responsive img-border img-left"
						src="resources/img/event-1.jpg" alt="">
					<h2>
						Save the Moment<br> <small>13.8.15</small>
					</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a varius ex. In hac habitasse platea dictumst. Mauris 
					vestibulum felis nec justo sagittis, nec porttitor tortor pretium. Mauris risus nulla, malesuada non est eget, porttitor iaculis 
					turpis. Aliquam sit amet urna leo. Duis placerat euismod felis, vel commodo enim fringilla quis. Phasellus varius tincidunt orci, 
					vel faucibus urna consectetur ut.</p>
					<textarea class="form-control" rows="1"></textarea>

					<a class="btn btn-success ">Comment</a> <a class="btn btn-success">Like</a>
					69 others likes this


					<hr>

					<button class="btn btn-danger " type="submit">Delete</button>

				</div>

			</div>
		</div>
		<div class="row">
			<div class="box">
				<div class="col-lg-12 text-center">
					<img class="img-responsive img-border img-left"
						src="resources/img/event-2.jpg" alt="">
					<h2>
						Morning, Sunshine! <br> <small>12.8.15 </small>
					</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum et tortor sed hendrerit. Nam ut vulputate nibh.
					 Maecenas id massa eu nunc feugiat congue. Sed mollis odio erat. Phasellus sed nunc sagittis, accumsan dui vel, auctor.</p>
					<textarea class="form-control" rows="1"></textarea>

					<a class="btn btn-success ">Comment</a> <a class="btn btn-success">Like</a>
					32 others likes this


					<hr>

					<button class="btn btn-danger " type="submit">Delete</button>

				</div>

			</div>

		</div>
		<div class="row">
			<div class="box">
				<div class="col-lg-12 text-center">
					<img class="img-responsive img-border img-left"
						src="resources/img/event-3.jpg" alt="">
					<h2>
						My story continues<br> <small>11.8.15</small>
					</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum et tortor sed hendrerit.
					   Nam ut vulputate nibh. Maecenas id massa eu nunc feugiat congue. Sed mollis odio erat. Phasellus sed nunc sagittis,
					   accumsan dui vel, auctor dolor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum et tortor sed hendrerit.
					   Nam ut vulputate nibh.Maecenas id massa eu nunc feugiat congue. Sed mollis odio erat. Phasellus sed nunc sagittis, 
					   accumsan dui vel, auctor dolor.
					</p>
					<textarea class="form-control" rows="1"></textarea>

					<a class="btn btn-success ">Comment</a> <a class="btn btn-success">Like</a>
					20 others likes this


					<hr>

					<button class="btn btn-danger " type="submit">Delete</button>

					<hr>
				</div>
				<div class="col-lg-12 text-center">
					<ul class="pager">
						<li class="previous"><a href="#">&larr; Older</a></li>
						<li class="next"><a href="#">Newer &rarr;</a></li>
					</ul>
				</div>
			</div>
		</div>

	</div>
	<!-- /.container -->

	<footer>
	<div class="container">
		<div class="row">
			<a href="./addingpost" class="btn btn-success btn-lg btn-block">Add
				Post</a>


			<div class="col-lg-12 text-center">
				<p>Copyright &copy;Web Blog 2016</p>
			</div>
		</div>
	</div>
	</footer>

	<!-- jQuery -->
	<script src="resources/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>

</body>

</html>
