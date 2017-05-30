package cn.edu.upc.study_online.controller.student;

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
 * Created by songqiaolin on 2017/5/30.
 */
@RequestMapping("/student/lesson/problem")
@Controller
public class StudentProblemController {
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

    @Autowired
    private ExamDao examDao;

    @RequestMapping(value = "/answer/{objectId}/{type}", method = RequestMethod.POST)
    public String answer(@PathVariable Long objectId,
                         @PathVariable String type,
                         @RequestParam("answer_list") List<String> answerList,
                         HttpServletRequest request) {
        Map<String, Object> user = (Map<String, Object>) request.getSession().getAttribute("user");
        if (user == null || !"student".equals((String) user.get("role"))) {
            return "redirect:/login";
        }

        Long studentId = (Long) user.get("id");

        Integer problemType = ProblemDo.TYPE.exercise.getVal();
        Integer studyRecordType = StudyStarScoreDo.TYPE.exercise.getVal();
        Long lessonId;
        String url = "";
        if ("exam".equals(type)) {
            problemType = ProblemDo.TYPE.exam.getVal();
            studyRecordType = StudyStarScoreDo.TYPE.exam.getVal();
            ExamDo examDo = examDao.queryById(objectId);
            lessonId = examDo.getLessonId();
            url = "redirect:/student/lesson/problem/answer?id=" + examDo.getId() + "&type=" + type;
        } else {
            ExerciseDo exerciseDo = exerciseDao.queryById(objectId);
            LessonChapterDo lessonChapterDo = lessonChapterDao.queryById(exerciseDo.getChapterId());
            lessonId = lessonChapterDo.getLessonId();
            url = "redirect:/student/lesson/problem/answer?id=" + exerciseDo.getId() + "&type=" + type;
        }

        List<ProblemDo> problemDoList = problemDao.queryByObject(problemType, objectId);

        int totalScore = 0;

        for (int i = 0; i < problemDoList.size(); i++) {
            String answer = answerList.get(i);
            ProblemDo problemDo = problemDoList.get(i);

            AnswerDo answerDo = new AnswerDo();
            answerDo.setObjectId(objectId);
            answerDo.setType(problemType);
            answerDo.setContent(answer);
            answerDo.setStudentId(studentId);
            answerDo.setProblemId(problemDo.getId());

            Integer score = 0;
            if (problemDo.getAnswer().trim().equals(answer.trim())) {
                score = problemDo.getScore();
                totalScore += score;
            }
            answerDo.setScore(score);
            answerDao.insert(answerDo);
        }


        StudyRecordDo studyRecordDo = new StudyRecordDo();
        studyRecordDo.setLessonId(lessonId);
        studyRecordDo.setStudentId(studentId);
        studyRecordDo.setType(studyRecordType);
        studyRecordDo.setObjectId(objectId);
        studyRecordDo.setStudyStarScore((long) totalScore);
        studyRecordDao.insert(studyRecordDo);
        return url;
    }

    @RequestMapping("/answer")
    public String showAnswer(@RequestParam("id") Long objectId,
                             @RequestParam("type") String type,
                             Model model) {
        List<Map<String, Object>> answerList = new ArrayList<>();
        Integer problemType = ProblemDo.TYPE.exercise.getVal();
        String name;
        Long toId;
        if ("exam".equals(type)) {
            problemType = ProblemDo.TYPE.exam.getVal();
            ExamDo examDo = examDao.queryById(objectId);
            name = examDo.getName();
            toId = examDo.getLessonId();
//            model.addAttribute("exam", examDo);
        } else {
            ExerciseDo exerciseDo = exerciseDao.queryById(objectId);
            name = exerciseDo.getName();
            toId = exerciseDo.getChapterId();
//            model.addAttribute("exercise", exerciseDo);
        }
        model.addAttribute("name", name);
        model.addAttribute("type", type);
        model.addAttribute("to_id", toId);
        List<ProblemDo> problemDoList = problemDao.queryByObject(problemType, objectId);
        Long totalScore = 0L;
        Long studentScore = 0L;
        for (ProblemDo problemDo : problemDoList) {
            Map<String, Object> answer = new HashMap<>();
            answer.put("order_number", problemDo.getOrderNumber());
            answer.put("problem", problemDo.getContent());
            answer.put("origin_answer", problemDo.getAnswer());
            answer.put("score", problemDo.getScore());
            AnswerDo answerDo = answerDao.queryByProblem(problemDo.getId());
            answer.put("student_answer", answerDo.getContent());
            answer.put("student_score", answerDo.getScore());
            answer.put("problem_id", answerDo.getProblemId());
            answerList.add(answer);
            totalScore += problemDo.getScore();
            studentScore += answerDo.getScore();
        }
        model.addAttribute("answer_list", answerList);
        model.addAttribute("total_score", totalScore);
        model.addAttribute("student_score", studentScore);
        return "student/answer_info";
    }
}
