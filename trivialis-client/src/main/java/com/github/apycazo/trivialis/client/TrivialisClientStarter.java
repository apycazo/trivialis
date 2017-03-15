package com.github.apycazo.trivialis.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrivialisClientStarter
{
    public static void main (String [] args)
    {
        new SpringApplication(TrivialisClientStarter.class).run(args);
    }
}
