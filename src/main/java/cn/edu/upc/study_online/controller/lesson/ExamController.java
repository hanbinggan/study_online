package cn.edu.upc.study_online.controller.lesson;

import cn.edu.upc.study_online.dao.dao.ExamDao;
import cn.edu.upc.study_online.dao.dao.LessonDao;
import cn.edu.upc.study_online.dao.dao.ProblemDao;
import cn.edu.upc.study_online.dao.object.ExamDo;
import cn.edu.upc.study_online.dao.object.LessonDo;
import cn.edu.upc.study_online.dao.object.ProblemDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
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

    @Autowired
    private ProblemDao problemDao;

    @RequestMapping("")
    public String exam(@RequestParam("id") Long lessonId, Model model){
        LessonDo lessonDo = lessonDao.queryById(lessonId);
        List<ExamDo> examDoList = examDao.queryByLesson(lessonId);
        model.addAttribute("lesson", lessonDo);
        model.addAttribute("exam_list", examDoList);
        return "problem/exam";
    }

    @RequestMapping("/add")
    public String add(@RequestParam("id") Long lessonId, Model model){
        LessonDo lessonDo = lessonDao.queryById(lessonId);
        model.addAttribute("lesson", lessonDo);
        return "problem/add_exam";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("name") String name,
                      @RequestParam("lessonId") Long lessonId,
                      @RequestParam("startTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date startTime,
                      @RequestParam("endTime")@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime){
        ExamDo examDo = new ExamDo();
        examDo.setLessonId(lessonId);
        examDo.setName(name);
        examDo.setStartTime(startTime);
        examDo.setEndTime(endTime);
        examDao.insert(examDo);
        return "redirect:/lesson/exam/info?id="+examDo.getId();
    }

    @RequestMapping("/info")
    public String info(@RequestParam("id") Long examId, Model model){
        ExamDo examDo = examDao.queryById(examId);
        model.addAttribute("exam", examDo);

        LessonDo lessonDo = lessonDao.queryById(examDo.getLessonId());
        model.addAttribute("lesson", lessonDo);
        List<ProblemDo> problemDoList = problemDao.queryByObject(ProblemDo.TYPE.exam.getVal(), examId);
        model.addAttribute("problem_list", problemDoList);
        return "problem/exam_info";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("name") String name,
                         @RequestParam("lessonId") Long lessonId,
                         @RequestParam("startTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date startTime,
                         @RequestParam("endTime")@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime,
                         @RequestParam("id") Long id){
        ExamDo examDo = new ExamDo();
        examDo.setId(id);
        examDo.setName(name);
        examDo.setLessonId(lessonId);
        examDo.setStartTime(startTime);
        examDo.setEndTime(endTime);
        examDao.update(examDo);
        return "redirect:/lesson/exam/info?id="+examDo.getId();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Long examId, @RequestParam("lesson_id") Long lessonId){
        examDao.delete(examId);
        problemDao.deleteByObjectType(examId,ProblemDo.TYPE.exam.getVal());
        return "redirect:/lesson/exam?id="+lessonId;
    }
}
