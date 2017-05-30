package cn.edu.upc.study_online.controller.lesson;

import cn.edu.upc.study_online.controller.vo.StudentLessonRefVo;
import cn.edu.upc.study_online.dao.dao.LessonDao;
import cn.edu.upc.study_online.dao.dao.StudentLessonRefDao;
import cn.edu.upc.study_online.dao.object.LessonDo;
import cn.edu.upc.study_online.dao.object.StudentLessonRefDo;
import cn.edu.upc.study_online.service.StudentLessonRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Controller
@RequestMapping("/lesson")
public class ManageStudentController {
    @Autowired
    private StudentLessonRefService studentLessonRefService;

    @Autowired
    private StudentLessonRefDao studentLessonRefDao;

    @Autowired
    private LessonDao lessonDao;
    @RequestMapping("/student")
    public String student(@RequestParam("id") Long lessonId, Model model){
        List<StudentLessonRefVo> appliedLesson = studentLessonRefService
                .queryByLessonStatus(lessonId, StudentLessonRefDo.STATUS.applied.getValue());
        List<StudentLessonRefVo> applyingLesson = studentLessonRefService
                .queryByLessonStatus(lessonId, StudentLessonRefDo.STATUS.applying.getValue());
        LessonDo lessonDo=lessonDao.queryById(lessonId);

        model.addAttribute("applied_lesson", appliedLesson);
        model.addAttribute("applying_lesson", applyingLesson);
        model.addAttribute("lesson", lessonDo);
        return "lesson/lesson_student_manage";
    }

    @RequestMapping("/join")
    public String student(@RequestParam("student_id") Long studentId,
                          @RequestParam("lesson_id") Long lessonId,
                          Model model){
        StudentLessonRefDo studentLessonRefDo = studentLessonRefDao.queryByStudentLesson(studentId, lessonId);
        studentLessonRefDo.setStatus(StudentLessonRefDo.STATUS.applied.getValue());
        studentLessonRefDao.update(studentLessonRefDo);
        return student(lessonId, model);
    }

}
