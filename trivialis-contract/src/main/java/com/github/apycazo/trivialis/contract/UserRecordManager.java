package com.github.apycazo.trivialis.contract;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserRecordManager
{
    @GetMapping("users")
    @ResponseStatus(HttpStatus.OK)
    List<UserRecord> getAllRecords();

    @GetMapping("users/{id}")
    @ResponseStatus(HttpStatus.OK)
    UserRecord findRecordById(@PathVariable Integer id);

    @DeleteMapping("users")
    @ResponseStatus(HttpStatus.OK)
    void deleteRecord(@RequestBody UserRecord record);

    @PostMapping("users")
    @ResponseStatus(HttpStatus.CREATED)
    UserRecord saveRecord(@RequestBody UserRecord record);

    @GetMapping("users/count")
    @ResponseStatus(HttpStatus.OK)
    Integer countRecords();
}
