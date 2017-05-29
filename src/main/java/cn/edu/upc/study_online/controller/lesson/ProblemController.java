package cn.edu.upc.study_online.controller.lesson;

import cn.edu.upc.study_online.dao.dao.ExamDao;
import cn.edu.upc.study_online.dao.dao.ExerciseDao;
import cn.edu.upc.study_online.dao.dao.ProblemDao;
import cn.edu.upc.study_online.dao.object.ExamDo;
import cn.edu.upc.study_online.dao.object.ExerciseDo;
import cn.edu.upc.study_online.dao.object.ProblemDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by songqiaolin on 2017/5/28.
 */
@RequestMapping("/lesson/problem")
@Controller
public class ProblemController {
    @Autowired
    private ProblemDao problemDao;

    @Autowired
    private ExamDao examDao;

    @Autowired
    private ExerciseDao exerciseDao;


    @RequestMapping("/add")
    public String add(@RequestParam("id") Long id,
                      @RequestParam("type") String type,
                      Model model){
        ProblemDo problemDo = new ProblemDo();
        problemDo.setObjectId(id);
        if("exercise".equals(type)){
            ExerciseDo exerciseDo = exerciseDao.queryById(id);
            model.addAttribute("exercise", exerciseDo);
            problemDo.setType(ProblemDo.TYPE.exercise.getVal());
        }else{
            ExamDo examDo = examDao.queryById(id);
            model.addAttribute("exam", examDo);
            problemDo.setType(ProblemDo.TYPE.exam.getVal());
        }
        model.addAttribute("problem", problemDo);
        return "problem/add_problem";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("problem") ProblemDo problemDo){
        problemDao.insert(problemDo);
        return "redirect:/lesson/problem/info?id="+problemDo.getId();
    }


    @RequestMapping("/info")
    public String info(@RequestParam("id") Long problemId, Model model){
        ProblemDo problemDo = problemDao.queryById(problemId);
        ExerciseDo exerciseDo = exerciseDao.queryById(problemDo.getObjectId());
        model.addAttribute("problem", problemDo);
        model.addAttribute("exercise", exerciseDo);
        return "problem/problem_info";
    }

    @RequestMapping("update")
    public String update(@ModelAttribute("problem") ProblemDo problemDo){
        problemDao.update(problemDo);
        return "redirect:/lesson/problem/info?id="+problemDo.getId();
    }

    @RequestMapping("delete")
    public String delete(@RequestParam("id") Long problemId,
                         @RequestParam("exercise_id") Long exerciseId){
        problemDao.delete(problemId);
        return "redirect:/lesson/chapter/exercise/info?id="+exerciseId;
    }
}