<%--
  Created by IntelliJ IDEA.
  User: 95493
  Date: 2019/5/26
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>秒杀商品目录</title>
    <link href="/css/byte.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="wrap">
        <table>
            <thead>
                <tr>
                    <th>商品ID</th>
                    <th>商品名称</th>
                    <th>秒杀价</th>
                    <th>库存</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody id="j_tb">
            <c:forEach var ="products" items="${products}">
                <form action="/product/detail" method="post">
                    <tr>
                        <td>${products.product_id}</td>
                        <td>${products.product_name}</td>
                        <td>${products.price}</td>
                        <td>${products.number}</td>
                        <td>${products.start_time}</td>
                        <td>${products.end_time}</td>
                        <td><input type="hidden" name="product_id" value="${products.product_id}"/>
                            <input type="submit" class="sub-button" value="进入抢购"/></td>
                    </tr>
                </form>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
