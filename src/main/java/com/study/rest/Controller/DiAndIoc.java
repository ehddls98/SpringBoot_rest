package com.study.rest.Controller;

import com.study.rest.di.A;
import com.study.rest.di.B;
import com.study.rest.di.C;
import com.study.rest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //Controller는 Component 안에 있다.
public class DiAndIoc { //IOC 컨테이너에 등록

    @Autowired
    private C c;

    @Autowired
    @Qualifier("ts") //클래스명이 IOC Container에 등록될때 자동으로 카멜 표기법으로 등록된다.
    private TestService testService1;

    @Autowired
    @Qualifier("newTestServiceImpl")
    private TestService testService2;

    @ResponseBody
    @GetMapping("/di")
    public Object di() {
        //A가 B를 의존하는 관계
        //외부에서 객체가 생성되었기 때문에 결합도는 낮은상태
        B b = new B();
        A a = new A(b);
        a.aCall();
        return null;
    }

    @ResponseBody
    @GetMapping("/ioc")
    public Object ioc() {
        c.cCall();
        return null;
    }

    @ResponseBody
    @GetMapping("/test")
    public Object startedTest(@RequestParam String type) {
        if("old".equals(type)) {
            testService1.test();
        } else {
            testService2.test();
        }
        return null;
    }
}
