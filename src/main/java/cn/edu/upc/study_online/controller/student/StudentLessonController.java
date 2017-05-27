package cn.edu.upc.study_online.controller.student;

import cn.edu.upc.study_online.controller.vo.LessonVo;
import cn.edu.upc.study_online.dao.dao.LessonChapterDao;
import cn.edu.upc.study_online.dao.dao.LessonContentDao;
import cn.edu.upc.study_online.dao.dao.LessonDao;
import cn.edu.upc.study_online.dao.dao.StudentLessonRefDao;
import cn.edu.upc.study_online.dao.object.*;
import cn.edu.upc.study_online.service.FileService;
import cn.edu.upc.study_online.service.StudentLessonRefService;
import cn.edu.upc.study_online.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by songqiaolin on 2017/5/27.
 */
@Controller
@RequestMapping("/student")
public class StudentLessonController {
    @Autowired
    private StudentLessonRefService studentLessonRefService;

    @Autowired
    private StudentLessonRefDao studentLessonRefDao;

    @Autowired
    private LessonChapterDao lessonChapterDao;

    @Autowired
    private LessonContentDao lessonContentDao;

    @Autowired
    private FileService fileService;

    @Autowired
    private LessonDao lessonDao;

    @RequestMapping("/lesson")
    public String myLesson(Model model, HttpServletRequest request) {
        Map<String, Object> user = (Map<String, Object>) request.getSession().getAttribute("user");
        if (user == null || !"student".equals((String) user.get("role"))) {
            return "redirect:/login";
        }

        Long id = (Long) user.get("id");
        List<LessonVo> applyingLesson = studentLessonRefService
                .queryLessonByStudentStatus(id, StudentLessonRefDo.STATUS.applying.getValue());
        List<LessonVo> appliedLesson = studentLessonRefService
                .queryLessonByStudentStatus(id, StudentLessonRefDo.STATUS.applied.getValue());
        List<LessonVo> finishedLesson = studentLessonRefService
                .queryLessonByStudentStatus(id, StudentLessonRefDo.STATUS.finished.getValue());
        List<LessonVo> rejectLesson = studentLessonRefService
                .queryLessonByStudentStatus(id, StudentLessonRefDo.STATUS.reject.getValue());
        model.addAttribute("applying_lesson", applyingLesson);
        model.addAttribute("applied_lesson", appliedLesson);
        model.addAttribute("finished_lesson", finishedLesson);
        model.addAttribute("reject_lesson", rejectLesson);
        return "/student/my_lesson";
    }

    @RequestMapping("/lesson/apply")
    public String applyingLesson(@RequestParam("lesson_id") Long lessonId, HttpServletRequest request) {
        Map<String, Object> user = (Map<String, Object>) request.getSession().getAttribute("user");
        if (user == null || !"student".equals((String) user.get("role"))) {
            return "redirect:/login";
        }

        Long id = (Long) user.get("id");

        StudentLessonRefDo studentLessonRefDo = studentLessonRefDao.queryByStudentLesson(id, lessonId);
        if (studentLessonRefDo == null) {
            studentLessonRefDo = new StudentLessonRefDo();
            studentLessonRefDo.setStudentId(id);
            studentLessonRefDo.setLessonId(lessonId);
            studentLessonRefDo.setStatus(StudentLessonRefDo.STATUS.applying.getValue());
            studentLessonRefDao.insert(studentLessonRefDo);
        } else if (studentLessonRefDo.getStatus() != StudentLessonRefDo.STATUS.applied.getValue()
                && studentLessonRefDo.getStatus() != StudentLessonRefDo.STATUS.finished.getValue()) {
            studentLessonRefDo.setStatus(StudentLessonRefDo.STATUS.applying.getValue());
            studentLessonRefDao.update(studentLessonRefDo);
        }
        return "redirect:/student/lesson";
    }

    @RequestMapping("/lesson/info")
    public String info(@RequestParam("id") Long id, Model model) {
        LessonDo lessonDo = lessonDao.queryById(id);
        model.addAttribute("lesson", lessonDo);
        List<LessonChapterDo> lessonChapterDoList = lessonChapterDao.queryByLesson(id);
        model.addAttribute("lesson_chapter", lessonChapterDoList);
        return "student/lesson_chapter";
    }

    @RequestMapping("/lesson/content")
    public String content(@RequestParam("id") Long chapterId, Model model) {
        LessonChapterDo lessonChapterDo = lessonChapterDao.queryById(chapterId);
        List<LessonContentDo> lessonContentDoList = lessonContentDao.queryByLessonChapter(chapterId);
        model.addAttribute("lesson_content", lessonContentDoList);
        model.addAttribute("lesson_chapter", lessonChapterDo);
        return "student/lesson_content";
    }

    @RequestMapping("/lesson/content/info")
    public String contentInfo(@RequestParam("id") Long contentId, Model model) {
        LessonContentDo lessonContentDo = lessonContentDao.queryById(contentId);
        model.addAttribute("lesson_content", lessonContentDo);

        FileDo fileDo = fileService.queryById(lessonContentDo.getFileId());
        String fileName = fileDo.getPath();
        if (fileDo.getType() == FileDo.TYPE.PDF.getVal()) {
            fileName = fileName.substring(0, fileName.lastIndexOf('.')) + ".pdf";
        }
        String contentType = StringUtil.getContentType(fileName);
        model.addAttribute("file_uri", fileName);
        model.addAttribute("file_type", contentType);

        //todo exercise
        //todo study star
        //todo note
        return "student/content_info";
    }
}
