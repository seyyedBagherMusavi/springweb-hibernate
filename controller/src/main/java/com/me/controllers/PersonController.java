package com.me.controllers;

import com.me.entities.Person;
import com.me.serviceContracts.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/* com.me.controllers
@Author:Peyman
Date: 14/02/2019
Time: 10:03 AM
Year: 2019
*/
@Controller
@RequestMapping("/")
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public String goHome(Model model){
        Person p = new Person();
        model.addAttribute("person",p);
        return "index";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("person") Person person,Model model, BindingResult result){
        if(result.hasErrors()){
           return "index";
        }
        System.out.println(person);
        personService.save(person);
        List<Person> p = personService.selectAll();
        model.addAttribute("persons",p);
        return "selectAll";
    }
    @GetMapping("/delete")
    public String save(@Valid @ModelAttribute("id") Long id,Model model){
        personService.delete(id);
        List<Person> p = personService.selectAll();
        model.addAttribute("persons",p);
        return "selectAll";
    }
}
