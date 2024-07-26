package com.study.rest.service;

import com.study.rest.dto.*;
import com.study.rest.entity.Color;
import com.study.rest.entity.Product;
import com.study.rest.entity.Size;
import com.study.rest.repository.ColorMapper;
import com.study.rest.repository.ProductMapper;
import com.study.rest.repository.SizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private SizeMapper sizeMapper;
    @Autowired
    private ColorMapper colorMapper;

    @Override
    public List<SizeDto.Info> getSizeListAll() {
        return SizeDto.toList(sizeMapper.findAll());
    }

    @Override
    public List<Color> getColorListAll() {
        return colorMapper.findAll();
    }

    @Override
    public CommonResponseDto registerProduct(ProductDto.Register register) {
        return CommonResponseDto.ofDefault(productMapper.save(register.toEntity()));
        // 1. DTO 변환(register.toEntity())
        // ProductDto.Register 클래스에 정의된 toEntity() 메소드를 사용하여 DTO를 Entity로 변환한다.

        // 2. 데이터베이스 저장(productMapper.save(register.toEntity())
        //  1번에서 변환한 Entity를 productMapper.save() 메소드를 사용하여 데이터베이스에 저장한다.

        // 3. 응답 생성(CommonResponseDto.ofDefault())
        // CommonResponseDto.ofDefault() 메서드를 통해 2번에서 저장된 Product Entity를 CommonResponseDto 객체로 변환한다.
    }

    @Override
    public CommonResponseDto registerSize(ReqRegisterSizeDto reqRegisterSizeDto) {
//        Size size = Size.builder()
//                .sizeName(reqRegisterSizeDto.getSizeName())
//                .build();
//
//        int successCount = sizeMapper.save(size);
//        return CommonResponseDto.ofDefault(successCount);
        return CommonResponseDto.ofDefault(sizeMapper.save(reqRegisterSizeDto.toEntity()));
    }

    @Override
    public CommonResponseDto registerColor(ReqRegisterColorDto reqRegisterColorDto) {
        return CommonResponseDto.ofDefault(colorMapper.save(reqRegisterColorDto.toEntity()));
    }

}
