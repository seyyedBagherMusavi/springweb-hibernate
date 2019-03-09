package com.me.serviceContractImpl;

import com.me.Dao.PersonDao;
import com.me.entities.Person;
import com.me.serviceContracts.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/* com.me.serviceContractImpl
@Author:Peyman
Date: 14/02/2019
Time: 10:02 AM
Year: 2019
*/

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDao personDao;

    @Override
    @Transactional
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    @Transactional
    public void update(Person person) {
        personDao.update(person);
    }
    @Transactional
    @Override
    public void delete(int id) {
        personDao.delete(id);
    }

    @Override
    @Transactional
    public List<Person> selectAll() {
        return personDao.selectAll();
    }
}
