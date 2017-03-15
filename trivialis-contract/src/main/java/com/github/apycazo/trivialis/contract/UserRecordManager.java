package com.github.apycazo.trivialis.contract;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserRecordManager
{
    String basePath = "users";

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = basePath, method = RequestMethod.GET)
    List<UserRecord> getAllRecords();

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = basePath + "/{id}", method = RequestMethod.GET)
    UserRecord findRecordById(@PathVariable(name = "id") Integer id);

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = basePath, method = RequestMethod.DELETE)
    void deleteRecord(@RequestBody UserRecord record);

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = basePath, method = RequestMethod.POST)
    UserRecord saveRecord(@RequestBody UserRecord record);

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = basePath + "/count", method = RequestMethod.GET)
    Integer countRecords();
}
