package com.epam.mentoring.creationalpatterns.singleton;

public class Runner {

    public static void main(String[] args) {
        SuperMan superMan = SuperMan.getInstance();
        SuperMan superManBro = SuperMan.getInstance();
    }
}
