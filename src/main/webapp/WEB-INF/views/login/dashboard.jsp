<%--<%@ include file="/WEB-INF/header.jsp"%>--%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Grayscale - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/grayscale.min.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Navigation -->
<%@ include file="/WEB-INF/views/navigationbar.jsp"%>

<header class="masthead">
    <div class="container d-flex h-100 align-items-center">
        <div class="mx-auto text-center">
            <h1 class="mx-auto my-0 text-uppercase">REGISTER</h1>
            <form:form method="post" modelAttribute="user">

                <div class="container">
                    <div class="card">
                        <div class="card-body">
                            <div class="dropdown-content">
                                <a href="/newreleases/bass">Bass</a>
                                <a href="/newreleases/breakbeat">Breakbeat</a>
                                <a href="/newreleases/disco">Disco/Nu-Disco</a>
                                <a href="/newreleases/drumandbass">Drum And Bass</a>
                                <a href="/newreleases/dubstep">Dubstep</a>
                                <a href="/newreleases/edm">EDM</a>
                                <a href="/newreleases/electro">Electro</a>
                                <a href="/newreleases/dance-pop">Euro Dance/Pop Dance</a>
                                <a href="/newreleases/footwork-juke">Footwork/Juke</a>
                                <a href="/newreleases/funk-soul-jazz">Funk Soul & Jazz</a>
                                <a href="/newreleases/hardcore">Hardcore/style</a>
                                <a href="/newreleases/hip-hop">Hip Hop/R&B</a>
                                <a href="/newreleases/house">House</a>
                                <a href="/newreleases/leftfield">Leftfield</a>
                                <a href="/newreleases/pop">Pop</a>
                                <a href="/newreleases/reggae">Reggae</a>
                                <a href="/newreleases/rock-music">Rock (All)</a>
                                <a href="/newreleases/techno">Techno</a>
                                <a href="/newreleases/trance-music">Trance</a>
                                <a href="/newreleases/4x4-garage">UK Garage</a>
                            </div>
                        </div>
                    </div>

                </div>
            </form:form>
        </div>
    </div>
</header>


<!-- Contact Section -->
<section class="contact-section bg-black">
    <div class="container">

        <div class="row">

            <div class="col-md-4 mb-3 mb-md-0">
                <div class="card py-4 h-100">
                    <div class="card-body text-center">
                        <i class="fas fa-map-marked-alt text-primary mb-2"></i>
                        <h4 class="text-uppercase m-0">Address</h4>
                        <hr class="my-4">
                        <div class="small text-black-50">4923 Market Street, Orlando FL</div>
                    </div>
                </div>
            </div>

            <div class="col-md-4 mb-3 mb-md-0">
                <div class="card py-4 h-100">
                    <div class="card-body text-center">
                        <i class="fas fa-envelope text-primary mb-2"></i>
                        <h4 class="text-uppercase m-0">Email</h4>
                        <hr class="my-4">
                        <div class="small text-black-50">
                            <a href="#">hello@yourdomain.com</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-4 mb-3 mb-md-0">
                <div class="card py-4 h-100">
                    <div class="card-body text-center">
                        <i class="fas fa-mobile-alt text-primary mb-2"></i>
                        <h4 class="text-uppercase m-0">Phone</h4>
                        <hr class="my-4">
                        <div class="small text-black-50">+1 (555) 902-8832</div>
                    </div>
                </div>
            </div>
        </div>

        <div class="social d-flex justify-content-center">
            <a href="#" class="mx-2">
                <i class="fab fa-twitter"></i>
            </a>
            <a href="#" class="mx-2">
                <i class="fab fa-facebook-f"></i>
            </a>
            <a href="#" class="mx-2">
                <i class="fab fa-github"></i>
            </a>
        </div>

    </div>
</section>

<!-- Footer -->
<footer class="bg-black small text-center text-white-50">
    <div class="container">
        Copyright &copy; MyMusicList 2019
    </div>
</footer>

<!-- Bootstrap core JavaScript -->
<script src="resources/vendor/jquery/jquery.min.js"></script>
<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for this template -->
<script src="resources/js/grayscale.min.js"></script>

</body>

</html>
