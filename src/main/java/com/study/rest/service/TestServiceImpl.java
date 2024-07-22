package com.study.rest.service;

import org.springframework.stereotype.Service;

@Service("ts") //컴포넌트의 이름을 ()안에 써서 내가 지정할 수 있다.
public class TestServiceImpl implements TestService {

    @Override
    public void test() {
        System.out.println("기존 단위 테스트 실행");
    }
}
