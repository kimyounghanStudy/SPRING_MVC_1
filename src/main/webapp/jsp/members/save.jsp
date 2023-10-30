<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>

<%
//자바 코드가 들어가는 영역 == 비지니스 로직

  // + request, response 사용가능 == 서블릿으러 자동 변환되서 사용 되기 때문.
  MemberRepository memberRepository = MemberRepository.getInstance();
  System.out.println("MemberSaveServlet.service");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username, age);
  memberRepository.save(member);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
  <li>id 는 말이야 <%=member.getId()%></li>
  <li>username 은 말이야 <%=member.getUsername()%></li>
  <li>age 는 말이야 <%=member.getAge()%></li>
</ul>
</body>

<a href="/index.html"> 메인 ! </a>
</html>
