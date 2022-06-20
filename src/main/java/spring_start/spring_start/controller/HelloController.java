package spring_start.spring_start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!"); //key는 data, value는 hello!로 model에 넘겨줌
        return "hello"; // resources/templates의 hello.html을 찾아 가라는 의미(ViewName.html)
    }
    @GetMapping("hello-mvc") //get방식으로 요청했을 때 /hello-mvc로 온 애를 스프링 부트에 던집
    public String helloMvc(@RequestParam(value = "name",required = false) String name, Model model) {
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http의 응답body부에 return값을 직접 넣어주겠다는 어노테이션으로 반드시 써줘야 함, 반환 타입이 String이면 ViewResolver한테 넘겨줌
    public String helloString (@RequestParam("name") String name){
        return "hello"+name;
    }

    @GetMapping("hello-api")
    @ResponseBody// 객체를 넘긴 경우 json방식으로 값을 넘겨서 보여줌
    public Hello helloApi (@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        //getter setter 부르는 단축키: Alt+Insert
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
