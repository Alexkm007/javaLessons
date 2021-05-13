package ru.alex.serializ;

import java.io.Serializable;

class Home implements Serializable {
private String home;

public Home(String home) {
        this.home = home;
        }

public String getHome() {
        return home;
        }
        }
