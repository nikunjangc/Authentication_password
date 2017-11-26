package com.company;

public class Main {

    public static void main(String[] args) {

        Authentication password=new Authentication();
        password.displayGeneral();
        password.generateRandom();
        password.checkRandomAndDefultPassword();
        password.userCode();
        password.checkValue();

    }
}