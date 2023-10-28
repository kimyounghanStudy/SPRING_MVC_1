package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("messageBody = " + messageBody);
        // 위에 동작의 의미는 http 바디에 있는걸 가져와서 다 뿌리는것 ..!~.~
        //이제 받아온걸 객체로 만들어줘얗함 받아온거는 String 이니까.~.  라이브러리 쓰자

        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        /// 나중가면 ... req,resp, 파라미터 자리에 객체가 들어가는 편리함까지간다..
        //그것이 MVC..
        System.out.println("helloData.이름내놔 = " + helloData.getUsername());
        System.out.println("helloData.나이줘 = " + helloData.getAge());

        response.getWriter().write("OKOKOK");
    }
}
