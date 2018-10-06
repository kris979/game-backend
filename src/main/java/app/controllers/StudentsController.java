package app.controllers;

import app.data.CardsRepository;
import app.data.StudentRepository;
import app.model.Card;
import app.model.Student;
import app.services.BoardServices;
import app.shortestPath.Cell;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping("/api")
public class StudentsController {

    private StudentRepository studentRepository;

    @Autowired
    public StudentsController(StudentRepository studentRepository){
        super();

        this.studentRepository = studentRepository;

    }


    @RequestMapping(value = "/h2/students", method = RequestMethod.GET)
    public List<Student> students() {
        this.studentRepository.save(new Student("kris", "123"));
        this.studentRepository.save(new Student("aga", "1233"));
//        Iterable<Student> all = this.studentRepository.findAll();
//        all.forEach(student -> System.out.println(student));
        return Lists.newArrayList(studentRepository.findAll());
    }

    //localhost:8080/swagger-ui.html
//    http://localhost:8080/v2/api-docs
//    http://localhost:8080/swagger-ui.html#/
}
