<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
        <table class="tab-content">
                <tr>
                    <th colspan="3">
                        <a href="/createplaylist/${releases.genre}"> ADD PLAYLIST TO TIDAL </a>
                    </th>
                </tr>
                <tr>
                    <th>Title</th>
                    <th>Artist</th>
                    <th>Listen on Tidal</th>
                </tr>
                <td>
                    <table>
                        <c:forEach items="${releases.titles}" var="title" >
                            <tr>
                                <td>${title}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
                <td>
                    <table>
                        <c:forEach items="${releases.artists}" var="artist" >
                            <tr>
                                <td>${artist}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
                <td>
                    <table>
                        <c:forEach items="${releases.tidalURL}" var="url" >
                            <tr>
                                <td><a href=" ${url}"> ${url} </a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
        </table>
    </div>