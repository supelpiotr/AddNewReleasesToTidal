<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<body>

<%@ include file="/WEB-INF/header.jsp"%>
<%@ include file="/WEB-INF/topnav.jsp"%>

<div class="card">

    <h2>TITLE HEADING</h2>
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

    <%@ include file="/WEB-INF/views/dashboard/newreleasestable.jsp"%>

</div>
</div>

</body>

</html>