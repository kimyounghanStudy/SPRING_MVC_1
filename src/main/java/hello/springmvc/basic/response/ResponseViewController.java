package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 여기서 하는건 풀스택 느낌으로 뷰까지 다 그려주는 걸 가정하고 하는것.!
 */
@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("response/hello").
                addObject("data","hello!");
        return mav;
    }
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){
        model.addAttribute("data","helllllooooooo!");
        return "response/hello";
    }

    //비추하는 방법임 너무 불명확
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model){
        model.addAttribute("data","hellllloooo333ooo!");
    }
}
