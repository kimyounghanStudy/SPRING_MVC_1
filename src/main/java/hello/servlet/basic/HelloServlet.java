package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="helloServlet", urlPatterns = "/hello")   //hello 로 온다면 요기서 정의한것이 실행   겹치면 안된다 !
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");  // http content type (헤더 정보)
        response.setCharacterEncoding("utf-8");// http content type (헤더 정보)
        response.getWriter().write("hello"+username);  // http body 에 들어감
        // 아 ~ /hello 으로 들어가고 .. 쿼리파라미터를 파싱해서 request 및 response 를 하는구나..?!
        //git test1234

    }
}
