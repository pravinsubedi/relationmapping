package com.vettyo.controller;

import com.vettyo.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "updatecategory/{cid}",method = RequestMethod.PUT)
    @ResponseBody
    public String updateCategory(@RequestBody Category category,@PathVariable("cid") int cid) throws SQLException{
        Category category1=new Category();
        session=sessionFactory.getCurrentSession();
        category1= (Category) session.get(Category.class,cid);
 //       category1.setCname(category.getCname());
        category1.setAds(category.getAds());
        System.out.println(category1.getCname());
     //
        //   category1.setCid(category.getCid());
        session.save(category1);
        return "succesful";
    }

    @Transactional
    @RequestMapping(value = "category/{id}",method = RequestMethod.POST)
    @ResponseBody
    public Category getById(@PathVariable int id)  throws SQLException {
        session=sessionFactory.getCurrentSession();
        Category category = (Category) session.get(Category.class, id);
        return category;
    }


    @Transactional
    @RequestMapping(value = "category",method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getAllCategory()throws SQLException{
        session=sessionFactory.getCurrentSession();
        return session.createCriteria(Category.class).list();
    }

    @Transactional
    @RequestMapping(value = "/deletecatagory/{id}",produces = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public String deleteCategory(@PathVariable int id) throws SQLException {
        session=sessionFactory.getCurrentSession();
        Category c=(Category)session.get(Category.class,id);
        session.delete(c);
        return "category deleted";
    }
}
