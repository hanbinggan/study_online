package cn.edu.upc.study_online.controller.manage;

import cn.edu.upc.study_online.dao.dao.TeacherDao;
import cn.edu.upc.study_online.dao.object.TeacherDo;
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
@RequestMapping("/manage/teacher")
public class TeacherController {
    @Autowired
    private TeacherDao teacherDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String teacher(Model model) {
        TeacherDo teacherDo = new TeacherDo();
        model.addAttribute("teacherForm", teacherDo);
        List<TeacherDo> teacherDoList = teacherDao.queryAll();
        model.addAttribute("teacherList", teacherDoList);
        return "manage/teacher";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTeacher(@ModelAttribute("teacherForm") TeacherDo teacherDo, Model model) {
        teacherDao.insert(teacherDo);
        return teacher(model);
    }


    @RequestMapping(value = "/update", params = {"id"}, method = RequestMethod.GET)
    public String update(@RequestParam(value = "id") Long id, Model model) {
        TeacherDo teacherDo = teacherDao.queryById(id);
        model.addAttribute("teacher", teacherDo);
        return "manage/update_teacher";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateTeacher(@ModelAttribute("teacher") TeacherDo teacherDo, Model model) {
        teacherDao.update(teacherDo);
        model.addAttribute("Teacher", teacherDo);
        return "manage/update_teacher";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Long id, Model model){
        teacherDao.delete(id);
        return teacher(model);
    }
}
