package com.me.Dao;

import com.me.entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/* com.me.Dao
@Author:Peyman
Date: 14/02/2019
Time: 10:42 AM
Year: 2019
*/
@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Person person) {
        sessionFactory.openSession().save(person);
    }

    @Override
    public void update(Person person) {
        sessionFactory.openSession().update(person);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person book = session.byId(Person.class).load(id);
        session.delete(book);
    /**   Session  session=sessionFactory.getObject().openSession();
        Person p = (Person) session.load(Person.class, new Integer(id));
        if(null != p){
            System.out.println(p);
            session.delete(p);
        }**/
    }

    @Override
    public List<Person> selectAll() {
        Query query = sessionFactory.openSession().createQuery("from Person");
        List<Person> persons = query.list();
        return persons;
    }
}
