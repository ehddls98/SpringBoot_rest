package com.study.rest.Controller;

import com.study.rest.dto.ReqProductDto;
import com.study.rest.dto.ReqStudentDto;
import com.study.rest.dto.ReqTeacherDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// REST API
@Slf4j
@RestController //responsebody와 controller가 들어있다.
public class BasicController {

    /**
     *
     * REST API
     * 데이터 통신을 위한 HTTP 요청 방식
     * HTTP(프로토콜)을 조금 더 잘 쓰기 위해서 정의된 개념
     * 1. 요청에 대한 동작은 무조건 메소드에 따라 정의하자.
     * - 데이터 추가(등록)은 POST 요청으로 하자, 그리고 POST 요청은 JSON 데이터로 요청하자.
     * - 데이터 조회는 GET 요청으로 하자,
     *      그리고 GET 요청은 QueryString(params) 으로 요청하자.
     *      예) 주소?key1=value1&key2=value2
     * - 데이터 수정은 PUT, PATCH 요청으로 하자, JSON 으로 요청하자.
     *      PUT 요청과 PATCH 요청의 차이점
     *      PUT 요청: 공백 또는 NULL 인 데이터도 수정을 함.
     *      PATCH 요청: 공백 또는 NULL 인 데이터는 수정을 하지 않음.(기존의 데이터를 업데이트 하지 않음)
     *      PUT 과 PATCH 의 요청 처리 방식은 하나의 약속이다. 실제 동작에는 차이가 없지만 약속을 해놓고 각 요청에 따라 동작을 하도록 만들어줘야 한다.
     * - 데이터 삭제는 DELETE 요청으로 하자, params 로 요청하자.
     *
     * 2. 주소(URL) 요청 메세지(Resource) 자원 작성법
     * - URL 은 가능한 동사를 사용하지 않는다.
     * - 계층 구조로 작성한다.
     *      예) /집/주방/가스레인지, /식당/주방/가스레인지
     * - 요청마다 메서드 마다 작성하는 방법이 다르다.(주소는 같지만 메소드마다 동작이 달라진다)
     *      상품 등록(POST) /product
     *      상품 하나(단건) 조회(GET) /product/1(id, key)
     *      상품 여러개(다건) 조회(GET) /products(전체) , /products?page=1&count=30(한페이지에 30개씩) -> 옵션이 없으면 전체, 있으면 옵션에 따라 다건 조회
     *      상품 수정(PUT) /product/1(id, key)
     *      상품 삭제(DELETE) /product/1(id, key)
     *
     * 3. 주소는 가능한 대문자를 사용하지 않는다.
     *
     *
     */

    @CrossOrigin //다른 도메인에서 이 서버로의 요청을 가능하게 한다.
    @PostMapping("/basic/student")
    // json => requestbody
    public ResponseEntity<?> basicPost(@RequestBody ReqStudentDto reqStudentDto) {
        log.info("student: {}", reqStudentDto);
        return ResponseEntity.ok().body(reqStudentDto);// ok -> 상태코드 200
    }

    @CrossOrigin
    @PostMapping("/basic/teacher")
    public ResponseEntity<?> basicPost(@RequestBody ReqTeacherDto reqTeacherDto) {
        log.info("teacher: {}", reqTeacherDto);
        return ResponseEntity.ok().body(reqTeacherDto);
    }

    @CrossOrigin
    @PostMapping("/basic/product")
    public ResponseEntity<?> registerProduct(@RequestBody ReqProductDto reqProductDto) {
        log.info("{}", reqProductDto);
        return ResponseEntity.ok().body(null);
    }
}
