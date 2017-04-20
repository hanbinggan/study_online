package cn.edu.upc.study_online.controller.manage;

import cn.edu.upc.study_online.dao.dao.StudentDao;
import cn.edu.upc.study_online.dao.object.StudentDo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by songqiaolin on 2017/4/19.
 */
@Controller
@RequestMapping("/manage/student")
public class StudentController {
    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String student(Model model) {
        StudentDo user = new StudentDo();
        model.addAttribute("studentForm", user);
        List<StudentDo> studentDoList = studentDao.queryAll();
        model.addAttribute("studentList", studentDoList);
        return "manage/student";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("studentForm") StudentDo studentDo, Model model) {
        studentDao.insert(studentDo);
        return student(model);
    }

    @RequestMapping(value = "/update", params = {"id"}, method = RequestMethod.GET)
    public String update(@RequestParam(value = "id") Long id, Model model) {
        StudentDo studentDo = studentDao.queryById(id);
        model.addAttribute("student", studentDo);
        return "manage/update_student";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute("student") StudentDo studentDo, Model model) {
        studentDao.update(studentDo);
        model.addAttribute("student", studentDo);
        return "manage/update_student";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Long id, Model model){
        studentDao.delete(id);
        return student(model);
    }
}
