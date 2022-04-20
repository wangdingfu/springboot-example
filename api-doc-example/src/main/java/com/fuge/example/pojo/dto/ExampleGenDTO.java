package com.fuge.example.pojo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExampleGenDTO<T> extends BasePageDTO {

    private T data;
}
