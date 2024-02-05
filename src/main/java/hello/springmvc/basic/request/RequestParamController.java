package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age{}",username,age);

        response.getWriter().write("ok");
    }

    /**
     * @PathVariable 과 @RequestParam은 구분해 ~
     */
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {
        log.info("username={}, age{}",memberName,memberAge);

        //여기에서 void라면 상관없지만 반환값이 string이면 ok라는 뷰를 찾게 된다(@Controller의 경우)
        // 따라서 해결할 방법은 두가지 클래스위에 @RestController or 메소드위에 @ResponseBody
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {
        // 리퀘스트파라미터명이랑 메소드의 파라미터명이랑 같으면 ("안에값" 생략가능)
        log.info("username={}, age{}",username,age);
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        // 리퀘스트파라미터명이랑 메소드의 파라미터명이랑 같으면 ("안에값" 생략가능) + 단순한 타입.. 즉 객체가 아니면 @RequestParam도 생략가능
        // 하지만 3번째 버전을 추천..
        log.info("username={}, age{}",username,age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age) {
        // 자바의 기본형에는 null이 안들들어가 기때문에 false라고 하면 에러를 던진다
        // 따라서 객체인 Integer로 받는게 더 좋다.
        // true 인경우 빈문자열과 null을 조심하자
        log.info("username={}, age{}",username,age);
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") Integer age) {
        // deafultValue를 사용한다면 required 필드는 무의미한 필드가 된다.
        //defaultValue 는 빈문자열이 경우도 처리해준다.!
        log.info("username={}, age{}",username,age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){
        log.info("username={},age={}",paramMap.get("username"),paramMap.get("age"));
        return "ok";
    }
}
