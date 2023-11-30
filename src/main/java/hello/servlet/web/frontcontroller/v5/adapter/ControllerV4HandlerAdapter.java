package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV4 controller = (ControllerV4) handler;
        Map<String, String> paramMap = createParamMap(request);
        //~ 내가 생각한 방식 start
//        Map<String, Object> model = new HashMap<>();
//        String getModelString = controller.process(paramMap, model);
//        Object modelView = model.get(getModelString);
//        return (ModelView)modelView ;
        // 내가 생각한 방식 end

        // 내가 생각한 방식은 개념 오류였음. 왜냐면 담겨오는 model에 담겨오는값은 ModelView 가 아닌 컨트롤러에서 Map 으로 만들어줘 화면에 뿌려줄 정보이기 때문 ..ㅠ_ㅠ
        Map<String, Object> model = new HashMap<>();
        String viewName = controller.process(paramMap, model);
        // 어뎁터의 중요한 이유!! 원하는 값에 맞게 변환시켜주는 역활임 !

        // 좀더 확장하면 모든 프론트 컨트롤러에 연결된 모든 부분을 인터페이스화...
        //ㅇㅎ
        ModelView mv = new ModelView(viewName);
        mv.setModel(model);
        return mv;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName->paramMap.put(paramName,request.getParameter(paramName)));
        return paramMap;
    }

}
