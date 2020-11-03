package com.xignitex.demoservice.usecase;

@FunctionalInterface
public interface UseCase <Q, S>{
    S execute(Q request);
}
