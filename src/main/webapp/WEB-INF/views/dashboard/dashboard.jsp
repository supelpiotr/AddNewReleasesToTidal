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

        <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
            <div class="btn-group btn-group-lg" role="group">
                <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
            <div class="btn-group btn-group-lg" role="group">
                <button id="btnGroupDrop2" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        TOP TRACKS
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="/toptracks/deep-house/12">Deep house</a>
                    <a class="dropdown-item" href="/toptracks/melodic-house-and-techno/90">Melodic House</a>
                    <a class="dropdown-item" href="/toptracks/minimal-deep-tech/14">Minimal</a>
                    <a class="dropdown-item" href="/toptracks/drum-and-bass/1">Drum And Bass</a>
                    <a class="dropdown-item" href="/toptracks/house/5">House</a>
                    <a class="dropdown-item" href="/toptracks/tech-house/11">Tech House</a>
                    <a class="dropdown-item" href="/toptracks/techno/6">Techno</a>
                    <a class="dropdown-item" href="/toprocktracks/">Rock</a>
                </div>
            </div>

            <c:if test="${not empty userPlaylists}">
            <div class="btn-group btn-group-lg " role="group">
                <button id="btnGroupDrop3" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    TIDAL PLAYLISTS
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <c:forEach items="${userPlaylists}" var="playlist" >
                        <a class="dropdown-item" href="link">${playlist.title}</a>
                    </c:forEach>
                </div>
            </div>
            </c:if>

        </div>
    </div>


    <c:if test="${not empty releases}">
        <%@ include file="/WEB-INF/views/dashboard/newreleasestable.jsp"%>
    </c:if>

    <c:if test="${not empty toptracks}">
        <%@ include file="/WEB-INF/views/dashboard/toptrackstable.jsp"%>
    </c:if>

</body>

</html>