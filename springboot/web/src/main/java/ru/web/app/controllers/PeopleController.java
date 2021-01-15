package ru.web.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.web.app.dao.PersonDaoPgJdbc;
import ru.web.app.models.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDaoPgJdbc personDAO;

    @Autowired
    public PeopleController(PersonDaoPgJdbc personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        //Получим всех людей из DAO и передадим на отображение в представление
        model.addAttribute("people",personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        //Получим одного человека по его id из DAO
        model.addAttribute("person",personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
// тут мы вручную добавляем в модель пустой person и передаем в форму
//    public String newPerson(Model model){
//        model.addAttribute("person",new Person());
//        return "people/new";
//    }
    public String newPerson(@ModelAttribute("person") Person person){ //тут через аннотацию тоже что и в ручную
        return "people/new";
    }

    @PostMapping()
    //@ModelAttribute("person") Person person - из данных пост запроса заполняется Person и передается в параметр
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult){
       if (bindingResult.hasErrors()) return "people/new";
       personDAO.save(person);
       return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person",personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") int id){
        if (bindingResult.hasErrors()) return "people/new";
        personDAO.update(id,person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }


}
