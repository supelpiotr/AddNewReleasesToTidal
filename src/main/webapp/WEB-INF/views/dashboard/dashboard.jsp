<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<body>

<%@ include file="/WEB-INF/header.jsp"%>
<%@ include file="/WEB-INF/topnav.jsp"%>



<head>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

</head>

<div class="card">

    <h2> Add new tracks from junodownload.com bestsellers to Tidal playlist </h2>
    <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            NEW RELEASES
        </button>
        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="/newreleases/bass">Bass</a>
            <a class="dropdown-item" href="/newreleases/breakbeat">Breakbeat</a>
            <a class="dropdown-item" href="/newreleases/disco">Disco/Nu-Disco</a>
            <a class="dropdown-item" href="/newreleases/drumandbass">Drum And Bass</a>
            <a class="dropdown-item" href="/newreleases/dubstep">Dubstep</a>
            <a class="dropdown-item" href="/newreleases/edm">EDM</a>
            <a class="dropdown-item" href="/newreleases/electro">Electro</a>
            <a class="dropdown-item" href="/newreleases/dance-pop">Euro Dance/Pop Dance</a>
            <a class="dropdown-item" href="/newreleases/footwork-juke">Footwork/Juke</a>
            <a class="dropdown-item" href="/newreleases/funk-soul-jazz">Funk Soul & Jazz</a>
            <a class="dropdown-item" href="/newreleases/hardcore">Hardcore/style</a>
            <a class="dropdown-item" href="/newreleases/hip-hop">Hip Hop/R&B</a>
            <a class="dropdown-item" href="/newreleases/house">House</a>
            <a class="dropdown-item" href="/newreleases/leftfield">Leftfield</a>
            <a class="dropdown-item" href="/newreleases/pop">Pop</a>
            <a class="dropdown-item" href="/newreleases/reggae">Reggae</a>
            <a class="dropdown-item" href="/newreleases/rock-music">Rock (All)</a>
            <a class="dropdown-item" href="/newreleases/techno">Techno</a>
            <a class="dropdown-item" href="/newreleases/trance-music">Trance</a>
            <a class="dropdown-item" href="/newreleases/4x4-garage">UK Garage</a>
        </div>
    </div>

    <%@ include file="/WEB-INF/views/dashboard/newreleasestable.jsp"%>

</div>
</div>

</body>

</html>