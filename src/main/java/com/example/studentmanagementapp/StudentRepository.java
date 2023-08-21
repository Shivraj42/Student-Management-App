package com.example.studentmanagementapp;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class StudentRepository  {
    HashMap<Integer, Student> db= new HashMap<>();

    public Student getStudent(int regNo) {
        return db.get(regNo);
    }

    public String addStudent(Student student) {
        db.put(student.getRegNo(), student);
        return "Student added Successfully!!!";
    }

    public Student updateAge(int regNo, int age) {
        db.get(regNo).setAge(age);
        return db.get(regNo);
    }

    public String deleteStudent(int regNo) {
        db.remove(regNo);
        return "Student Deleted Successfully!!!";
    }

    public String updateCourse(int regNo, String course) {
        db.get(regNo).setCourse(course);
        return "Course Updated Successfully!!!";
    }
}
