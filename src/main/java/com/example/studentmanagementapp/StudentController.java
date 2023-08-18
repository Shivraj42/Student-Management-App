package com.example.studentmanagementapp;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class StudentController {
    HashMap<Integer, Student> db= new HashMap<>();


    /**
     * get student --> request param regNo
     * @param regNo
     * @return
     */
    @GetMapping("/get")
    public Student getStudent(@RequestParam("q") int regNo){
        return db.get(regNo);
    }


    /**
     * add Student --> request body
     * @param student
     * @return
     */
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        db.put(student.getRegNo(), student);
        return "Student added Successfully!!!";
    }


    /**
     * update age --> Request param
     * @param regNo
     * @param age
     * @return
     */
    @PutMapping("/update-age")
    public Student updateAge(@RequestParam("id") int regNo,@RequestParam("age") int age){
        db.get(regNo).setAge(age);
        return db.get(regNo);
    }


    /**
     * Get a Student --> path variable
     * @param regNo
     * @return
     */
    @GetMapping("/get/{id}")
    public Student getStudentByPath(@PathVariable("id") int regNo){
        return db.get(regNo);
    }


    /**
     * delete a student  --> request param
     * @param regNo
     * @return
     */
    @DeleteMapping("/delete")
    public String deleteStudentByParam(@RequestParam("id") int regNo){
        db.remove(regNo);
        return "Student Deleted Successfully!!!";
    }


    /**
     * delete a student ---> path variable
     * @param regNo
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public String deleteStudentByPath(@PathVariable("id") int regNo){
        db.remove(regNo);
        return "Student Deleted Successfully!!!";
    }


    /**
     * change course of a student (regNo, course)  ---> Both as request params
     * @param regNo
     * @param course
     * @return
     */
    @PutMapping("/update-course")
    public String updateCourseByBothParam(@RequestParam("id") int regNo, @RequestParam("course") String course){
        db.get(regNo).setCourse(course);
        return "Course Updated Successfully!!!";
    }




    /**
     * change course of a student  ----> Both as path variables
     * @param regNo
     * @param course
     * @return
     */
    @PutMapping("/update-course/{id}/{course}")
    public String updateCourseByBothPath(@PathVariable("id") int regNo, @PathVariable("course") String course){
        db.get(regNo).setCourse(course);
        return "Course Updated Successfully!!!";
    }




    /**
     * change course --> One as request param, one as path variable
     * @param regNo  --> path
     * @param course --> param
     * @return
     */
    @PutMapping("/update-course/{id}")
    public String updateCourseByPathAndParam2(@PathVariable("id") int regNo, @RequestParam("course") String course){
        db.get(regNo).setCourse(course);
        return "Course Updated Successfully!!!";
    }


    /**
     * change course --> One as request param, one as path variable
     *
     * @param course --> path
     * @param regNo  --> param
     * @return
     */
    @PutMapping("/update-course-p/{cour}")
    public String updateCourseByPathAndParam(@PathVariable("cour") String course, @RequestParam("id") int regNo ){
        db.get(regNo).setCourse(course);
        return "Course Updated Successfully!!!";
    }


    /**
     * change course and age ---> regNo as request param, entire student object as request body
     * @param regNo
     * @param student
     * @return
     */
    @PutMapping("/update-course-and-age")
    public String updateCourseAndAge(@RequestParam("id") int regNo, @RequestBody Student student){
        db.get(regNo).setCourse(student.getCourse());
        db.get(regNo).setAge(student.getAge());
        return "Course and Age Updated Successfully!!!";
    }

}
