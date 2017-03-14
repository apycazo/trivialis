package com.github.apycazo.trivialis.contract;

import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRecord
{
    private Integer id;
    private String name;
    private String password;
    private List<String> roles;
    private Boolean enabled;
}
