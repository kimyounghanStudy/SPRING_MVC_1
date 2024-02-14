package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//다형성 ..!   을 위한 인터페이스 ..! ->
public interface ControllerV1 {

    //서블릿이랑 유사하게 만들어준다
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
