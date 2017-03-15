package com.github.apycazo.trivialis.client.services;

import com.github.apycazo.trivialis.client.providers.UserRecordManagerProvider;
import com.github.apycazo.trivialis.contract.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientDemoService
{
    @Autowired
    private UserRecordManagerProvider userRecordManagerProvider;

    @GetMapping("process")
    public List<UserRecord> getProcessedRecords ()
    {
        return userRecordManagerProvider.getAllRecords();
    }
}
