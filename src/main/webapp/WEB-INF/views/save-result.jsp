<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
성공
<ul>
  <li>id 는 말이야 <%= ((Member)request.getAttribute("member")).getId()%></li>
  <li>username 은 말이야 ${member.username}</li>
  <li>age 는 말이야 ${member.age}</li>
</ul>
</body>

<a href="/index.html"> 메인 ! </a>
</html>
