/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.service;

import com.mycompany.rest.dao.Student;
import com.mycompany.rest.dao.StudentDAO;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author W208412665
 */
@RestController
public class GreetingController implements ErrorController{

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final String PATH = "/error";
    
    @Autowired
    StudentDAO studentDAO;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
    
    
    @RequestMapping("/students")
    public List<Student> student() {
        
        return studentDAO.getAllStudents();
    }
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"service-springConfig.xml"});
        
        StudentDAO stdDAO = (StudentDAO) context.getBean("studentDAO");
        System.out.println(stdDAO.getAllStudents());
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }


}
