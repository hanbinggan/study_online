package cn.edu.upc.study_online.controller.problem;

import cn.edu.upc.study_online.dao.dao.ExamDao;
import cn.edu.upc.study_online.dao.dao.LessonDao;
import cn.edu.upc.study_online.dao.dao.ProblemDao;
import cn.edu.upc.study_online.dao.dao.StudyRecordDao;
import cn.edu.upc.study_online.dao.object.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by songqiaolin on 2017/5/30.
 */
@RequestMapping("/student/lesson/exam")
@Controller
public class StudentExamController {
    @Autowired
    private LessonDao lessonDao;

    @Autowired
    private ExamDao examDao;

    @Autowired
    private ProblemDao problemDao;

    @Autowired
    private StudyRecordDao studyRecordDao;

    @RequestMapping("")
    public String exam(@RequestParam("id") Long lessonId, Model model, HttpServletRequest request) {
        Map<String, Object> user = (Map<String, Object>) request.getSession().getAttribute("user");
        if (user == null || !"student".equals((String) user.get("role"))) {
            return "redirect:/login";
        }

        Long studentId = (Long) user.get("id");

        List<ExamDo> examDoList = examDao.queryByLesson(lessonId);

        Date curTime = new Date();
        for (ExamDo examDo : examDoList) {
            StudyRecordDo studyRecordDo = studyRecordDao.queryByObjectStudent(
                    StudyStarScoreDo.TYPE.exam.getVal(), examDo.getId(), studentId);
            if(studyRecordDo != null){
                examDo.setLessonId(1L);
            } else if (curTime.before(examDo.getStartTime())) {
                examDo.setLessonId(-1L);
            } else if (curTime.after(examDo.getEndTime())) {
                examDo.setLessonId(2L);
            } else {
                examDo.setLessonId(0L);
            }
        }
        model.addAttribute("exam_list", examDoList);

        LessonDo lessonDo = lessonDao.queryById(lessonId);
        model.addAttribute("lesson", lessonDo);
        return "student/exam";
    }

    @RequestMapping("/join")
    public String join(@RequestParam("id") Long examId, Model model) {
        List<ProblemDo> problemDoList = problemDao.queryByObject(ProblemDo.TYPE.exam.getVal(), examId);
        model.addAttribute("problem_list", problemDoList);

        ExamDo examDo = examDao.queryById(examId);
        model.addAttribute("exam", examDo);
        LessonDo lessonDo = lessonDao.queryById(examDo.getLessonId());
        model.addAttribute("lesson", lessonDo);
        return "/student/exam_info";
    }
}
