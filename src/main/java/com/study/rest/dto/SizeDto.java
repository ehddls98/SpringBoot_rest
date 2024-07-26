package com.study.rest.dto;

import com.study.rest.entity.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

public class SizeDto {
    @Builder
    @Data
    //단건
    public static class Info {
        private int sizeId;
        private String sizeName;
    }

    public static List<Info> toList(List<Size> sizeList) {
        return sizeList.stream().map(Size::toDto).collect(Collectors.toList());
        // .stream(): sizeList 를 스트림으로 변환, 스트림은 컬렉션의 요소를 하나씩 참조하는 반복자와 유사
        // .map(Size::toDto) : 스트림으로 변환된 sizeList 의 각 Size 객체에 대해 toDto 메소드를 호출
        // (Size::toDto) : Size 클래스의 toDto 메소드를 호출하는 메소드 레퍼런스
        // .collect(Collectors.toList()) : 스트림의 요소(SizeDto.Info 객체)를 수집
        // 최종적으로 List<SizeDto.Info> 가 반환된다.
    }
}
