package com.study.rest.Controller;

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
@RestController
public class BasicController {

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
}
