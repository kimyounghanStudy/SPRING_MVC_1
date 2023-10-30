
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!-- 상대경로 사용,[현재 URL 이 속한 계층 경로 + /save]  ~  강의중 여러곳에서 재사용 할려고  보통 절대경로가 안전.--->
<form action="save" method="post">
    username : <input type="text" name="username"/>
    age : <input type="text" name="age"/>
  <button type="submit"> 전송이라구 ~ </button>

</form>

</body>
</html>
