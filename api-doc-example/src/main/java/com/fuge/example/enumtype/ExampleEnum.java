package com.fuge.example.enumtype;

public enum ExampleEnum {


    EXAMPLE(1,2,"a","b"),
    EXAMPLE1(10,20,"a1","b1"),
    EXAMPLE2(100,200,"a10","b10"),

    ;
    private final int code1;

    private final int code2;

    private final String msg1;

    private final String msg2;

    ExampleEnum(int code1, int code2, String msg1, String msg2) {
        this.code1 = code1;
        this.code2 = code2;
        this.msg1 = msg1;
        this.msg2 = msg2;
    }
}
