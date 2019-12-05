<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Card List</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<%--<div id="wrapper">--%>
<%--    <div id="header">--%>
<%--        <h2>Card List</h2>--%>
<%--    </div>--%>
<%--</div>--%>
<%@include file="included/header.jsp"%>

<div id="container">
    <div id="content">
        <button class="add-button" onclick="window.location.href = '${contextPath}/card/showAddCardForm'; return false;">Add Card</button>

        <form:form action="search" method="get">
           Search Cards <input type="search" name="searchTerm">
            <input type="submit" value="Search" class="add-button">
        </form:form>

        <table>
            <tr>
                <th></th>
                <th>Name</th>
                <th>Description</th>
                <th>Color</th>
                <th>Attack</th>
                <th>Attack Mana Cost</th>
                <th>Defense</th>
                <th>Defense Mana Cost</th>
            </tr>

            <c:forEach var="tempCard" items="${cards}">
                <c:url var="updateLink" value="/card/showUpdateCardForm">
                    <c:param name="cardId" value="${tempCard.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/card/delete">
                    <c:param name="cardId" value="${tempCard.id}"/>
                </c:url>
                <tr>
                    <td>${tempCard.name}</td>
                    <td>${tempCard.description}</td>
                    <td>${tempCard.cardColor.name}</td>
                    <td>${tempCard.attack}</td>
                    <td>${tempCard.attackManaCost}</td>
                    <td>${tempCard.defense}</td>
                    <td>${tempCard.defenseManaCost}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}" onclick="if(!confirm('Are you sure?')) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>


</body>
</html>
