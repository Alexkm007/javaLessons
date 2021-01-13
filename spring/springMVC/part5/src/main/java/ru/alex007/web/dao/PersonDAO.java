package ru.alex007.web.dao;

import org.springframework.stereotype.Component;
import ru.alex007.web.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Bob",21,"ss@gg.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Tom",25,"aa@gg.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Jek",44,"nn@gg.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Bil",23,"ff@gg.ru"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(people->people.getId()==id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson){
        Person person = show(id);
        person.setName(updatePerson.getName());
        person.setAge(updatePerson.getAge());
        person.setEmail(updatePerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(person -> person.getId()==id);
    }

}
