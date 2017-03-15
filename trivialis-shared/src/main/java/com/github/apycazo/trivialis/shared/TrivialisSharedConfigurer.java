package com.github.apycazo.trivialis.shared;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
@ComponentScan
public class TrivialisSharedConfigurer
{
    @PostConstruct
    protected void logStatus ()
    {
        log.info("Using trivialis-shared features (To disable exclude class '{}')", getClass().getName());
    }
}
