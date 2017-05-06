/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.service;


import com.mycompany.rest.dao.Student;
import com.mycompany.rest.dao.StudentDAO;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author W208412665
 */
public class StudentController {

    @RequestMapping("/searchByID")
   
    public List<Student> student(@RequestParam(value = "id", defaultValue = "0") int id) {
        StudentDAO stdao = new StudentDAO();
        List<Student> lst = stdao.getAllStudents();
        return lst;
    }

}
