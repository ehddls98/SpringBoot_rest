package com.study.rest.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C { //IOC 컨테이너에 컴포넌트로 등록

    @Autowired(required = false)
    private D d;

    public void cCall() {
        System.out.println("C 객체에서 메서드 호출");
        d.dCall();
    }
}
