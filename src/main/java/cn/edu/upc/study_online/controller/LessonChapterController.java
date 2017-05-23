package cn.edu.upc.study_online.controller;

import cn.edu.upc.study_online.dao.dao.LessonChapterDao;
import cn.edu.upc.study_online.dao.object.LessonChapterDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by songqiaolin on 2017/5/23.
 */
@Controller
@RequestMapping("/lesson/chapter")
public class LessonChapterController {
    @Autowired
    private LessonChapterDao lessonChapterDao;
    @RequestMapping(value = "/add")
    public String add(@RequestParam(value = "lesson_id") Long lessonId, Model model){
        LessonChapterDo lessonChapterDo = new LessonChapterDo();
        lessonChapterDo.setLessonId(lessonId);
        model.addAttribute("lesson_chapter", lessonChapterDo);
        return "lesson/add_lesson_chapter";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute(value = "lessonChapter") LessonChapterDo lessonChapterDo){
        lessonChapterDao.insert(lessonChapterDo);
        return "redirect:/lesson/info?id="+lessonChapterDo.getLessonId();
    }

    @RequestMapping(value = "/info")
    public String info(@RequestParam(value = "id") Long id, Model model){
        LessonChapterDo lessonChapterDo = lessonChapterDao.queryById(id);
        model.addAttribute("lesson_chapter", lessonChapterDo);
        return "/lesson/lesson_chapter_info";
    }

    @RequestMapping(value = "/update")
    public String update(@ModelAttribute("lesson_chapter") LessonChapterDo lessonChapterDo){
        lessonChapterDao.update(lessonChapterDo);
        return "redirect:/lesson/chapter/info?id="+lessonChapterDo.getId();
    }
}
