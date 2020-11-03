package com.xignitex.demoservice.usecase;

@FunctionalInterface
public interface UseCase <requestType, responseType>{
    responseType execute(requestType request);
}
