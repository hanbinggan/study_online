package cn.edu.upc.study_online.controller;

import cn.edu.upc.study_online.dao.dao.LessonContentDao;
import cn.edu.upc.study_online.dao.object.FileDo;
import cn.edu.upc.study_online.dao.object.LessonContentDo;
import cn.edu.upc.study_online.service.FileService;
import cn.edu.upc.study_online.util.StringUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
    public String info(@RequestParam("id") Long id, Model model) {
        LessonContentDo lessonContentDo = lessonContentDao.queryById(id);
        model.addAttribute("lesson_content", lessonContentDo);
        FileDo fileDo = fileService.queryById(lessonContentDo.getFileId());
        String fileName = fileDo.getPath();
        if (fileDo.getType() == FileDo.TYPE.PDF.getVal()) {
            fileName = fileName.substring(0, fileName.lastIndexOf('.')) + ".pdf";
        }
        String contentType = StringUtil.getContentType(fileName);
        model.addAttribute("file_uri", fileName);
        model.addAttribute("file_type", contentType);
        return "lesson/lesson_content_info";
    }

//    @RequestMapping("/file")
//    public void file(@RequestParam("file_name") String fileName, HttpServletResponse response) throws IOException {
//        File file = new File(fileName);
//        MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();
//        String mimeType = mimetypesFileTypeMap.getContentType(file);
//
//        response.setHeader("Content-Type", mimeType);
//        response.setHeader("Content-Length", String.valueOf(file.length()));
//        response.setHeader("Content-Disposition", "attachment;filename=\""+file.getName()+"\"");
//        Files.copy(file.toPath(), response.getOutputStream());
//    }
//
//    @RequestMapping(value = "/files1", method = RequestMethod.GET)
//    public ResponseEntity<byte[]> testphoto(@RequestParam("file_name") String fileName) throws IOException {
//        InputStream in = new FileInputStream(new File(fileName));
//
//        final HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//
//        return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
//    }
//
//
//    @RequestMapping(value = "/files", method = RequestMethod.GET)
//    @ResponseBody
//    public FileSystemResource getFile(@RequestParam("file_name") String fileName) {
//        FileSystemResource fileSystemResource = new FileSystemResource(new File(fileName));
//        return new FileSystemResource(new File(fileName));
//    }
//
//
//    @RequestMapping(value = "/files2", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<InputStreamResource> downloadUserAvatarImage(@RequestParam("file_name") String fileName) throws FileNotFoundException {
//        File file = new File(fileName);
//        FileInputStream fileInputStream = new FileInputStream(file);
//        MimetypesFileTypeMap mimetypesFileTypeMap = new MimetypesFileTypeMap();
//        String mimeType = mimetypesFileTypeMap.getContentType(file);
//        return ResponseEntity.ok()
//                .contentLength(file.length())
//                .contentType(MediaType.parseMediaType(mimeType))
//                .body(new InputStreamResource(fileInputStream));
//    }


    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public void getFile(@RequestParam("file_name") String fileName, HttpServletResponse response) {
        try {
            String contentType = StringUtil.getContentType(fileName);
            File file = new File(fileName);
            InputStream is = new FileInputStream(file);
            response.setContentType(contentType);
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            throw new RuntimeException("IOError writing file to output stream");
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") Long id){
        LessonContentDo lessonContentDo = lessonContentDao.queryById(id);


        lessonContentDao.delete(id);
        return "redirect: /lesson/chapter/info?id=" + lessonContentDo.getLessonChapterId();
    }
}
