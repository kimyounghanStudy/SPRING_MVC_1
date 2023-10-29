package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="responseJsonServlet",urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Content-Type : application/json

        response.setContentType("application/json");
        //json은 utf-8을 사용하도록 정의하고 있기때문에 아래문장은 의미 없다 ..
        //response/getWiter 를 사용하면 아래 내용을 추가한다 이럴때는 response.getOutputStream()으로 출력하면 문제없다..
        response.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("jin");
        helloData.setAge(20);

        //json 형식으로 전달해주려면 오브젝트 맴퍼가 필요 !
        String result = objectMapper.writeValueAsString(helloData);

        response.getWriter().write(result);

    }
}
