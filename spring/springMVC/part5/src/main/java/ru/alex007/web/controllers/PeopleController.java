package ru.alex007.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alex007.web.dao.PersonDAO;
import ru.alex007.web.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
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
    public String craete(@ModelAttribute("person") Person person){
       personDAO.save(person);
       return "redirect:/people";
    }

}
