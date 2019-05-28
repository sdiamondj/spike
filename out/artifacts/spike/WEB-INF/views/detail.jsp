<%--
  Created by IntelliJ IDEA.
  User: 95493
  Date: 2019/5/27
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>秒杀详情页</title>
    <link href="/css/dance.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="top">
        <span class="something">尊敬的${sessionScope.username},
            <a href="/user/my/${sessionScope.username}">查看我的抢购</a> </span>
    </div>
    <div class="picture">
        <img src="/images/miaosha.jpg">
    </div>
    <form action="/info/submit" method="post" name="myForm">
        <div class="center">
            <span class="name">${product.product_name}</span><br><br>
            <span class="price">秒杀价:${product.price}</span><br><br>
            <span class="number">库存:${product.number}</span><br><br>
            <span class="time">开始时间:${product.start_time}</span><br><br>
            <span class="time">结束时间:${product.end_time}</span><br><br><br><br>
            <input type="hidden" name="product_id" value="${product.product_id}"/>
            <input type="hidden" name="start" value="${product.start_time}">
            <input type="hidden" name="end" value="${product.end_time}">
            <input type="hidden" name="number" value="${product.number}">
            <input type="submit" class="sub-button" value="立即秒杀" onclick=" return isAtTime()">
        </div>
    </form>
</body>
<script>
    function isAtTime() {
        var start = myForm.start.value;
        var end = myForm.end.value;
        var sDate = new Date(Date.parse(start.replace(/-/g, "/")));
        var eDate = new Date(Date.parse(end.replace(/-/g, "/")));
        var myDate = new Date();
        if(sDate.getTime()<myDate.getTime()&&eDate.getTime()>myDate.getTime()){
            var number = myForm.number.value;
            if(number > 0)
                return true;
            else{
                alert("秒杀失败!库存不足!");
                return false;
            }
        }
        else{
            alert("不在秒杀时间内!");
            return false;
        }
    }
</script>

</html>
