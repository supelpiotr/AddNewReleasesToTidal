<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>MyMusicList</title>
</head>
<body>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>


</head>

<body>
<%--<sec:authorize access="!isAuthenticated()">--%>
<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-around">
        <a href="/" class="navbar-brand main-logo">
            My <span>MusicList</span>
        </a>
        <ul class="nav nounderline text-uppercase">
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="/signin">SIGN IN</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="/signup">SIGN UP</a>
            </li>
        </ul>
    </nav>
</header>
<%--</sec:authorize>--%>

<%--<sec:authorize access="isAuthenticated()">--%>
    <header class="page-header">
        <nav class="navbar navbar-expand-lg justify-content-around">
            <a href="/" class="navbar-brand main-logo">
                My <span>MusicList</span>
            </a>
            <div class="dropdown">
                <button class="dropbtn">New Releases</button>
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
            <ul class="nav nounderline text-uppercase">
                <li class="nav-item ml-4">
                    <a class="nav-link color-header" href="/logout">LOGOUT</a>
                </li>
            </ul>
        </nav>
    </header>
<%--</sec:authorize>--%>

</body>
</html>
