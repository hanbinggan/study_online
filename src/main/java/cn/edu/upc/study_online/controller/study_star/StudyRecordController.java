package cn.edu.upc.study_online.controller.study_star;

import cn.edu.upc.study_online.dao.dao.*;
import cn.edu.upc.study_online.dao.object.*;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

/**
 * Created by songqiaolin on 2017/5/30.
 */
@Controller
@RequestMapping("/study/record")
public class StudyRecordController {
    @Autowired
    private StudyRecordDao studyRecordDao;

    @Autowired
    private LessonDao lessonDao;

    @Autowired
    private LessonChapterDao lessonChapterDao;

    @Autowired
    private LessonContentDao lessonContentDao;

    @Autowired
    private ExamDao examDao;

    @Autowired
    private ExerciseDao exerciseDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private StudyStarScoreDao studyStarScoreDao;

    @Autowired
    private StudentLessonRefDao studentLessonRefDao;

    @RequestMapping("")
    public String record(@RequestParam("id") Long studentId,
                         @RequestParam("lesson_id") Long lessonId,
                         Model model) {
        List<Map<String, Object>> lessonRecords = new ArrayList<>();
        List<Map<String, Object>> studyRecords = new ArrayList<>();
        List<Map<String, Object>> examRecords = new ArrayList<>();
        List<Map<String, Object>> exerciseRecords = new ArrayList<>();

        Long totalScore;
        Long studyScore = 0L;
        Long exerciseScore = 0L;
        Long examScore = 0L;

        List<StudyRecordDo> studyRecordDoList = studyRecordDao.queryByLessonStudent(lessonId, studentId);
        for (StudyRecordDo studyRecordDo : studyRecordDoList) {
            Map<String, Object> lessonRecord = new HashedMap();
            lessonRecord.put("object_id", studyRecordDo.getId());
            lessonRecord.put("study_star_score", studyRecordDo.getStudyStarScore());
            lessonRecord.put("create_time", studyRecordDo.getCreateTime());
            String name = "";
            String url = "#";
            String type;
            if (studyRecordDo.getType() == StudyStarScoreDo.TYPE.study.getVal()) {
                LessonContentDo lessonContentDo = lessonContentDao.queryById(studyRecordDo.getObjectId());
                if (lessonContentDo != null) {
                    LessonChapterDo lessonChapterDo = lessonChapterDao.queryById(lessonContentDo.getLessonChapterId());
                    if (lessonChapterDo != null) {
                        name += lessonChapterDo.getName() + "--";
                    }
                    name += lessonContentDo.getName();
                    url = "/lesson/content/info?id=" + lessonContentDo.getId();
                }
                type = "学习";
                studyRecords.add(lessonRecord);
                studyScore += studyRecordDo.getStudyStarScore();

            } else if (studyRecordDo.getType() == StudyStarScoreDo.TYPE.exercise.getVal()) {
                ExerciseDo exerciseDo = exerciseDao.queryById(studyRecordDo.getObjectId());
                if (exerciseDo != null) {
                    name = exerciseDo.getName();
                    url = "/student/lesson/problem/answer?id=" + exerciseDo.getId() + "&type=exercise";
                }
                exerciseRecords.add(lessonRecord);
                type = "练习";
                exerciseScore += studyRecordDo.getStudyStarScore();
            } else {
                ExamDo examDo = examDao.queryById(studyRecordDo.getObjectId());
                if (examDo != null) {
                    name = examDo.getName();
                    url = "/student/lesson/problem/answer?id=" + examDo.getId() + "&type=exam";
                }
                examRecords.add(lessonRecord);
                type = "考试";
                examScore += studyRecordDo.getStudyStarScore();
            }
            lessonRecord.put("name", name);
            lessonRecord.put("url", url);
            lessonRecord.put("type", type);
            lessonRecords.add(lessonRecord);
        }
        StudyStarScoreDo studyStarScoreDo = studyStarScoreDao
                .queryByLessonType(lessonId, StudyStarScoreDo.TYPE.study.getVal());
        StudyStarScoreDo exerciseStarScoreDo = studyStarScoreDao
                .queryByLessonType(lessonId, StudyStarScoreDo.TYPE.exercise.getVal());
        StudyStarScoreDo examStarScoreDo = studyStarScoreDao
                .queryByLessonType(lessonId, StudyStarScoreDo.TYPE.exam.getVal());

        totalScore = (long) (1.0 * (studyScore * studyStarScoreDo.getPrecent() +
                exerciseScore * exerciseStarScoreDo.getPrecent() +
                examScore * examStarScoreDo.getPrecent()) /
                (studyStarScoreDo.getPrecent() + exerciseStarScoreDo.getPrecent() +
                        examStarScoreDo.getPrecent()));

        LessonDo lessonDo = lessonDao.queryById(lessonId);
        model.addAttribute("lesson", lessonDo);

        StudentDo studentDo = studentDao.queryById(studentId);
        model.addAttribute("student", studentDo);

        model.addAttribute("lesson_record_list", lessonRecords);
        model.addAttribute("study_record_list", studyRecords);
        model.addAttribute("exercise_record_list", exerciseRecords);
        model.addAttribute("exam_record_list", examRecords);

        model.addAttribute("study_score", studyScore);
        model.addAttribute("exam_score", examScore);
        model.addAttribute("exercise_score", examScore);

        model.addAttribute("study_precent", studyStarScoreDo.getPrecent());
        model.addAttribute("exam_precent", examStarScoreDo.getPrecent());
        model.addAttribute("exercise_precent", exerciseStarScoreDo.getPrecent());

        model.addAttribute("total_score", totalScore);
        return "study_star/study_record";
    }

    @RequestMapping("top")
    public String top(@RequestParam("id") Long lessonId, Model model) {
        List<Map<String, Object>> studentList = new ArrayList<>();

        StudyStarScoreDo studyStarScoreDo = studyStarScoreDao
                .queryByLessonType(lessonId, StudyStarScoreDo.TYPE.study.getVal());
        StudyStarScoreDo exerciseStarScoreDo = studyStarScoreDao
                .queryByLessonType(lessonId, StudyStarScoreDo.TYPE.exercise.getVal());
        StudyStarScoreDo examStarScoreDo = studyStarScoreDao
                .queryByLessonType(lessonId, StudyStarScoreDo.TYPE.exam.getVal());

        List<StudentLessonRefDo> studentLessonRefDoList = studentLessonRefDao
                .queryByLessonStatus(lessonId, StudentLessonRefDo.STATUS.applied.getValue());
        for (StudentLessonRefDo studentLessonRefDo : studentLessonRefDoList) {
            Map<String, Object> student = new HashedMap();
            studentList.add(student);

            Long studentId = studentLessonRefDo.getStudentId();
            Long totalScore = 0L;
            Long studyScore = 0L;
            Long exerciseScore = 0L;
            Long examScore = 0L;

            List<StudyRecordDo> studyRecordDoList = studyRecordDao.queryByLessonStudent(lessonId, studentId);
            for (StudyRecordDo studyRecordDo : studyRecordDoList) {
                if (studyRecordDo.getType() == StudyStarScoreDo.TYPE.study.getVal()) {
                    studyScore += studyRecordDo.getStudyStarScore();

                } else if (studyRecordDo.getType() == StudyStarScoreDo.TYPE.exercise.getVal()) {
                    exerciseScore += studyRecordDo.getStudyStarScore();
                } else {
                    examScore += studyRecordDo.getStudyStarScore();
                }
            }


            totalScore = (long) (1.0 * (studyScore * studyStarScoreDo.getPrecent() +
                    exerciseScore * exerciseStarScoreDo.getPrecent() +
                    examScore * examStarScoreDo.getPrecent()) /
                    (studyStarScoreDo.getPrecent() + exerciseStarScoreDo.getPrecent() +
                            examStarScoreDo.getPrecent()));
            StudentDo studentDo =studentDao.queryById(studentId);
            if(studentDo != null){
                student.put("name", studentDo.getName());
                student.put("student_id", studentId);
            }
            student.put("score", totalScore);
        }

        studentList.sort(new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Long s1 = (Long)o1.get("score");
                Long s2 = (Long)o2.get("score");
                return (int)(s2-s1);
            }
        });

        int cnt = 0;
        Long last_score = -1L;
        for(Map<String,Object> student: studentList){
            Long score = (Long) student.get("score");
            if (!last_score.equals(score)){
                cnt++;
            }
            last_score = score;
            student.put("order_number", cnt);
        }
        LessonDo lessonDo = lessonDao.queryById(lessonId);
        model.addAttribute("student_list", studentList);
        model.addAttribute("lesson", lessonDo);
        return "study_star/student_order";
    }
}
