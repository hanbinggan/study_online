package cn.edu.upc.study_online.controller.problem;

import cn.edu.upc.study_online.dao.dao.*;
import cn.edu.upc.study_online.dao.object.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by songqiaolin on 2017/5/29.
 */
@Controller
@RequestMapping("/student/lesson/exercise")
public class StudentExerciseController {
    @Autowired
    private ExerciseDao exerciseDao;

    @Autowired
    private LessonChapterDao lessonChapterDao;

    @Autowired
    private ProblemDao problemDao;

    @Autowired
    private LessonDao lessonDao;

    @Autowired
    private AnswerDao answerDao;

    @Autowired
    private StudyRecordDao studyRecordDao;

    @RequestMapping("")
    public String exercise(@RequestParam("id") Long chapterId, Model model, HttpServletRequest request) {
        Map<String, Object> user = (Map<String, Object>) request.getSession().getAttribute("user");
        if (user == null || !"student".equals((String) user.get("role"))) {
            return "redirect:/login";
        }

        Long studentId = (Long) user.get("id");
        List<ExerciseDo> exerciseDoList = exerciseDao.queryByChapter(chapterId);
        for (ExerciseDo exerciseDo : exerciseDoList) {
            StudyRecordDo studyRecordDo = studyRecordDao.queryByObjectStudent(
                    StudyStarScoreDo.TYPE.exercise.getVal(), exerciseDo.getId(), studentId);
            if (studyRecordDo != null) {
                exerciseDo.setChapterId(-1L);
            }
        }
        model.addAttribute("exercise_list", exerciseDoList);


        LessonChapterDo lessonChapterDo = lessonChapterDao.queryById(chapterId);
        model.addAttribute("lesson_chapter", lessonChapterDo);

        LessonDo lessonDo = lessonDao.queryById(lessonChapterDo.getLessonId());
        model.addAttribute("lesson", lessonDo);
        return "student/exercise";
    }

    @RequestMapping("/join")
    public String joinExercise(@RequestParam("id") Long exerciseId, Model model) {
        List<ProblemDo> problemDoList = problemDao.queryByObject(ProblemDo.TYPE.exercise.getVal(), exerciseId);
        model.addAttribute("problem_list", problemDoList);

        ExerciseDo exerciseDo = exerciseDao.queryById(exerciseId);
        model.addAttribute("exercise", exerciseDo);
        return "student/exercise_info";
    }
}
