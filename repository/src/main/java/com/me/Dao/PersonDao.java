package com.me.Dao;

import com.me.entities.Person;

import java.util.List;

/* com.me.Dao
@Author:Peyman
Date: 14/02/2019
Time: 10:42 AM
Year: 2019
*/
public interface PersonDao {
    void save(Person person);
    void update(Person person);
    void delete(Long id);
    List<Person> selectAll();
}
