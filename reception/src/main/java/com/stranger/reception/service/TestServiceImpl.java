package com.stranger.reception.service;

import com.stranger.reception.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl {

    @Autowired
    private TestMapper testMapper;


    public List<String> test(){
        return testMapper.getTestList();
    }
}
