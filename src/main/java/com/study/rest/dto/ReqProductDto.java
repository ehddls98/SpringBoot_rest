package com.study.rest.dto;

import lombok.Data;

@Data
public class ReqProductDto {
    private String ProductName;
    private int price;
    private int sizeId;
    private int colorId;
}
