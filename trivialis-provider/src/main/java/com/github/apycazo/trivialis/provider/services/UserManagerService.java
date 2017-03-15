package com.github.apycazo.trivialis.provider.services;

import com.github.apycazo.trivialis.contract.UserRecord;
import com.github.apycazo.trivialis.contract.UserRecordManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@ConditionalOnMissingBean(UserRecordManager.class)
public class UserManagerService implements UserRecordManager
{
    @RestController
    public static class UserManagerRestController extends UserManagerService {}

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class NotFoundError extends RuntimeException
    {
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    public class DuplicateIdError extends RuntimeException
    {
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public class EmptyBodyError extends RuntimeException
    {
    }

    private List<UserRecord> records;

    public UserManagerService()
    {
        records = new LinkedList<>();
        // init values
        records.add(UserRecord
                .builder()
                .id(1)
                .name("one")
                .enabled(true)
                .password("111")
                .roles(Arrays.asList("dev", "tester"))
                .build());
        records.add(UserRecord.builder()
                .id(2)
                .name("two")
                .enabled(true)
                .password("222")
                .roles(Arrays.asList("dev"))
                .build());
        records.add(UserRecord.builder()
                .id(3)
                .name("three")
                .enabled(true)
                .password("333")
                .roles(Arrays.asList("manager"))
                .build());
        records.add(UserRecord.builder()
                .id(4)
                .name("four")
                .enabled(false)
                .password("444")
                .roles(Arrays.asList("owner"))
                .build());

    }

    @Override
    public List<UserRecord> getAllRecords()
    {
        return records;
    }

    @Override
    public UserRecord findRecordById(@PathVariable(name = "id") Integer id)
    {
        Optional<UserRecord> result = records.stream().filter(r -> r.getId().equals(id)).findAny();
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new NotFoundError();
        }
    }

    @Override
    public void deleteRecord(@RequestBody UserRecord record)
    {
        records.remove(record);
    }

    @Override
    public UserRecord saveRecord(@RequestBody UserRecord record)
    {
        if (records.stream().anyMatch(r -> r.getId().equals(record.getId()))) {
            throw new DuplicateIdError();
        }

        else {
            records.add(record);
            return record;
        }
    }

    @Override
    public Integer countRecords()
    {
        return records.size();
    }


}
