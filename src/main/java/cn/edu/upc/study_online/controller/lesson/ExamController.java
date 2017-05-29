package cn.edu.upc.study_online.controller.lesson;

import cn.edu.upc.study_online.dao.dao.ExamDao;
import cn.edu.upc.study_online.dao.dao.LessonDao;
import cn.edu.upc.study_online.dao.object.ExamDo;
import cn.edu.upc.study_online.dao.object.LessonDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/29.
 */
@Controller
@RequestMapping("/lesson/exam")
public class ExamController {
    @Autowired
    private LessonDao lessonDao;

    @Autowired
    private ExamDao examDao;

    @RequestMapping("")
    public String exam(@RequestParam("id") Long lessonId, Model model){
        LessonDo lessonDo = lessonDao.queryById(lessonId);
        List<ExamDo> examDoList = examDao.queryByLesson(lessonId);
        model.addAttribute("lesson", lessonDo);
        model.addAttribute("exam_list", examDoList);
        return "problem/exam";
    }
}
