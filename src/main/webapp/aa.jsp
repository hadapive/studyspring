<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/4
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%

    //response.getWriter().write(request.getAttribute("name").toString());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    你好,aa.jsp
    <c:out value="${name}"></c:out>
<hr/>
    我的名字是${name},年龄${age}.
</body>
</html>
