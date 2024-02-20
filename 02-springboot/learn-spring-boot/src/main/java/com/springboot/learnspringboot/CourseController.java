package com.springboot.learnspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "Learn AWS", "Udemy"),
                new Course(2, "Learn DevOps", "Udemy"),
                new Course(3, "Learn Java", "Udemy"),
                new Course(4, "Learn Azure", "Udemy"),
                new Course(5, "Learn GCP", "Udemy")
        );
    }
}
