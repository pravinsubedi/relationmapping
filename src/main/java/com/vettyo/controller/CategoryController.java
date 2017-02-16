package com.vettyo.controller;

import com.vettyo.entity.Category;
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
 * Created by pravin on 2/15/2017.
 */
@Controller
public class CategoryController {


    @Autowired
    SessionFactory sessionFactory;
    Session session;

    @Transactional
    @RequestMapping(value = "category",method = RequestMethod.POST)
    @ResponseBody
    public String insertCategory(@RequestBody Category category) throws SQLException{
        session=sessionFactory.getCurrentSession();
        session.save(category);
        return "succesful";
    }



    @Transactional
    @RequestMapping(value = "category",method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getAllCategory()throws SQLException{
        session=sessionFactory.getCurrentSession();
        return session.createCriteria(Category.class).list();
    }
}
