package cn.edu.upc.study_online.controller;

import cn.edu.upc.study_online.dao.dao.LessonContentDao;
import cn.edu.upc.study_online.dao.object.LessonContentDo;
import cn.edu.upc.study_online.service.FileService;
import cn.edu.upc.study_online.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by songqiaolin on 2017/5/23.
 */
@Controller
@RequestMapping("/lesson/content")
public class LessonContentController {
    @Autowired
    private LessonContentDao lessonContentDao;
    @Autowired
    private FileService fileService;

    @RequestMapping("/add")
    public String add(@RequestParam(value = "id") Long id, Model model) {
        LessonContentDo lessonContentDo = new LessonContentDo();
        lessonContentDo.setLessonChapterId(id);
        model.addAttribute("lesson_content", lessonContentDo);
        return "/lesson/add_content";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("lesson_content") LessonContentDo lessonContentDo,
                      @RequestParam("file") MultipartFile file) {
        try {
            Long fileId = fileService.saveFile(file);
            lessonContentDo.setFileId(fileId);
            lessonContentDao.insert(lessonContentDo);
        } catch (IOException e) {
            return "redirect:/lesson/content/add";
        }
        return "redirect: /lesson/chapter/info?id=" + lessonContentDo.getLessonChapterId();
    }

    @RequestMapping(value = "/info")
    public String info(@RequestParam("id") String id, Model model){
        return "";
    }
}
