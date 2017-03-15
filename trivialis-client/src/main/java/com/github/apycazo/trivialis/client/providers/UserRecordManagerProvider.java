package com.github.apycazo.trivialis.client.providers;

import com.github.apycazo.trivialis.contract.UserRecordManager;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;

@Service
// Usually, name would point to service in eureka, here it is provided only as reference, since eureka is not present,
// but the field value is mandatory.
@FeignClient(name="http://trivialis-provider", url = "${services.trivialis.provider}")
public interface UserRecordManagerProvider extends UserRecordManager
{
}
