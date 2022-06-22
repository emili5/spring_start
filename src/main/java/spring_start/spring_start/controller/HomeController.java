package spring_start.spring_start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //localhost:8080의 첫번째 페이지로 맵핑
    @GetMapping("/")
    public String home(){
        return "home"; //static을 보고 없으면 template에서 home.html이라는 파일을 찾아 화면에 띄워 줌.
    }
}
