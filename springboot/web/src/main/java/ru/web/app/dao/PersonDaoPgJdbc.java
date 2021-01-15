package ru.web.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.web.app.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDaoPgJdbc {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDaoPgJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Person> index(){
        //тут так как у нас колонки и поля назывваются одинаоково можно стандартный роумаппер использовать
        return jdbcTemplate.query("Select * from Person",new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id){
       return jdbcTemplate.query("Select * from Person where id=?",new Object[]{id},new PersonMapper())
               .stream().findAny().orElse(null);
    }

    public void save(Person person){
       jdbcTemplate.update("insert  into Person Values(1,?,?,?)",
               person.getName(),person.getAge(),person.getEmail());
    }

    public void update(int id, Person updatePerson){

        jdbcTemplate.update("UPDATE Person SET name =?,age=?,email=?, where id=?",
                updatePerson.getName(),updatePerson.getAge(),updatePerson.getEmail(),id);

    }

    public void delete(int id){
        jdbcTemplate.update("DELETE from Person  where id=?",id);
    }

}
