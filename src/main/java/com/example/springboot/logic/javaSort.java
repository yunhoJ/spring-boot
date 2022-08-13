package com.example.springboot.logic;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Component// 빈으로 등록
public class javaSort <T extends Comparable<T>>implements Sort<T> {

    @Override
    public List<T> sort(List<T> list){
        List<T> output =new ArrayList<T>(list);
        Collections.sort(output);
        return output;
    }
}
