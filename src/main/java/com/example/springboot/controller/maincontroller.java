package com.example.springboot.controller;

import com.example.springboot.service.SortService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController// 컨트롤러 포함 response바디 추가
public class maincontroller {

    private final SortService sortService;

    public maincontroller(SortService sortService) {
        this.sortService = sortService;
    }

    @GetMapping("/")
    public String hello(@RequestParam List<String> list){
        return sortService.doSort(list).toString();
    }
}
