package cn.edu.upc.study_online.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by qiaolin.song on 2017/1/23.
 */
@Controller
//@RequestMapping("/")
public class BaseController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "main";
    }
}
