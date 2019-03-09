package com.me.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

/* com.me.entities
@Author:Peyman
Date: 14/02/2019
Time: 10:38 AM
Year: 2019
*/
@Entity
@Table(name = "tbl_person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Please enter your firstName")
    @Size(min = 5, max = 10, message = "نام نمیتواند کمتر از 5 کاراکتر باشد")
    private String name;

    private String family;
    private int age;

    public Person() {
        System.out.println("Created Default");
    }

    public Person(String name, String family, int age) {
        this.name = name;
        this.family = family;
        this.age = age;
        System.out.println("Created");

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                '}';
    }
}
