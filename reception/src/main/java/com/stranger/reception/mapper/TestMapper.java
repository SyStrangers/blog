package com.stranger.reception.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface TestMapper {

    public List<String> getTestList();
}
