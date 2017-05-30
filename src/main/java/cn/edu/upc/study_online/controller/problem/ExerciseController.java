package cn.edu.upc.study_online.controller.problem;

import cn.edu.upc.study_online.dao.dao.ExamDao;
import cn.edu.upc.study_online.dao.dao.ExerciseDao;
import cn.edu.upc.study_online.dao.dao.LessonChapterDao;
import cn.edu.upc.study_online.dao.dao.ProblemDao;
import cn.edu.upc.study_online.dao.object.ExerciseDo;
import cn.edu.upc.study_online.dao.object.LessonChapterDo;
import cn.edu.upc.study_online.dao.object.ProblemDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by songqiaolin on 2017/5/28.
 */
@RequestMapping("/lesson/chapter/exercise")
@Controller
public class ExerciseController {
    @Autowired
    private LessonChapterDao lessonChapterDao;
    @Autowired
    private ExerciseDao exerciseDao;

    @Autowired
    private ExamDao examDao;

    @Autowired
    private ProblemDao problemDao;
    @RequestMapping("")
    public String exercise(@RequestParam("id") Long chapterId, Model model){
        LessonChapterDo lessonChapterDo = lessonChapterDao.queryById(chapterId);
        List<ExerciseDo> exerciseDoList = exerciseDao.queryByChapter(chapterId);
        model.addAttribute("exercise_list", exerciseDoList);
        model.addAttribute("lesson_chapter", lessonChapterDo);
        return "problem/exercise";
    }

    @RequestMapping("/add")
    public String add(@RequestParam("id") Long chapterId, Model model){
        ExerciseDo exerciseDo = new ExerciseDo();
        exerciseDo.setChapterId(chapterId);
        model.addAttribute("exercise", exerciseDo);
        return "problem/add_exercise";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("exercise") ExerciseDo exerciseDo, Model model){
        exerciseDao.insert(exerciseDo);
        return "redirect:/lesson/chapter/exercise/info?id="+exerciseDo.getId();
    }

    @RequestMapping("/info")
    public String exerciseInfo(@RequestParam("id") Long exerciseId, Model model){
        ExerciseDo exerciseDo = exerciseDao.queryById(exerciseId);
        model.addAttribute("exercise", exerciseDo);

        LessonChapterDo lessonChapterDo = lessonChapterDao.queryById(exerciseDo.getChapterId());
        model.addAttribute("lesson_chapter", lessonChapterDo);

        List<ProblemDo> problemDoList = problemDao.queryByObject(ProblemDo.TYPE.exercise.getVal(),
                exerciseId);
        model.addAttribute("problem_list", problemDoList);
        return "problem/exercise_info";
    }

    @RequestMapping("/update")
    public String update(@ModelAttribute("exercise") ExerciseDo exerciseDo){
        exerciseDao.update(exerciseDo);
        return "redirect:/lesson/chapter/exercise/info?id="+exerciseDo.getId();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Long exerciseId,
                         @RequestParam("chapter_id") Long chapterId){

        problemDao.deleteByObjectType(exerciseId, ProblemDo.TYPE.exercise.getVal());
        exerciseDao.delete(exerciseId);
        return "redirect: /lesson/chapter/exercise?id="+chapterId;
    }
}
