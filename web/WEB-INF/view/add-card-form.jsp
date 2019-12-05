<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Donut</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-card-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>New Donut</h2>
    </div>
</div>


<form:form action="${contextPath}/save" modelAttribute="aCard" method="post" enctype="multipart/form-data">
    <form:hidden path="id" value="${aCard.id}"/>

    <table>
        <tr>
            <td><label>Name</label></td>
            <td><form:input path="name"/>
                <form:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Description</label></td>
            <td><form:input path="description"/>
                <form:errors path="description" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Color</label></td>
            <td>
            <form:select path="cardColor" items="${cardColor}"
                         itemLabel="name" itemValue="id">
            </form:select>
            </td>
        </tr>
        <tr>
            <td><label>Attack</label></td>
            <td><form:input path="attack"/>
                <form:errors path="attack" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Attack Mana Cost</label></td>
            <td><form:input path="attackManaCost"/>
                <form:errors path="attackManaCost" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Defense</label></td>
            <td><form:input path="defense"/>
                <form:errors path="defense" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Defense Mana Cost</label></td>
            <td><form:input path="defenseManaCost"/>
                <form:errors path="defenseManaCost" cssClass="error"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save" class="save"></td>
        </tr>
    </table>
</form:form>

<%@include file="included/footer.jsp"%>
</body>
</html>
