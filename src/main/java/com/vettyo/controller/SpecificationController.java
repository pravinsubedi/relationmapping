package com.vettyo.controller;

import com.vettyo.entity.Ad;
import com.vettyo.entity.Speciification;
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

/**
 * Created by pravin on 2/15/2017.
 */
@Controller
public class SpecificationController {

    @Autowired
    SessionFactory sessionFactory;
    Session session;

    @Transactional
    @RequestMapping(value = "/specification",method = RequestMethod.POST)
    @ResponseBody
    public String insertCategory(@RequestBody Speciification speciification) throws SQLException {
        session=sessionFactory.getCurrentSession();
        session.save(speciification);
        return "succesful";
    }
}
