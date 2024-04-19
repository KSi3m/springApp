package org.example.dao;

import org.example.entity.Book;
import org.example.entity.Category;
import org.example.enums.DeletionStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImplementation implements CategoryDAO{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Category> getCategories() {
        Session currentSession = sessionFactory.getCurrentSession();
        //zapytanie
        Query<Category> query = currentSession.createQuery(" from Category", Category.class);
        List<Category> categories = query.getResultList();
        return categories ;
    }

    @Override
    public void saveCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
    }

    @Override
    public Category getCategory(int categoryid) {
        Session session = sessionFactory.getCurrentSession();
        Category category = session.get(Category.class, categoryid);
        return category;
    }

    @Override
    public void deleteCategory(int categoryid) {
        Session session = sessionFactory.getCurrentSession();
        var category = session.get(Category.class,categoryid);
        category.setStatus(String.valueOf(DeletionStatus.DELETED));
        session.update(category);
    }

    @Override
    public List<Category> getUndeletedCategories() {
        Session currentSession = sessionFactory.getCurrentSession();
        //zapytanie
        Query<Category> query = currentSession.createQuery(" from Category c WHERE c.status = '"+String.valueOf(DeletionStatus.NOT_DELETED)+"'", Category.class);
        List<Category> categories = query.getResultList();
        return categories ;
    }


}
