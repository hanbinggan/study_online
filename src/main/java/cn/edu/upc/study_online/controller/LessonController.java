package cn.edu.upc.study_online.controller;

import cn.edu.upc.study_online.dao.dao.LessonChapterDao;
import cn.edu.upc.study_online.dao.dao.LessonDao;
import cn.edu.upc.study_online.dao.dao.TeacherDao;
import cn.edu.upc.study_online.dao.object.LessonChapterDo;
import cn.edu.upc.study_online.dao.object.LessonDo;
import cn.edu.upc.study_online.dao.object.TeacherDo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by songqiaolin on 2017/5/21.
 */
@Controller
@RequestMapping(value = "/lesson")
public class LessonController {
    @Autowired
    private LessonChapterDao lessonChapterDao;

    @Autowired
    private LessonDao lessonDao;

    @RequestMapping(value = "")
    public String lesson(Model model,
                         HttpServletRequest request) {

        Map<String, Object> user = (Map<String, Object>) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        Long id = (Long) user.get("id");
        List<LessonDo> lessonList = lessonDao.selectByCreator(id);
        model.addAttribute("lessonList", lessonList);
        return "lesson/lesson";
    }

    @RequestMapping(value = "/add")
    public String addLesson(Model model) {
        LessonDo lessonDo = new LessonDo();
        model.addAttribute("lesson", lessonDo);
        return "lesson/add_lesson";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addLesson(@ModelAttribute(value = "lesson") LessonDo lessonDo
            , HttpServletRequest request
            , Model model) {
        if (lessonDo.getStudyStarScore() < 0) {
            model.addAttribute("warning", "课程分数错误");
            return "lesson/add_lesson";
        }
        Map<String, Object> user = (Map<String, Object>) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        String role = (String) user.get("role");
        if (!"teacher".equals(role)
                || user.get("name") == null) {
            return "redirect:/login";
        }
        Long id = (Long) user.get("id");
        lessonDo.setCreatorId(id);
        lessonDao.insert(lessonDo);
        return "redirect:/lesson";
    }

    @RequestMapping("/info")
    public String info(@RequestParam Long id, Model model) {
        LessonDo lessonDo = lessonDao.queryById(id);
        model.addAttribute("lesson", lessonDo);
        List<LessonChapterDo> lessonChapterDos = lessonChapterDao.queryByLesson(id);
        model.addAttribute("lessonChapters", lessonChapterDos);
        return "lesson/lesson_info";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute(value = "lesson") LessonDo lessonDo, Model model){
        lessonDao.update(lessonDo);
        return "redirect:/lesson/info?id="+lessonDo.getId();
    }

    @RequestMapping("/delete")
    public String delete() {
        return "";
    }
}
