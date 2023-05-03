package lesson_19.controller;

import lesson_19.domain.FileMultipart;
import lesson_19.domain.Student;
import lesson_19.dto.StudentDto;
import lesson_19.services.FileMultipartService;
import lesson_19.services.StudentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

import static lesson_19.utils.StudentDtoUtil.studentDtoConvert;

@Controller
public class StudentController {
    private final StudentService studentService;
    private final FileMultipartService multipartService;

    public StudentController(StudentService studentService, FileMultipartService multipartService) {
        this.studentService = studentService;
        this.multipartService = multipartService;
    }

    @GetMapping("/")
    public String init(HttpServletRequest req) {
        req.setAttribute("mode", "S_REGISTRATION");
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute StudentDto studentDto,
                       @RequestParam("file") MultipartFile file, HttpServletRequest req, Model model) {
        try {
            // Save the file to the database
            Student student = studentDtoConvert(studentDto);
            FileMultipart fileMultipart = new FileMultipart();
            fileMultipart.setFileName(file.getOriginalFilename());
            fileMultipart.setContentType(file.getContentType());
            fileMultipart.setData(file.getBytes());
            multipartService.save(fileMultipart);
            student.setFile(fileMultipart);
            studentService.save(student);
            req.setAttribute("mode", "S_SUCCESS");
            model.addAttribute("file", fileMultipart);
            model.addAttribute("savedStudent", student);
        } catch (Exception e) {
            req.setAttribute("mode", "S_ERROR");
        }
        return "index";
    }

    @GetMapping("/photo/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id) throws FileNotFoundException {
        FileMultipart file = multipartService.getFile(id);
        if (file != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(file.getContentType()));
            return new ResponseEntity<>(file.getData(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
