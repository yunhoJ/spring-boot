package com.example.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

@ConstructorBinding
@ConfigurationProperties("my")//Configuration 이 없으면 빈스캔을 못해 에러 발생 @
//@Configuration root에 @ConfigurationPropertiesScan로 대체 가능
public class Myproperties {

    public int getHeight() {
        return Height;
    }



    private final int Height;

    public Myproperties(int height) {
        Height = height;
    }
}
