package com.example.springboot.learnjpaandhibernate.course;

import com.example.springboot.learnjpaandhibernate.course.Course;
import com.example.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.example.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.example.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS now", "Udemy"));
        repository.save(new Course(2, "Learn Azure now", "Udemy"));
        repository.save(new Course(3, "Learn GCP now", "Udemy"));

        repository.deleteById(1l);

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("Udemy"));
        System.out.println(repository.findByAuthor(""));
    }
}
