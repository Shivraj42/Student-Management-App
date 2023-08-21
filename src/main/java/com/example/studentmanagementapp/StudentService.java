package com.example.studentmanagementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;


    public Student getStudent(int regNo) {
        return studentRepository.getStudent(regNo);
    }

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Student updateAge(int regNo, int age) {
        return studentRepository.updateAge(regNo, age);
    }


    public String deleteStudent(int regNo) {
        return studentRepository.deleteStudent(regNo);
    }

    public String updateCourse(int regNo, String course) {
        return studentRepository.updateCourse(regNo, course);
    }

    public String updateCourseAndAge(int regNo, Student student) {
        studentRepository.updateCourse(regNo,student.getCourse());
        studentRepository.updateAge(regNo, student.getAge());
        return "Course and Age Updated Successfully";
    }
}

