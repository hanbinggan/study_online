package cn.edu.upc.study_online.controller.lesson;

import cn.edu.upc.study_online.dao.object.StudyStarScoreDo;
import cn.edu.upc.study_online.service.StudyStarScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by songqiaolin on 2017/5/28.
 */
@RequestMapping("/lesson/study_star")
@Controller
public class StudyStarController {
    @Autowired
    private StudyStarScoreService studyStarScoreService;

    @RequestMapping("")
    public String starStar(@RequestParam("id") Long lessonId, Model model) {
        StudyStarScoreDo study = studyStarScoreService
                .getStarScore(lessonId, StudyStarScoreDo.TYPE.study.getVal());
        StudyStarScoreDo exercise = studyStarScoreService
                .getStarScore(lessonId, StudyStarScoreDo.TYPE.exercise.getVal());
        StudyStarScoreDo exam = studyStarScoreService
                .getStarScore(lessonId, StudyStarScoreDo.TYPE.exam.getVal());

        model.addAttribute("study", study);
        model.addAttribute("exercise", exercise);
        model.addAttribute("exam", exam);
        return "lesson/study_star";
    }

    @RequestMapping(value = "/update"
            , params = {"study_score", "exercise_score", "exam_score", "lesson_id"}
            , method = RequestMethod.POST)
    public String update(@RequestParam("study_score") Integer studyScore,
                         @RequestParam("exercise_score") Integer exerciseScore,
                         @RequestParam("exam_score") Integer examScore,
                         @RequestParam("lesson_id") Long lessonId) {
        studyStarScoreService.setStarScore(lessonId
                , StudyStarScoreDo.TYPE.study.getVal(), studyScore);
        studyStarScoreService.setStarScore(lessonId
                , StudyStarScoreDo.TYPE.exercise.getVal(), exerciseScore);
        studyStarScoreService.setStarScore(lessonId
                , StudyStarScoreDo.TYPE.exam.getVal(), examScore);

        return "redirect:/lesson/study_star?id=" + lessonId;
    }
}
