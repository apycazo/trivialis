package com.github.apycazo.trivialis.client.config;

import com.github.apycazo.trivialis.client.providers.UserRecordManagerProvider;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableFeignClients(basePackageClasses = UserRecordManagerProvider.class)
public class TrivialisClientConfigurer
{
}
