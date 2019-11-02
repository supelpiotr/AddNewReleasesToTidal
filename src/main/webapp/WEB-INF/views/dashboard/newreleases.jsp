<%@ include file="/WEB-INF/header.jsp"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
<section class="padding-large bg-light">
    <table class="center" border style="width:auto" align="center">
        <tbody>
        <tr>
            <th colspan="2">ADD PLAYLIST TO TIDAL</th>
        </tr>
        <tr>
            <th>Title</th>
            <th>Artist</th>
            <th>Listen on Tidal</th>
        </tr>
        <td>
            <table class="center">
                <c:forEach items="${releases.titles}" var="title" >
                    <tr>
                        <td>${title}</td>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <td>
            <table class="center">
                <c:forEach items="${releases.artists}" var="artist" >
                    <tr>
                        <td>${artist}</td>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <td>
            <table class="center">
                <c:forEach items="${releases.tidalUrl}" var="tidal" >
                    <tr>
                        <td>${tidal}</td>
                    </tr>
                </c:forEach>
            </table>
        </td>
        </tbody>
    </table>
</section>
</sec:authorize>