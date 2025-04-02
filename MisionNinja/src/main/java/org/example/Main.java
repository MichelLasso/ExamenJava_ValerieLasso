package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    private String url="jdbc:mysql://ucc2go05yqdabxxv:koFiUzDL0hfr1jYg6OlG@bjtpm3mps8sawjsrbzsv-mysql.services.clever-cloud.com:3306/bjtpm3mps8sawjsrbzsv";
    private String userName= "ucc2go05yqdabxxv";
    private String password="koFiUzDL0hfr1jYg6OlG";

    Connection connect() throws SQLException{
        return DriverManager.getConnection(url, userName, password);
    }

}