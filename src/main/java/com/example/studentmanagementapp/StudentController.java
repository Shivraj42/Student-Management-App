package com.example.studentmanagementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;


    /**
     * get student --> request param regNo
     * @param regNo
     * @return
     */
    @GetMapping("/get")
    public Student getStudent(@RequestParam("q") int regNo){
        return studentService.getStudent(regNo);
    }


    /**
     * add Student --> request body
     * @param student
     * @return
     */
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }


    /**
     * update age --> Request param
     * @param regNo
     * @param age
     * @return
     */
    @PutMapping("/update-age")
    public Student updateAge(@RequestParam("id") int regNo,@RequestParam("age") int age){
        return  studentService.updateAge(regNo, age);
    }


    /**
     * Get a Student --> path variable
     * @param regNo
     * @return
     */
    @GetMapping("/get/{id}")
    public Student getStudentByPath(@PathVariable("id") int regNo){
        return studentService.getStudent(regNo);
    }


    /**
     * delete a student  --> request param
     * @param regNo
     * @return
     */
    @DeleteMapping("/delete")
    public String deleteStudentByParam(@RequestParam("id") int regNo){
        return studentService.deleteStudent(regNo);
    }


    /**
     * delete a student ---> path variable
     * @param regNo
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public String deleteStudentByPath(@PathVariable("id") int regNo){
        return studentService.deleteStudent(regNo);
    }


    /**
     * change course of a student (regNo, course)  ---> Both as request params
     * @param regNo
     * @param course
     * @return
     */
    @PutMapping("/update-course")
    public String updateCourseByBothParam(@RequestParam("id") int regNo, @RequestParam("course") String course){
       return studentService.updateCourse(regNo, course);
    }


    /**
     * change course --> One as request param, one as path variable
     * @param regNo  --> path
     * @param course --> param
     * @return
     */
    @PutMapping("/update-course-ip/{id}")
    public String updateCourseByPathAndParam2(@PathVariable("id") int regNo, @RequestParam("course") String course){
        return studentService.updateCourse(regNo, course);
    }


    /**
     * change course --> One as request param, one as path variable
     *
     * @param course --> path
     * @param regNo  --> param
     * @return
     */

    @PutMapping("/update-course-cp/{cour}")
    public String updateCourseByPathAndParam(@PathVariable("cour") String course, @RequestParam("id") int regNo ){
        return studentService.updateCourse(regNo, course);
    }


    /**
     * change course of a student  ----> Both as path variables
     * @param regNo
     * @param course
     * @return
     */
    @PutMapping("/update-course-by-path/{id}/{course}")
    public String updateCourseByBothPath(@PathVariable("id") int regNo, @PathVariable("course") String course){
        return studentService.updateCourse(regNo, course);
    }


    /**
     * change course and age ---> regNo as request param, entire student object as request body
     * @param regNo
     * @param student
     * @return
     */
    @PutMapping("/update-course-and-age")
    public String updateCourseAndAge(@RequestParam("id") int regNo, @RequestBody Student student){
        return studentService.updateCourseAndAge(regNo, student);
    }

}
