package com.xignitex.demoservice.usecase;

@FunctionalInterface
public interface UseCase <REQUEST_TYPE, RESPONSE_TYPE>{
    RESPONSE_TYPE execute(REQUEST_TYPE  request);
}
