package cn.edu.upc.study_online.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by songqiaolin on 2017/4/19.
 */
@Controller
public class AuthController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(){
        return "main";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.GET)
    public String mainPage(){
        return "main";
    }
}
