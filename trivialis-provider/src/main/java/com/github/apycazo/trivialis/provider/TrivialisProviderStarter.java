package com.github.apycazo.trivialis.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrivialisProviderStarter
{
    public static void main (String [] args)
    {
        new SpringApplication(TrivialisProviderStarter.class).run(args);
    }
}
