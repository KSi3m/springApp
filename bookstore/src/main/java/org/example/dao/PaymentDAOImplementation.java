package org.example.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class PaymentDAOImplementation implements PaymentDAO{


    @Autowired
    private SessionFactory sessionFactory;

}
