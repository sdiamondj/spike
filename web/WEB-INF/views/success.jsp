<%--
  Created by IntelliJ IDEA.
  User: 95493
  Date: 2019/5/27
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成功</title>
</head>
<body>

<table>
    <tr>
        <th>商品ID</th>
        <th>用户名</th>
        <th>状态</th>
        <th>创建时间</th>
    </tr>
<c:forEach var ="info" items="${info}">
        <tr>
            <td>${info.product_id}</td>
            <td>${info.username}</td>
            <td>${info.state}</td>
            <td>${info.create_time}</td>
        </tr>

</c:forEach>
</table>
</body>
</html>
