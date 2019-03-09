package com.me.serviceContracts;

import com.me.entities.Person;

import java.util.List;

/* com.me.serviceContracts
@Author:Peyman
Date: 14/02/2019
Time: 10:02 AM
Year: 2019
*/
public interface PersonService {
    void save(Person person);
    void update(Person person);
    void delete(int id);
    List<Person> selectAll();
}
