package ru.alex;

public class Main {

    public static void main(String[] args) {

        PostgreJdbc postgreJdbc = new PostgreJdbc();
        postgreJdbc.connect();
        postgreJdbc.InitialDb();
        postgreJdbc.generateFakeUsers();
        postgreJdbc.close();

    }
}
