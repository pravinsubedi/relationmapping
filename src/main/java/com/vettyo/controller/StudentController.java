package com.vettyo.controller;

import com.vettyo.entity.Ad;
import com.vettyo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pravin on 2/17/2017.
 */
@Controller
public class StudentController {

    @Autowired
    SessionFactory sessionFactory;
    Session session;

    @Transactional
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String insertCategory(@RequestBody Student student) throws SQLException {
        session=sessionFactory.getCurrentSession();
        session.save(student);
        return "succesful";
    }


    @Transactional
    @RequestMapping(value = "student",method = RequestMethod.GET)
    @ResponseBody
    public List<Ad> getAllCategory()throws SQLException{
        session=sessionFactory.getCurrentSession();
        return session.createCriteria(Student.class).list();
    }
}
