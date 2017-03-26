package cn.edu.upc.study_online.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiaolin.song on 2017/1/23.
 */
@Controller
public class AnalysisHttp {
    @RequestMapping(value = "/analysis")
    public @ResponseBody
    Map<String,Object> analysisHttp(ServletWebRequest servletWebRequest){
        HttpServletRequest httpServletRequest = servletWebRequest.getRequest();

        Map<String,Object> map = new HashMap<>();
        map.put("status",0);
        Map<String,Object> data = new HashMap<>();
        data.put("protocol",httpServletRequest.getProtocol());
        data.put("host",httpServletRequest.getRemoteHost());
        data.put("port",httpServletRequest.getRemotePort());
        data.put("path",httpServletRequest.getContextPath());
        data.put("url",httpServletRequest.getRequestURL().toString());
        map.put("data",data);
        return map;
    }
}
