package javaspringcourse.demo.controller;

import javaspringcourse.demo.exceptions.StudentNotFoundException;
import javaspringcourse.demo.model.Student;
import javaspringcourse.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

// @CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "http://localhost:8081" })
@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/students/{studentId}")
    public EntityModel<Student> getStudent(@PathVariable int studentId){
        Student student = studentsService.findById(studentId);

        if(student == null){
            throw  new StudentNotFoundException("Student not found");
        }

        EntityModel<Student> resource = EntityModel.of(student);

        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).getAllStudents());

        resource.add(linkTo.withRel("all-students"));

        return resource;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentsService.findAll();
    }

    @PostMapping("/students")
    public String createStudent(@Valid @RequestBody Student student){
        Student savedStudent = studentsService.save(student);

        if(savedStudent != null){
            return "Success";
        }

        return null;
    }
}
