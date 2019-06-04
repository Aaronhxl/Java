<%--
  Created by IntelliJ IDEA.
  User: 黄龙
  Date: 2019/5/8
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>This is only a demo</h3>

    <c:forEach items="${users}" var="user">
        ${user}
    </c:forEach>
</body>
</html>
