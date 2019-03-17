<%--
  Created by IntelliJ IDEA.
  User: 我
  Date: 2019/3/9 0009
  Time: 23:30
  To change this template use File | Settings | File Templates.
  c标签的使用
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html lang="en">
<%
    int count = (int)request.getSession().getAttribute("count");
    for (int i=0;i<count;i++){
%>
        haha
       <br/>
<%}%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${username =='neo'}">
        什么鬼
    </c:if>

    <c:choose>
        <c:when test="${username =='neo'}">
            什么鬼2
        </c:when>
        <c:otherwise>
            hh33
        </c:otherwise>
    </c:choose>

    <c:forEach items="${list}" var="item" varStatus="var" step="1">
        <h1>${item}:${var.index}:${var.first}:${var.count}</h1>
    </c:forEach>
</body>
</html>
<%@include file="footer.jsp"%>
