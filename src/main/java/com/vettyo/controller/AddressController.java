package com.vettyo.controller;

import com.vettyo.entity.Address;
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
public class AddressController {
    @Autowired
    SessionFactory sessionFactory;
    Session session;

    @Transactional
    @RequestMapping(value = "/address",method = RequestMethod.POST)
    @ResponseBody
    public String insertCategory(@RequestBody Address address) throws SQLException {
        session=sessionFactory.getCurrentSession();
        session.save(address);
        return "succesful";
    }


    @Transactional
    @RequestMapping(value = "address",method = RequestMethod.GET)
    @ResponseBody
    public List<Address> getAllCategory()throws SQLException{
        session=sessionFactory.getCurrentSession();
        return session.createCriteria(Address.class).list();
    }
}
