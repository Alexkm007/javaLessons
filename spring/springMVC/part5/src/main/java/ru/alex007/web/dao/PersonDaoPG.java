package ru.alex007.web.dao;

import org.springframework.stereotype.Component;
import ru.alex007.web.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDaoPG {
    private static int PEOPLE_COUNT;
    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "12345";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> index(){
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "Select * from Person";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setAge(resultSet.getInt("age"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }

    public Person show(int id){
        Person person = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from person where id=?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            person = new Person();

            person.setId(resultSet.getInt("id"));
            person.setAge(resultSet.getInt("age"));
            person.setName(resultSet.getString("name"));
            person.setEmail(resultSet.getString("email"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;
    }

    public void save(Person person){
        PreparedStatement statement = null;
        try {
            String SQL = "insert  into Person Values(1,?,?,?)";
            statement = connection.prepareStatement(SQL);
            statement.setString(1,person.getName());
            statement.setInt(2,person.getAge());
            statement.setString(3,person.getEmail());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Person updatePerson){

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Person SET name =?,age=?,email=?, where id=?"
            );
            statement.setString(1,updatePerson.getName());
            statement.setInt(2,updatePerson.getAge());
            statement.setString(3,updatePerson.getEmail());
            statement.setInt(4,id);
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void delete(int id){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE from Person  where id=?"
            );
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
