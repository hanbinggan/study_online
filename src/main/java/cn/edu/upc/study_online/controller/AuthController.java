package cn.edu.upc.study_online.controller;

import cn.edu.upc.study_online.dao.dao.StudentDao;
import cn.edu.upc.study_online.dao.dao.TeacherDao;
import cn.edu.upc.study_online.dao.object.StudentDo;
import cn.edu.upc.study_online.dao.object.TeacherDo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by songqiaolin on 2017/4/19.
 */
@Controller
public class AuthController {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam(value = "name", required = false) String name
            , @RequestParam(value = "password", required = false) String password
            , @RequestParam(value = "role", required = false) String role
            , Model model, HttpServletRequest httpServletRequest) {
        if ("student".equals(role)) {
            StudentDo studentDo = studentDao.queryByName(name);
            if (studentDo != null && studentDo.getPassword().equals(password)) {
                setUserSession(name, role, httpServletRequest);
                return "redirect:/";
            }
        } else {
            TeacherDo teacherDo = teacherDao.queryByName(name);
            if (teacherDo != null && teacherDo.getPassword().equals(password)) {
                setUserSession(name, role, httpServletRequest);
                return "redirect:/";
            }
        }
        model.addAttribute("warning", "账号密码错误");
        return "login";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.GET)
    public String mainPage() {
        return "main";
    }

    public void setUserSession(String name, String role
            , HttpServletRequest httpServletRequest) {
        Map<String, String> user = new HashedMap();
        user.put("name", name);
        user.put("role", role);
        httpServletRequest.getSession().setAttribute("user", user);
        httpServletRequest.getSession().setMaxInactiveInterval(30 * 60);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@RequestParam(value = "name") String name,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "password") String password,
                             @RequestParam(value = "role") String role,
                             Model model, HttpServletRequest request) {
        if ("student".equals(role)) {
            StudentDo studentDo = studentDao.queryByName(name);
            if (studentDo != null) {
                model.addAttribute("warning", "用户名已存在");
                return "/register";
            }
            studentDo = new StudentDo();
            studentDo.setName(name);
            studentDo.setEmail(email);
            studentDo.setPassword(password);
            studentDao.insert(studentDo);
        } else {
            TeacherDo teacherDo = teacherDao.queryByName(name);
            if (teacherDo != null) {
                model.addAttribute("warning", "用户名已存在");
                return "/register";
            }
            teacherDo = new TeacherDo();
            teacherDo.setName(name);
            teacherDo.setEmail(email);
            teacherDo.setPassword(password);
            teacherDao.insert(teacherDo);
        }
        setUserSession(name, role, request);
        return "redirect:/";
    }
}
