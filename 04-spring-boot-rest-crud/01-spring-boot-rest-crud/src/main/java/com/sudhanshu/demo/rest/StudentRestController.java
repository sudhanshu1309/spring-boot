package com.sudhanshu.demo.rest;

import com.sudhanshu.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data...only once!
    @PostConstruct
    public void loadStudents() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Sudhanshu", "Tripathi"));
        theStudents.add(new Student("Satyam", "Mani"));
        theStudents.add(new Student("Divyansh", "Kushwaha"));
    }

    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // define endpoint for "student/{studentId}" - return a student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // just index into the list

        // check the studentId against the list size
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student Id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }

}
